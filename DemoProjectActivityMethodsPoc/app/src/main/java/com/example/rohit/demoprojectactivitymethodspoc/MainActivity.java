package com.example.rohit.demoprojectactivitymethodspoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private static final String HOME_ACTIVITY_TAG = MainActivity.class.getSimpleName();
    EditText ed1,ed2;
    Button ok;
    int a,b;
    int e;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.editText_1);
        ed2 = (EditText)findViewById(R.id.editText_2);
        ok = (Button)findViewById(R.id.button_ok);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                a = Integer.parseInt(ed1.getText().toString());
                b = Integer.parseInt(ed2.getText().toString());
                addTwoNumbers(a ,b);
            }
        });

        showLog("Activity Created");

    }

    private void addTwoNumbers(int c,int d)
    {
        e = c+d;
        Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();

    }

    private void showLog(String text){

        Log.d(HOME_ACTIVITY_TAG, text);

    }
   /* @Override

    protected void onRestart(){

        super.onRestart();//call to restart after onStop

        Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();
        Log.d("add",""+e);

        showLog("Activity restarted");

    }*/

    @Override

    protected void onStart() {

        super.onStart();//soon be visible

        showLog("Activity started");

    }

    @Override

    protected void onResume() {

        super.onResume();//visible

        Log.d("add resume",""+e);
        Toast.makeText(getApplicationContext(),"on resume"+e,Toast.LENGTH_SHORT).show();

        showLog("Activity resumed");

    }

    @Override

    protected void onPause() {

        super.onPause();//invisible
        int f =e;
        Log.d("add pause",""+e);
        Toast.makeText(getApplicationContext(),"on pause"+f,Toast.LENGTH_SHORT).show();
        showLog("Activity paused");

    }

  /*  @Override

    protected void onStop() {

        super.onStop();

        showLog("Activity stopped");

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();

        showLog("Activity is being destroyed");

    }*/
}
