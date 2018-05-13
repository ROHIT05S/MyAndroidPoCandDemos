package rohit.com.singlecontextdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

//    MyApplication myApplication;
    Button click;
    EditText scoreET;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button)findViewById(R.id.button_ok);
        scoreET = (EditText)findViewById(R.id.editText_et);
//        final MyApplication globalVariable = (MyApplication) getApplicationContext();
       /* click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApplication.getAppContext(),OtherActivity.class);
                startActivity(intent);
                Toast.makeText(MyApplication.getAppContext(),"Hello Application",Toast.LENGTH_LONG).show();
            }
        });*/
//        myApplication = new MyApplication();


    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MyApplication state = ((MyApplication) getApplicationContext());
        scoreET.setText(String.valueOf(state.getGameScore()));
    }
    public void incrementScore(View view)
    {
        MyApplication state = ((MyApplication) getApplicationContext());
        state.incrementScore();
        scoreET.setText(String.valueOf(state.getGameScore()));
    }
    public void nextScreen(View view)
    {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }
}
