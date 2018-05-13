package rohit.com.cricketscoreui;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity
{
    ListView listViewofTasks;
    ArrayList<TaskList> taskListsArray;
    Context context;
    public String allTasksUrl= "http://192.168.70.167/Windchill/servlet/rest/task/alltasks";
    String  userName = "wcadmin";
    String passWord = "wcadmin";
    String combinedUserNamePwd = userName+":"+passWord;
    String base64Combined;
    Button allTasks;
    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        context = this;
        listViewofTasks = (ListView)findViewById(R.id.task_list_view);
        allTasks = (Button)findViewById(R.id.button_alltasks);
        heading = (TextView)findViewById(R.id.text_view_heading);
        heading.setSelected(true);
        heading.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        heading.setText("WELCOME TO WINDCHILL TASKBOARD...");
        heading.setSelected(true);
        heading.setSingleLine(true);

        taskListsArray = new ArrayList<TaskList>();
        allTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAlltasksfromServer();
            }
        });






    }

    private void getAlltasksfromServer() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient();
        JSONObject obj = new JSONObject();
        try {
            obj.put("userName",userName);
            Log.d("bodyw",obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            byte[] data = combinedUserNamePwd.getBytes("UTF-8");
            base64Combined  = Base64.encodeToString(data, Base64.NO_WRAP);
            Log.d("base64Combined",base64Combined);


        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String send = "Basic "+base64Combined;
        Log.d("send",send);
        RequestBody body = RequestBody.create(null, obj.toString());
        Request request = new Request.Builder().url(allTasksUrl).post(body)
                .addHeader("Authorization",send)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Log.d("response", "" + response);
            String responsestring = response.body().string();
            Log.d("responsestring", "" + responsestring);
           // Toast.makeText(getApplicationContext(),responsestring,Toast.LENGTH_SHORT).show();

            JSONArray jsonArray = new JSONArray(responsestring);


            for (int i = 0; i <= jsonArray.length(); i++)
            {
                JSONObject c = jsonArray.getJSONObject(i);

               Log.d("c",c.toString());


                taskListsArray.add(new TaskList(c.getInt("taskId"),c.getString("taskName")));
                CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(context, taskListsArray);
                listViewofTasks.setAdapter(customListViewAdapter);

            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("e",e.toString());
        }
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(context, taskListsArray);
        listViewofTasks.setAdapter(customListViewAdapter);
       listViewofTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(getApplicationContext(),""+taskListsArray.get(i).getTaskId(),Toast.LENGTH_SHORT).show();
           }
       });
    }
}
