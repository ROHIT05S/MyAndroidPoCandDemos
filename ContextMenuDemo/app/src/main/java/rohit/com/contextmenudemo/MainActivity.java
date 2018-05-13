package rohit.com.contextmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pressView = (TextView)findViewById(R.id.longPress);
        //register if for context
        registerForContextMenu(pressView);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
    }
    public boolean onContextItemSelected(MenuItem item) {
        //find out which menu item was pressed
        switch (item.getItemId()) {
            case R.id.option1:
                doOptionOne();
                return true;
            case R.id.option2:
                doOptionTwo();
                return true;
            default:
                return false;
        }
    }
    //method to execute when option one is chosen
    private void doOptionOne() {
        Toast.makeText(this, "Option One Chosen...", Toast.LENGTH_LONG).show();
    }

    //method to execute when option two is chosen
    private void doOptionTwo() {
        Toast.makeText(this, "Option Two Chosen...", Toast.LENGTH_LONG).show();
    }
}
