package com.rohit.apicallsdemousinginterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{
    private TextView resultTextView;
    private Button getApiBtn,postApiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView  = (TextView)findViewById(R.id.resultTextView);
        getApiBtn       = (Button)findViewById(R.id.getApiBtn);
        postApiBtn      = (Button)findViewById(R.id.postApiBtn);

        //Attaching OnClickListener with Buttons
        getApiBtn.setOnClickListener(getApiListener);
        postApiBtn.setOnClickListener(postApiListener);
    }
    View.OnClickListener getApiListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Call getApiCall() method
            getApiCall();
        }
    };

    View.OnClickListener postApiListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Call postApiCall() method
            postApiCall();
        }
    };
    private void getApiCall(){
        try{
            //Create Instance of GETAPIRequest and call it's
            //request() method
            String response;
            GETAPIRequest getapiRequest=new GETAPIRequest();
            MyURLCall myURLCall = new MyURLCall();
            //Attaching only part of URL as base URL is given
            //in our GETAPIRequest(of course that need to be same for all case)
            String url="webapi.php?userId=1";
            getapiRequest.request(MainActivity.this,fetchDataListener,url);
            //Log.d("respActivity",response);
         //   String response = MyURLCall.responseData;
            Toast.makeText(MainActivity.this,"GET API called", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void postApiCall(){
        try{
            //Create Instance of POSTAPIRequest and call it's
            //request() method
            POSTAPIRequest postapiRequest=new POSTAPIRequest();
            //Attaching only part of URL as base URL is given
            //in our POSTAPIRequest(of course that need to be same for all case)
            String url="webapi.php";
            MyURLCall myURLCall = new MyURLCall();
            JSONObject params=new JSONObject();
            try {
                //Creating POST body in JSON format
                //to send in POST request
                params.put("userId",2);
            }catch (Exception e){
                e.printStackTrace();
            }
            postapiRequest.request(MainActivity.this,fetchDataListener,params,url);
            Toast.makeText(MainActivity.this,"POST API called",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    FetchDataListener fetchDataListener = new FetchDataListener() {
        @Override
        public void onFetchComplete(JSONObject data)
        {
            RequestQueueService.cancelProgressDialog();
            try {
                //Now check result sent by our GETAPIRequest class
                if (data != null) {
                    if (data.has("success")) {
                        int success = data.getInt("success");
                        if(success==1){
                            JSONObject response=data.getJSONObject("response");
                            if(response!=null) {
                                //Display the result
                                //Or, You can do whatever you need to
                                //do with the JSONObject
                                Log.d("response",response.toString());
                                //responseData = response.toString();
                                 resultTextView.setText(response.toString(4));
                            }
                        }else{
                            // RequestQueueService.showAlert("Error! No data fetched",);

                        }
                    }
                } else {
                    //RequestQueueService.showAlert("Error! No data fetched", MainActivity.this);
                }
            }catch (Exception e){
                //RequestQueueService.showAlert("Something went wrong", MainActivity.this);
                e.printStackTrace();
            }

            //Log.d("responeseMyURl",responseData);


        }


        @Override
        public void onFetchFailure(String msg) {

        }

        @Override
        public void onFetchStart() {

        }
    };



}
