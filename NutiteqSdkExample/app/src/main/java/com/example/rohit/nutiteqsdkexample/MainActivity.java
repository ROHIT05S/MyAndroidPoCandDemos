package com.example.rohit.nutiteqsdkexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nutiteq.ui.MapView;

public class MainActivity extends AppCompatActivity
{
    private MapView mapView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView.registerLicense("XTUN3Q0ZFRWxWSEtCSUk3bVJxN0pQYnRxc3dFb0ovaGhBaFE5TUN3MWFwZTVTRnptSm1oam5VV3RpaWVwL1E9PQoKcHJvZHVjdHM9c2RrLWFuZHJvaWQtMy4qCnBhY2thZ2VOYW1lPWNvbS5leGFtcGxlLnJvaGl0Lm51dGl0ZXFzZGtleGFtcGxlCndhdGVybWFyaz1udXRpdGVxCm9ubGluZUxpY2Vuc2U9MQp1c2VyS2V5PTQzZWU2MmJkNjk2NDNhNGQzMmNkMzUzMjk4NTdmM2MwCg==",this);
       // mapView = (MapView)this.findViewById(R.id.)
    }



}
