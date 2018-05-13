package com.viralandroid.androidxmlanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button zoomInAnimation, zoomOutAnimation, fadeInAnimation, fadeOutAnimation, moveAnimation, rotateAnimation, blinkAnimation, crossFadeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void androidZoomInAnimation(View view) {
        Intent intent1 = new Intent(this, AndroidZoomInAnimationActivity.class);
        startActivity(intent1);
    }

    public void androidZoomOutAnimation(View view) {
        Intent intent2 = new Intent(this, AndroidZoomOutAnimationActivity.class);
        startActivity(intent2);
    }

    public void androidFadeInAnimation(View view) {
        Intent intent3 = new Intent(this, AndroidFadeInAnimationActivity.class);
        startActivity(intent3);
    }

    public void androidFadeOutAnimation(View view) {
        Intent intent4 = new Intent(this, AndroidFadeOutAnimationActivity.class);
        startActivity(intent4);
    }

    public void androidMoveAnimation(View view) {
        Intent intent5 = new Intent(this, AndroidMoveAnimationActivity.class);
        startActivity(intent5);
    }

    public void androidRotateAnimation(View view) {
        Intent intent6 = new Intent(this, AndroidRotateAnimationActivity.class);
        startActivity(intent6);
    }

    public void androidBlinkAnimation(View view) {
        Intent intent7 = new Intent(this, AndroidBlinkAnimationActivity.class);
        startActivity(intent7);
    }

    public void androidSlideDownAnimation(View view) {
        Intent intent8 = new Intent(this, AndroidSlideDownAnimationActivity.class);
        startActivity(intent8);
    }

    public void androidSlideUpAnimation(View view) {
        Intent intent9 = new Intent(this, AndroidSlideUpAnimationActivity.class);
        startActivity(intent9);
    }

    public void androidBounceAnimation(View view) {
        Intent intent10 = new Intent(this, AndroidBounceAnimationActivity.class);
        startActivity(intent10);
    }

    public void androidSequentialAnimation(View view) {
        Intent intent11 = new Intent(this, AndroidSequentialAnimationActivity.class);
        startActivity(intent11);
    }
}