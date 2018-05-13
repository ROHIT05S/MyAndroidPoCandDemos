package com.rohit.apicallsdemousinginterface;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

public class MyURLCall implements FetchDataListener
{

    private Context context;
    public static String responseData = null;

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
                            responseData = response.toString();
                           // return responseData;


                           // resultTextView.setText(response.toString(4));
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

        Log.d("responeseMyURl",responseData);


    }

    @Override
    public void onFetchFailure(String msg)
    {
        RequestQueueService.cancelProgressDialog();
        //Show if any error message is there called from GETAPIRequest class
       // RequestQueueService.showAlert(msg,MainActivity.this);
    }

    @Override
    public void onFetchStart()
    {
      //  RequestQueueService.showProgressDialog(MainActivity.this);
    }
}
