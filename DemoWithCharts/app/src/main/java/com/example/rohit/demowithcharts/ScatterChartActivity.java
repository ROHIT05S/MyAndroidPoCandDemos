package com.example.rohit.demowithcharts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;

import java.util.ArrayList;

public class ScatterChartActivity extends AppCompatActivity
{
    private ScatterChart scatterChart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scatter_chart);
        scatterChart = (ScatterChart)findViewById(R.id.scaterChart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
            entries.add(new Entry(8f, 1));
            entries.add(new Entry(6f, 2));
            entries.add(new Entry(12f, 3));
            entries.add(new Entry(18f, 4));
            entries.add(new Entry(9f, 5));

        ScatterDataSet dataset = new ScatterDataSet(entries,"scatter");

        ArrayList<String> label = new ArrayList<>();
        label.add("Jan");
        label.add("Feb");
        label.add("Mar");
        label.add("Apr");
        label.add("May");
        label.add("Jun");

        ScatterData data = new ScatterData(label, dataset);

        scatterChart.setData(data);

    }
}
