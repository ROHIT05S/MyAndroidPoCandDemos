package com.example.rohit.demorecyclerviews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rohit on 30-03-2018.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder
{

    public TextView title;
    public ImageView imageview;




    public RecyclerViewHolder(View view) {
        super(view);
        // Find all views ids

        this.title = (TextView) view
                .findViewById(R.id.title);
        this.imageview = (ImageView) view
                .findViewById(R.id.image);


    }

}
