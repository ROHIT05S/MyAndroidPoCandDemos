/*Working With Android XMl Animations: Android Fade Out Animation*/
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
public class AndroidFadeInAnimationActivity extends AppCompatActivity {

    ImageView imageView;

    //Android Animation
    Animation fadeOutAndroidAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_xml_animation_layout);

        imageView = (ImageView) findViewById(R.id.android_animation);
        fadeOutAndroidAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        imageView.setAnimation(fadeOutAndroidAnimation);
    }
}
