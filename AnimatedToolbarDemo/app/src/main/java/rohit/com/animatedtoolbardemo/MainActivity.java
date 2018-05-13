package rohit.com.animatedtoolbardemo;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{

    Button animatedToolbar,discrollView,expandableLayout,rippleEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUIandeventListener();
    }

    private void initUIandeventListener()
    {
      animatedToolbar = (Button)findViewById(R.id.animated_toolbar);
        discrollView = (Button)findViewById(R.id.discroll_view);
        expandableLayout = (Button)findViewById(R.id.expandable_layout);
        rippleEffect = (Button)findViewById(R.id.ripple_effect);
        animatedToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AnimatedToolBarActivity.class);
                startActivity(intent);
            }
        });
        discrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DiscrollViewActivity.class);
                startActivity(intent);
            }
        });
        expandableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ExpandableLayoutActivity.class);
                startActivity(intent);
            }
        });
        rippleEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RippleEffectActivity.class);
                startActivity(intent);
            }
        });
    }
}
