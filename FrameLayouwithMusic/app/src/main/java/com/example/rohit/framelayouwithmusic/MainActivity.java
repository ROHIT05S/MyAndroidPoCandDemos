package com.example.rohit.framelayouwithmusic;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    AnimatorSet set;
    ImageView imgView;
    TextView tv;
    int imgResources[]={R.drawable.user, R.drawable.arrow};
    int index=0;
    Animation animTogether;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
       // ImageView imgView=(ImageView)findViewById(R.id.imageview);
        TextView tv=(TextView)findViewById(R.id.text);
        animTogether = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);

        tv.startAnimation(animTogether);

        // Together
      /*  btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTog.startAnimation(animTogether);
            }
        });*/
       /* set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.wave);
        set.setTarget(imgView);
        set.start();*/
    }
}
