package com.rohit.apicallsdemousinginterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
{
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btn_getdata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APICAlls apicAlls = new APICAlls();
                String response = apicAlls.getData(URLS.business_news_url);
                Log.d("response",response);
                tv.setText(response);
            }
        });


    }
}
