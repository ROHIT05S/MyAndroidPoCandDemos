package com.woodward.androidaccesscontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayContentActivity extends AppCompatActivity
{
    private static final String TAG = DisplayContentActivity.class.getSimpleName();
    public static final String AUTHORITY = "com.inducesmile.androidcontentprovider.Dictionary";
    public static final String PATH  = "/words";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_content);
        recyclerView = (RecyclerView)findViewById(R.id.list_dictionary);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        Cursor mCursor = getContentResolver().query(CONTENT_URI, null, null, null, null, null);
        List<String> words = new ArrayList<>();
        if(mCursor.moveToFirst()){
            do{
                String word = mCursor.getString(1);
                words.add(word);
            }while(mCursor.moveToNext());
            DictionaryAdapter mAdapter = new DictionaryAdapter(DisplayContentActivity.this, words);
            recyclerView.setAdapter(mAdapter);
        }else{
            Toast.makeText(DisplayContentActivity.this, "Nothing is inside the cursor ", Toast.LENGTH_LONG).show();
        }
        mCursor.close();
    }
}
