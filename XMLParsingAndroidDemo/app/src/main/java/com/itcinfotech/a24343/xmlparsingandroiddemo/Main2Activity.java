package com.itcinfotech.a24343.xmlparsingandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main2Activity extends AppCompatActivity
{
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = (ListView)findViewById(R.id.listView_main2activity);
        List<Employee> employees = null;
        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            InputStream is=getAssets().open("file.xml");
            employees = parser.parse(is);

            ArrayAdapter<Employee> adapter =new ArrayAdapter<Employee>
                    (this,android.R.layout.simple_list_item_1, employees);
            lv.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}
    }
}
