package com.example.rohit.mynotes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity
{
    private TextInputEditText et_title,et_content;
    private NoteDatabase noteDatabase;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        noteDatabase = NoteDatabase.getInstance(MainActivity.this);
        Button button = findViewById(R.id.but_save);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
        {
            // fetch data and create note object
            note = new Note(et_content.getText().toString(), et_title.getText().toString());
            // create worker thread to insert data into database
            new InsertTask(MainActivity.this,note).execute();
        }});



    }
    private void setResult(Note note, int flag){
        setResult(flag,new Intent().putExtra("note",note));
        finish();
    }
    private static class InsertTask extends AsyncTask<Void,Void,Boolean>
    {
        private WeakReference<MainActivity> activityReference;
        private Note note;
        InsertTask(MainActivity context, Note note)
        {
            activityReference = new WeakReference<>(context);
            this.note = note;
        }
        @Override
        protected Boolean doInBackground(Void... objs)
        {
            activityReference.get().noteDatabase.getNoteDao().insertNote(note);
        return true;
        }
        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool)
        {
            if (bool)
            {
                activityReference.get().setResult(note,1);
            }
        }
    }


}
