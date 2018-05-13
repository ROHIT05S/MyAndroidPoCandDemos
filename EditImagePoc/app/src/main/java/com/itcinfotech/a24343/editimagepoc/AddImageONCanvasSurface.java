package com.itcinfotech.a24343.editimagepoc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddImageONCanvasSurface extends AppCompatActivity
{

    ImageView imageview;
    Button button,button2;
    Bitmap bitmap1,bitmap2;
    Canvas canvas;
    Paint paint;
    Resources resources;
    int BitmapSize = 30;
    int width, height;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image_oncanvas_surface);
        imageview = (ImageView)findViewById(R.id.imageView1);
        button = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        paint = new Paint();

        resources = getResources();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateBitmap();

                GetBitmapWidthHeight();

                bitmap2 = Bitmap.createBitmap(
                        width,
                        height,
                        Bitmap.Config.RGB_565
                );
                DrawCanvas();

                imageview.setImageBitmap(bitmap2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               // canvas = new Canvas(bitmap2);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                /*CreateBitmap();

                GetBitmapWidthHeight();

                bitmap2 = Bitmap.createBitmap(
                        width,
                        height,
                        Bitmap.Config.RGB_565
                );
                DrawCanvas();

                imageview.setImageBitmap(bitmap2);*/
            }
        });
    }
    public void CreateBitmap(){

        bitmap1 = BitmapFactory.decodeResource(
                resources,
                R.drawable.profile
        );

    }

    public void GetBitmapWidthHeight(){

        width = bitmap1.getWidth() + BitmapSize * 2;
        height = bitmap1.getHeight() + BitmapSize * 2;

    }

    public void DrawCanvas(){

        canvas = new Canvas(bitmap2);

        canvas.drawColor(Color.CYAN);

        canvas.drawBitmap(
                bitmap1,
                BitmapSize,
                BitmapSize,
                null
        );
        canvas.drawCircle(50,50,50,paint);

    }
}
