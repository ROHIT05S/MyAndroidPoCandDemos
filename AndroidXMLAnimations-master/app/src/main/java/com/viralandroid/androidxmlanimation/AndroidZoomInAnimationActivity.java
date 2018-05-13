/*Working With Android XMl Animations: Android Zoom In Animation*/
package com.viralandroid.androidxmlanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by HP on 10/20/2016.
 */
public class AndroidZoomInAnimationActivity extends AppCompatActivity {

    //Android XML Animation
    Animation androidZoomInAnimation;

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_xml_animation_layout);

        imageView = (ImageView) findViewById(R.id.android_animation);
        androidZoomInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_animation);
        imageView.startAnimation(androidZoomInAnimation);
    }
}
