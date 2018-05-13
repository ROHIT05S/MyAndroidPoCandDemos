/*
package com.itcinfotech.a24343.demousingintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity
{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.textView_activity);
        if (getIntent().hasExtra("employe"))
        {
           Employee emp = (Employee) getIntent().getSerializableExtra("employe");
            String empName = emp.eName;
            String empComp = emp.eComp;
            String empMob = emp.eMob;
            String empDep = emp.eDept;

            */
/*String empName = emp.geteName();
            String empComp = emp.geteComp();
            String empMob = emp.geteMob();
            String empDep = emp.geteDept();*//*

            textView.setText(empName+"***********\n"+empComp+"***********\n"+empMob+"*********\n"+empDep+"********");



        }

    }
}
*/
