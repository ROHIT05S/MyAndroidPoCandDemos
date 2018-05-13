package com.example.rohit.demopicassolibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
{
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView1);
        Picasso.with(this)  //Here, this is context.
                .load("http://www.imagefully.com/wp-content/uploads/2015/06/Welcome-Pics-And-Colorful-Image.jpg")  //Url of the image to load.
                .into(imageView);

    }
}
