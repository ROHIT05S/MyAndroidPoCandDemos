/*
package com.itcinfotech.a24343.demousingintents;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText nameOfEmp,company,deptm,mobile;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews()
    {
        nameOfEmp = (EditText)findViewById(R.id.editText_name);
        company = (EditText)findViewById(R.id.editText2_comp);
        deptm = (EditText)findViewById(R.id.editText4_dept);
        mobile = (EditText)findViewById(R.id.editText3_mbile);
        button1 = (Button)findViewById(R.id.button_enter);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        getAllData();

    }

    private void getAllData()
    {
        String eName = nameOfEmp.getText().toString();
        String eComp = company.getText().toString();
        String eDept = deptm.getText().toString();
        String eMob = mobile.getText().toString();


        Employee employee = new Employee(eName,eComp,eDept,eMob);
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("employe",employee);
        startActivity(intent);


       // Toast.makeText(getApplicationContext(),eName+eComp+eDept+eMob,Toast.LENGTH_LONG).show();
    }
}
*/
