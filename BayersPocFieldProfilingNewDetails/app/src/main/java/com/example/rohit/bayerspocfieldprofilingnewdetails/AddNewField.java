package com.example.rohit.bayerspocfieldprofilingnewdetails;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewField extends AppCompatActivity
{

    Button addnewField,profitLoss;
  //  private ArrayList<String> daata;
  private ArrayList<String> fieldName;
    private ArrayList<String> cropName;
    private ArrayList<String> fieldArea;

    TextView textViewvillagename;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_field);
        initView();
        addnewField = (Button)findViewById(R.id.button_addanewfield);
        profitLoss = (Button)findViewById(R.id.button4_profitLoss);
        profitLoss.setText("Profit & Loss");
        addnewField.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AddNewField.this,AddNewFieldForm.class);
                startActivity(intent);
            }
        });

    }

    private void initView()
    {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setVerticalScrollBarEnabled(true);
       fieldName = new ArrayList<>();
        fieldArea = new ArrayList<>();
        cropName = new ArrayList<>();
        fieldArea.add("4acres");
        fieldArea.add("8acres");
        fieldArea.add("12acres");
        fieldName.add("F1");
        fieldName.add("F2");
        fieldName.add("F2");
        cropName.add("pineapple");
        cropName.add("Tomato");
        cropName.add("Apple");

        RecyclerView.Adapter adapter = new DataAdapterforRecyclerViews(cropName,fieldName,fieldArea);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)
            {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e)
            {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


    }
}
