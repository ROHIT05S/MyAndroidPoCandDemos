package com.example.rohit.demorestaurantapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohit.demorestaurantapp.R;

/**
 * Created by Rohit on 26-09-2017.
 */

public class GridViewAdapter extends BaseAdapter
{

    private Context mContext;
    private final String[] dishes;
    private final int[] Imageid;

    public GridViewAdapter(Context c, String[] dishes, int[] imageid) {
        mContext = c;
        this.dishes = dishes;
        Imageid = imageid;
    }

    @Override
    public int getCount() {
        return dishes.length;
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
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.imageText);
            ImageView imageView = (ImageView)grid.findViewById(R.id.image_grid_view);
            textView.setText(dishes[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;

    }
}
