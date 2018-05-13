package com.example.rohit.bayerspocfieldprofilingnewdetails.Database;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rohit.bayerspocfieldprofilingnewdetails.R;

public class UpadateChangeActivity extends AppCompatActivity implements DialogInterface.OnClickListener,View.OnClickListener
{
    EditText editTextcal;
    static final int DATE_START_DIALOG_ID = 0;
    private int startYear=1970;
    private int startMonth=6;
    private int startDay=15;
    Spinner cropList,cropVarieties,soilType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upadate_change);
        editTextcal = (EditText)findViewById(R.id.editText4_date);
        editTextcal.setOnClickListener(this);
        cropList = (Spinner)findViewById(R.id.spinner);
        cropVarieties = (Spinner)findViewById(R.id.spinner2);
        soilType = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.croplist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cropList.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.cropvarieties, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cropVarieties.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.soillist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soilType.setAdapter(adapter);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_START_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        startYear, startMonth, startDay);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener mDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            startYear=selectedYear;
            startMonth=selectedMonth;
            startDay=selectedDay;
            editTextcal.setText(""+selectedDay+":"+(startMonth+1)+":"+startYear);
        }
    };

        @Override
        public void onClick(DialogInterface dialog, int which)
        {

        }

        @Override
        public void onClick(View v)
        {
            switch (v.getId()) {
                case R.id.editText4_date:
                    showDialog(DATE_START_DIALOG_ID);
                    break;

                default:
                    break;
            }
        }

}

