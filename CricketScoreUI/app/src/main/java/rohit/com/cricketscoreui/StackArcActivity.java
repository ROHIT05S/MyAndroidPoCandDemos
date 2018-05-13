package rohit.com.cricketscoreui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import devlight.io.library.ArcProgressStackView;

public class StackArcActivity extends AppCompatActivity
{

   // private String bgColors[]={"#000000","#ffffff","#7feaff","#7fff94"};
    //private String mStartColors[]={"#000000","#ffffff","#7feaff","#7fff94"};
   ArcProgressStackView arcProgressStackView;
    private int bgColors[] = { R.color.whitecolor,R.color.whitecolor,R.color.whitecolor,R.color.whitecolor};
    private int mStartColors[] = { R.color.colorGreen1,R.color.whitecolor,R.color.colorgreen,R.color.darkbrown};
   // private int mStartColors[] = { R.color.colorAccent,R.color.colorHint,R.color.colorPrimary,R.color.colorPrimaryDark};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_arc);
        arcProgressStackView = (ArcProgressStackView) findViewById(R.id.apsv);
        final ArrayList<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("", 60, bgColors[0], mStartColors[0]));
        models.add(new ArcProgressStackView.Model("", 65, bgColors[1], mStartColors[1]));
        models.add(new ArcProgressStackView.Model("", 70, bgColors[2], mStartColors[2]));
        models.add(new ArcProgressStackView.Model("", 60, bgColors[3], mStartColors[3]));


        arcProgressStackView.setModels(models);
        arcProgressStackView.setAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator animation) {
                // Update goes here
                Log.d("onAnimationUpdate: ", String.valueOf(animation.getAnimatedValue()));
            }
        });
        arcProgressStackView.setAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animation) {
                Toast.makeText(StackArcActivity.this, "ANIMATION", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
