package rohit.com.semicircleprogressbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by 24343 on 12/7/2017.
 */

public class SemiCircleProgressBarView extends View
{
    private Path mClippingPath;
    private Path mClippingPath1;
    private Context mContext;
    private Bitmap mBitmap;
    private float mPivotX;
    private float mPivotY;
    private float mOvalX;
    private float mOvalY;
    Paint paint;
    public SemiCircleProgressBarView(Context context)
    {
        super(context);
        mContext = context;
        initilizeImage();
    }

    public SemiCircleProgressBarView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mContext = context;
        initilizeImage();
    }

    /*public SemiCircleProgressBarView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initilizeImage();
    }

    public SemiCircleProgressBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        initilizeImage();
    }*/
    private void initilizeImage() {
        mClippingPath = new Path();

        //Top left coordinates of image. Give appropriate values depending on the position you wnat image to be placed
        mPivotX = getScreenGridUnit();
        mPivotY = 0;
        Drawable d = getResources().getDrawable(R.drawable.circular_shape);

        //Adjust the image size to support different screen sizes
      //  Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.circle1);
        int w = d.getIntrinsicWidth() > 0 ? d.getIntrinsicWidth() : (int) (getScreenGridUnit() * 30);
        int h = d.getIntrinsicHeight() > 0 ? d.getIntrinsicHeight() : (int) (getScreenGridUnit() * 30);
        GradientDrawable g = (GradientDrawable) d;

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        g.setBounds(0,0, w, h);
        g.setStroke(3, Color.BLACK);


        g.setFilterBitmap(true);


        g.draw(canvas);


        //return bitmap;
      /*  int imageWidth = (int) (getScreenGridUnit() * 30);
        int imageHeight = (int) (getScreenGridUnit() * 30);*/
        mBitmap = Bitmap.createScaledBitmap(bitmap, w, h, false);
    }

    public void setClipping(float progress)
    {

        //Convert the progress in range of 0 to 100 to angle in range of 0 180. Easy math.
//        float angle = (progress * 180) / 100;
        float angle = (progress * 90) / 100;
        mClippingPath.reset();
        //Define a rectangle containing the image
        RectF oval = new RectF(mPivotX, mPivotY, mPivotX + mBitmap.getWidth(), mPivotY + mBitmap.getHeight());
        //Move the current position to center of rect
        mClippingPath.moveTo(oval.centerX(), oval.centerY());

        //Draw an arc from center to given angle

        mClippingPath.addArc(oval, 180, angle);

        //Draw a line from end of arc to center

       mClippingPath.lineTo(oval.centerX(), oval.centerY());


        //Redraw the canvas
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);
        paint.setDither(true);
      //  paint.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.STROKE);
      //  canvas.drawCircle(50, 50, 30, paint);
     /*   canvas.drawOval(new RectF(50,50,50,50),paint);
        canvas.drawArc(new RectF(50,50,50,50),50,50,true,paint);*/

      /*  RectF rectF = new RectF(50, 20, 100, 80);
        canvas.drawOval(rectF, paint);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        canvas.drawArc (rectF, 90, 45, true, paint);*/
        //Clip the canvas
        canvas.clipPath(mClippingPath);
//        canvas.drawLine(0,100,0,100,paint);



//        canvas.drawPath(mClippingPath1,paint);

        canvas.drawBitmap(mBitmap, mPivotX, mPivotY, null);
        canvas.drawLine(10,0,200,200,paint);









      //  canvas.drawText("70",700,700,paint);
       // canvas.dr
        /*float width = (float) getWidth();
        float height = (float) getHeight();
        float radius;

        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 4;
        }

        Path path = new Path();
        path.addCircle(width / 2,
                height / 2, radius,
                Path.Direction.CW);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);

        center_x = width / 2;
        center_y = height / 2;

        oval.set(center_x - radius,
                center_y - radius,
                center_x + radius,
                center_y + radius);
        canvas.drawArc(oval, 90, 180, false, paint);*/
    }



    private float getScreenGridUnit() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels / 32;
    }


}
