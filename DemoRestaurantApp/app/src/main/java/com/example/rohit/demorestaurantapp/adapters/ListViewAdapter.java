package com.example.rohit.demorestaurantapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rohit.demorestaurantapp.R;

/**
 * Created by Rohit on 26-09-2017.
 */

public class ListViewAdapter extends BaseAdapter
{
    private Context mContext;
    private String[] foods;

    public ListViewAdapter(Context context, String[] foods)
    {
        mContext = context;
        this.foods = foods;
    }

    @Override
    public int getCount() {
        return foods.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View list;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            list = new View(mContext);
            list = inflater.inflate(R.layout.custom_grid, null);
            TextView textView = (TextView) list.findViewById(R.id.imageText);
            textView.setText(foods[position]);

        } else {
            list = (View) convertView;
        }
        return list;
    }
}
