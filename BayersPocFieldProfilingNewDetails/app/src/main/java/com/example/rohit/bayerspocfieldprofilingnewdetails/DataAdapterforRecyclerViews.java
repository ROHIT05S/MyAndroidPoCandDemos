package com.example.rohit.bayerspocfieldprofilingnewdetails;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.start;

/**
 * Created by Rohit on 30-03-2017.
 */

public class DataAdapterforRecyclerViews extends RecyclerView.Adapter<DataAdapterforRecyclerViews.ViewHolder> implements View.OnClickListener
{
    private ArrayList<String> fieldName;
    private ArrayList<String> cropName;
    private ArrayList<String> fieldArea;

    public DataAdapterforRecyclerViews(ArrayList<String> fieldName,ArrayList<String> cropName,ArrayList<String> fieldArea)
    {
       this.cropName=cropName;
        this.fieldArea = fieldArea;
        this.fieldName =fieldName;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrowview,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapterforRecyclerViews.ViewHolder holder, int position)
    {

        holder.fieldname.setText(fieldName.get(position));
        holder.cropname.setText(cropName.get(position));
        holder.fieldArea.setText(fieldArea.get(position));


    }

    @Override
    public int getItemCount() {
        return fieldArea.size();


    }

    @Override
    public void onClick(View v)
    {


    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView villagename,fieldname,fieldArea,cropname;
        private ImageView cropimage,fieldimage;
        public ViewHolder(View itemView)
        {
            super(itemView);
          //  villagename = (TextView)itemView.findViewById(R.id.textView22_vilagename);
            fieldArea = (TextView)itemView.findViewById(R.id.textView19_fieldArea);
            fieldname = (TextView)itemView.findViewById(R.id.textView17_fieldName);
            cropname = (TextView)itemView.findViewById(R.id.textView18_CropName);
            cropimage = (ImageView)itemView.findViewById(R.id.imageView4_cropImage);
            fieldimage = (ImageView)itemView.findViewById(R.id.imageView5_fieldImage);




        }
    }
}
