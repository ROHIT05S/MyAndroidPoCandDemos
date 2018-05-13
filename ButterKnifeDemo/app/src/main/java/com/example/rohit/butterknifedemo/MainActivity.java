package com.example.rohit.butterknifedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

    @BindView(R.id.textView1)
    TextView title;
    @OnClick(R.id.buttonOk)
    public void submit1()
    {
        Toast.makeText(getApplicationContext(),"YOU CLICKED BUTTERKNIFE sdfsdfds OK BUTTON",Toast.LENGTH_LONG).show();
    }
    public void submit212()
    {
        Toast.makeText(getApplicationContext(),"YOU CLICKED BUTTERKNIFE OK BUTTON",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title.setText("A BUTTERKNIFE DEMO");
    }
}
