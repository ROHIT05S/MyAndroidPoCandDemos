package rohit.com.cricketscoreui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 24343 on 1/31/2018.
 */

public class CustomListViewAdapter extends BaseAdapter
{
    private ArrayList<TaskList> taskList;
    private Context context;
    public CustomListViewAdapter(Context context, ArrayList<TaskList> taskList)
    {
        this.context = context;
        this.taskList = taskList;


    }
    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid;
        if (view == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.task_list_layout, null);
            TextView task_name = (TextView) grid.findViewById(R.id.task_name);
            ImageView black_dot_image = (ImageView) grid.findViewById(R.id.black_dot);

            black_dot_image.setImageResource(R.drawable.black_dot);

            task_name.setText(taskList.get(i).getTaskName().toString());


        }
        else {
            grid = (View)view;
        }
        return grid;

    }
}
