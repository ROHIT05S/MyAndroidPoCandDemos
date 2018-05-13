package com.woodward.androidaccesscontentprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button displayContentButton = (Button)findViewById(R.id.dispaly_content);
        displayContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayIntent = new Intent(SplashActivity.this, DisplayContentActivity.class);
                startActivity(displayIntent);
            }
        });
        Button addContentButton = (Button)findViewById(R.id.add_new_content);
        addContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(SplashActivity.this, AddContentActivity.class);
                startActivity(addIntent);
            }
        });
    }
}
