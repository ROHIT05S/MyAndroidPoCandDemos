package com.example.rohit.roughproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView)findViewById(R.id.text1);
        String str_origin = "origin="+12.9846+","+77.6622;
        String str_dest = "destination="+37.534+","+ -82.0999;
        String sensor = "sensor=false";
       String parameters = str_origin+"&"+str_dest+"&"+sensor;
        String output = "json";
        String    url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        t.setText(url.toString());

        Log.d("urrl",url);
    }
}
