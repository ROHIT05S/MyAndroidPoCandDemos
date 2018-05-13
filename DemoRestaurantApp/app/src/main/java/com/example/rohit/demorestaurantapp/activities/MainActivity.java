package com.example.rohit.demorestaurantapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.rohit.demorestaurantapp.R;
import com.example.rohit.demorestaurantapp.adapters.GridViewAdapter;
import com.example.rohit.demorestaurantapp.models.MenuDetails;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener
public class MainActivity extends AppCompatActivity
{
    GridView gridView;
    String[] dishes = {"Veg","Non-Veg","Chinese","Italian"} ;
    int[] imageId = {R.drawable.vegfoods, R.drawable.nonveg, R.drawable.chinese, R.drawable.italian};
    String[] food_items;
    MenuDetails menuDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpViews();
        viewClickEventHandler();


    }



    private void initViews()
    {
        gridView = (GridView)findViewById(R.id.gridView);


    }
    private void setUpViews()
    {
        GridViewAdapter gridAdapter = new GridViewAdapter(MainActivity.this,dishes,imageId);
        gridView.setAdapter(gridAdapter);
    }
    private void viewClickEventHandler()
    {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent;
                switch (position)
                {
                    case 0:
                        String[] vegfoodItems = {"Paneer","DalFry","Rajma","Chole","Mushroom"};
                        intent= new Intent(MainActivity.this,MenuDetailsActivity.class);
                        intent.putExtra("foodItems",vegfoodItems);
                        startActivity(intent);
                        break;

                    case 1:
                        String[] nonVegfoodItems = {"Chicken","Mutton","Fish","Prawns"};

                         intent = new Intent(MainActivity.this,MenuDetailsActivity.class);
                        intent.putExtra("foodItems",nonVegfoodItems);
                        startActivity(intent);
                        break;
                    case 2:
                        String[] chinesefoodItems = {"Noodles","Rice","Manchurian"};

                        intent = new Intent(MainActivity.this,MenuDetailsActivity.class);
                        intent.putExtra("foodItems",chinesefoodItems);
                        startActivity(intent);
                        break;
                    case 3:
                        String[] italianfoodItems = {"A","B","C","D","E"};
                        intent = new Intent(MainActivity.this,MenuDetailsActivity.class);
                        intent.putExtra("foodItems",italianfoodItems);
                        startActivity(intent);
                        break;


                }


            }
        });
    }

   /* @Override
    public void onClick(View v)
    {


    }*/
}
