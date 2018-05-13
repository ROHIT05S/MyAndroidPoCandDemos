package com.itcinfotech.a24343.editimagepoc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddTextOnImageView extends AppCompatActivity
{

    ImageView imageView;
    TextView textView;
    String userInputValue;
    Button edit,undo,redo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text_on_image_view);
        imageView = (ImageView)findViewById(R.id.test_image);
        textView = (TextView)findViewById(R.id.imagetext);
        edit = (Button)findViewById(R.id.btn_edit);
        undo = (Button)findViewById(R.id.btn_undo);
        redo = (Button)findViewById(R.id.btn_redo);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTextBox();
            }
        });
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTOpreviousImage();

            }
        });
        redo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTONextImage();
            }
        });

    }

    private void goTONextImage()
    {

    }

    private void goTOpreviousImage()
    {

    }

    private void displayTextBox(){
     AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
     LayoutInflater inflater = this.getLayoutInflater();
    final View dialogView = inflater.inflate(R.layout.custom_dialog,null);
    dialogBuilder.setView(dialogView);
    final EditText textContent = (EditText) dialogView.findViewById(R.id.add_text_on_image);
    dialogBuilder.setTitle("");
    dialogBuilder.setMessage("");
    dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            userInputValue = textContent.getText().toString();
            if(!userInputValue.equals("") || !userInputValue.isEmpty()){
                // assign the content to the TextView object
                textView.setText(userInputValue);
                }
            }
        });
    dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            dialog.dismiss();
            }
    });
    AlertDialog b = dialogBuilder.create();
    b.show();
}

}
