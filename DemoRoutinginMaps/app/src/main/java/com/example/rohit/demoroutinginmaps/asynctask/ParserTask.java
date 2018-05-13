package com.example.rohit.demoroutinginmaps.asynctask;

import android.graphics.Color;
import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rohit on 02-09-2017.
 */

public class ParserTask extends AsyncTask<String,Integer, List<List<HashMap<String , String >>>> {

    @Override
    protected List<List<HashMap<String, String>>> doInBackground(
            String... jsonData) {
        // TODO Auto-generated method stub
        JSONObject jObject;
        List<List<HashMap<String, String>>> routes = null;
        try {
            jObject = new JSONObject(jsonData[0]);
            PathJSONParser parser = new PathJSONParser();
            routes = parser.parse(jObject);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return routes;
    }

}

