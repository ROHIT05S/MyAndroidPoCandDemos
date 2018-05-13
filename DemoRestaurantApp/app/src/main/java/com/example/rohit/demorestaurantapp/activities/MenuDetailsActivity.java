package com.example.rohit.demorestaurantapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rohit.demorestaurantapp.R;
import com.example.rohit.demorestaurantapp.adapters.ListViewAdapter;
import com.example.rohit.demorestaurantapp.models.MenuDetails;

public class MenuDetailsActivity extends AppCompatActivity
{
    TextView cart_text_view;
    ListView listView;
    int noOfItems,priceOfItems;
    private String [] foodItems;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        initViews();
        getDatafromFirstActivity();
        setUpListView();

    }



    private void getDatafromFirstActivity()
    {
        if (getIntent().hasExtra("foodItems"))
        {
            foodItems = getIntent().getStringArrayExtra("foodItems");

        }
    }

    private void initViews()
    {
        cart_text_view = (TextView)findViewById(R.id.text_view_cart);
        listView = (ListView)findViewById(R.id.list_view_menudetails);
    }
    private void setUpListView()
    {
        ListViewAdapter listViewAdapter = new ListViewAdapter(MenuDetailsActivity.this,foodItems);
        listView.setAdapter(listViewAdapter);
    }

}
