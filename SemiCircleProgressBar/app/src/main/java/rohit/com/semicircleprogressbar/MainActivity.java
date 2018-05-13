package rohit.com.semicircleprogressbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView textValue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textValue = (TextView)findViewById(R.id.textValue);
        SemiCircleProgressBarView semiCircleProgressBarView = (SemiCircleProgressBarView) findViewById(R.id.progress);
        semiCircleProgressBarView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        semiCircleProgressBarView.setClipping(200);


       // semiCircleProgressBarView.setBackground(R.drawable.border_image);

        textValue.setText("200");
       // textValue.setTextColor(Color.WHITE);
    }
}
