package com.example.rohit.demorecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerView_Activity extends AppCompatActivity {

    private static RecyclerView recyclerView;

    //String and Integer array for Recycler View Items
    public static final String[] TITLES= {"Hood","Full Sleeve Shirt","Shirt","Jean Jacket","Jacket","Hood","Full Sleeve Shirt","Shirt","Jean Jacket","Jacket","Hood","Full Sleeve Shirt","Shirt","Jean Jacket","Jacket","Hood","Full Sleeve Shirt","Shirt","Jean Jacket","Jacket"};
    public static final Integer[] IMAGES= {R.drawable.fame,R.drawable.fame_grey,R.drawable.fertilizer,R.drawable.sencor,R.drawable.sencor_grey,R.drawable.fame,R.drawable.fame_grey,R.drawable.fertilizer,R.drawable.sencor,R.drawable.sencor_grey,R.drawable.fame,R.drawable.fame_grey,R.drawable.fertilizer,R.drawable.sencor,R.drawable.sencor_grey,R.drawable.fame,R.drawable.fame_grey,R.drawable.fertilizer,R.drawable.sencor,R.drawable.sencor_grey,};


    private static String navigateFrom;//String to get Intent Value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        initViews();
        populatRecyclerView();
    }

    // Initialize the view
    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Set Back Icon on Activity

        navigateFrom = getIntent().getStringExtra("navigateFrom");//Get Intent Value in String

        recyclerView = (RecyclerView)
                findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //Set RecyclerView type according to intent value
        if (navigateFrom.equals("horizontal")) {
            getSupportActionBar().setTitle("Horizontal Recycler View");
            recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerView_Activity.this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // do whatever
                            Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                        }

                        @Override public void onLongItemClick(View view, int position) {
                            // do whatever
                        }
                    })
            );
        } else {
            getSupportActionBar().setTitle("Staggered GridLayout Manager");
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));// Here 2 is no. of columns to be displayed
            //recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerView_Activity.this, LinearLayoutManager.VERTICAL, false));

         /* recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
              @Override
              public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                  return false;
              }

              @Override
              public void onTouchEvent(RecyclerView rv, MotionEvent e) {

              }

              @Override
              public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

              }
          });*/
            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // do whatever
                            Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                        }

                        @Override public void onLongItemClick(View view, int position) {
                            // do whatever
                        }
                    })
            );


        }
    }


    // populate the list view by adding data to arraylist
    private void populatRecyclerView() {
        ArrayList<DataModel> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new DataModel(TITLES[i],IMAGES[i]));
        }
        RecyclerView_Adapter  adapter = new RecyclerView_Adapter(RecyclerView_Activity.this, arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter

    }

}
