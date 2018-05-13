package com.woodward.androidaccesscontentprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContentActivity extends AppCompatActivity
{
    private static final String TAG = AddContentActivity.class.getSimpleName();
    private EditText wordInput, meaningInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        setTitle(getString(R.string.add_to));
        wordInput = (EditText)findViewById(R.id.enter_word);
        meaningInput = (EditText)findViewById(R.id.enter_meaning);
        Button addContentButton = (Button)findViewById(R.id.add_content);
        addContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = wordInput.getText().toString();
                String meaning = meaningInput.getText().toString();
                if(TextUtils.isEmpty(word) || TextUtils.isEmpty(meaning)){
                    Toast.makeText(AddContentActivity.this, "All input fields must be filled", Toast.LENGTH_LONG).show();
                }else{
                    String AUTHORITY = "com.inducesmile.androidcontentprovider.Dictionary";
                    String PATH  = "/words";
                    Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
                    ContentValues values = new ContentValues();
                    values.put("word", word);
                    values.put("meaning", meaning);
                    Uri mUri = getContentResolver().insert(CONTENT_URI, values);
                    if(mUri != null){
                        Toast.makeText(AddContentActivity.this, "Successfully added to Content Provider", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
