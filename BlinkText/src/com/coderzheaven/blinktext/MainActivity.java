package com.coderzheaven.blinktext;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blinkText();
        //blinkText2();
    }
    
    private void blinkText(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
            int timeToBlink = 1000;    //in milissegunds
            try{
            	Thread.sleep(timeToBlink);
        	}catch (Exception e) {
        		
        	}
            handler.post(new Runnable() {
                @Override
                    public void run() {
                    TextView txt = (TextView) findViewById(R.id.tv);
                    if(txt.getVisibility() == View.VISIBLE){
                        txt.setVisibility(View.INVISIBLE);
                    }else{
                        txt.setVisibility(View.VISIBLE);
                    }
                    blinkText();
                }
                });
            }}).start();
   }
    
    public void blinkText2(){
    	TextView myText = (TextView) findViewById(R.id.tv );

    	Animation anim = new AlphaAnimation(0.0f, 1.0f);
    	anim.setDuration(50); //You can manage the time of the blink with this parameter
    	anim.setStartOffset(20);
    	anim.setRepeatMode(Animation.REVERSE);
    	anim.setRepeatCount(Animation.INFINITE);
    	myText.startAnimation(anim);
    }
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
