package rohit.com.cricketscoreui;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DemoURLCallActivity extends AppCompatActivity
{

    Button btnlogin;
    //public String loginAuthenticationUrl= "http://192.168.42.224:8081/listUsers";
    public String loginAuthenticationUrl= "http://192.168.70.167/Windchill/servlet/rest/validateWindchillUser/loginUser";
    String  userName = "wcadmin";
    String passWord = "wcadmin";
    String combinedUserNamePwd = userName+":"+passWord;
    String base64Combined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_urlcall);
        btnlogin = (Button) findViewById(R.id.button21);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callURl();
            }
        });

    }

    private void callURl()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient();//.addHeader("appKey","2c696603-c7dc-4daf-9367-c0a990b8e1ea")
        RequestBody body = RequestBody.create(null, new byte[]{});
        boolean result = false;
        try {
            byte[] data = combinedUserNamePwd.getBytes("UTF-8");
            base64Combined  = Base64.encodeToString(data, Base64.NO_WRAP);
            Log.d("base64Combined",base64Combined);

        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        RequestBody body = RequestBody.create(null, obj.toString());
        Request request = new Request.Builder().url(loginAuthenticationUrl)
                .addHeader("Authorization","Basic d2NhZG1pbjp3Y2FkbWlu")
                .build();
         /*   Request request = new Request.Builder()
                    .url(loginAuthenticationUrl)
                    .build();*/

        try {
            Response response = client.newCall(request).execute();
            Log.d("response", "" + response);
            String responsestring = response.body().string();
            Log.d("responsestring", "" + responsestring);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("e",e.toString());
        }
//        return result;
    }
}
