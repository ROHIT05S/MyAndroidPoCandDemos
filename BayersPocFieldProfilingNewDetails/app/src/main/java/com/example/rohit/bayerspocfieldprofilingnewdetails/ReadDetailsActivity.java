package com.example.rohit.bayerspocfieldprofilingnewdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rohit.bayerspocfieldprofilingnewdetails.Database.UpadateChangeActivity;

public class ReadDetailsActivity extends AppCompatActivity
{

    TextView textViewheading;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_details);
       /* textViewheading = (TextView)findViewById(R.id.textView14readetails);
        textViewheading.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ReadDetailsActivity.this, UpadateChangeActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
