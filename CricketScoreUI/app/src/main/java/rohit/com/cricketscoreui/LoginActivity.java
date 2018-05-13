
package rohit.com.cricketscoreui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    CustomEditText ed;
    TextView textPassword , textView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // ed = (EditText)findViewById(R.id.editTextPassword);
        ed = (CustomEditText) this.findViewById(R.id.editTextPassword);
        textPassword = (TextView)findViewById(R.id.TextPassword);
        textView = (TextView) this.findViewById(R.id.textView);
        textView.setSelected(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setText("General Information... general information... General Information");
        textView.setSelected(true);
        textView.setSingleLine(true);
        ed.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                switch (target) {
                    case RIGHT:
                        //Do something here
                        String text = ed.getText().toString();
                        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
                        ed.setError(text);
                        textPassword.setText(text.toString());
                        //ed.setVisibility(View.VISIBLE);
                        break;

                    default:
                        break;
            }
        }

    });
    }


}
