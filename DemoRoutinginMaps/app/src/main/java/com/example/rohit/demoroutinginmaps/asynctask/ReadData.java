package com.example.rohit.demoroutinginmaps.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rohit on 02-09-2017.
 */

public class ReadData extends AsyncTask<String, Void , String>
{
    @Override
    protected String doInBackground(String... params)
    {
        String data = "";
        try {
            MapHttpConnection http = new MapHttpConnection();
            data = http.readUr(params[0]);


        } catch (Exception e) {
            // TODO: handle exception
            Log.d("Background Task", e.toString());
        }
        return data;
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        new ParserTask().execute(result);
    }


}
