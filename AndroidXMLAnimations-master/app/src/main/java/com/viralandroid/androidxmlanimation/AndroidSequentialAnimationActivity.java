/*Working With Android XMl Animations: Android Sequential Animation*/
package com.viralandroid.androidxmlanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AndroidSequentialAnimationActivity extends AppCompatActivity {

    //Android XML Animation
    Animation sequentialAnimation;

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_xml_animation_layout);

        imageView = (ImageView) findViewById(R.id.android_animation);
        sequentialAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential_animation);
        imageView.startAnimation(sequentialAnimation);
    }
}