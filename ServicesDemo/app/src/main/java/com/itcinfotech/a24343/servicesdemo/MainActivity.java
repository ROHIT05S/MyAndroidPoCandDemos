package com.itcinfotech.a24343.servicesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Intent serviceIntent;
    Button buttonStart, buttonStop,buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()
    {
        Log.i("Thread", "In ServiceActivity :"+Thread.currentThread().getId());


       /* findViewById(R.id.start).setOnClickListener(startService);
        findViewById(R.id.stop).setOnClickListener(stopService);*/
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

    }
   /* private View.OnClickListener startService = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            serviceIntent = new Intent(getApplicationContext(), MyService.class);
            startService(serviceIntent);
        }
    };

    private View.OnClickListener stopService = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };*/

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.buttonStart:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.buttonStop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.buttonNext:
                Intent intent=new Intent(this,NextPage.class);
                startActivity(intent);
                break;
        }
    }
}

