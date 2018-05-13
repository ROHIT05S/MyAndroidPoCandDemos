package com.example.rohit.barcodegenerator;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.journeyapps.barcodescanner.BarcodeView;

public class BarCodeGenerateActivity extends AppCompatActivity
{
    ImageView barCode;
    EditText barcodeText;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_generate);
        barCode = (ImageView)findViewById(R.id.imageView_barcode);
        barcodeText = (EditText)findViewById(R.id.text_barcode);
        submit = (Button)findViewById(R.id.submit);
       // String text="abcde131313####"; // Whatever you need to encode in the QR code
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String text = barcodeText.getText().toString();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.CODE_128,400,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    barCode.setImageBitmap(bitmap);
                    int id =  BarcodeView.generateViewId();
                    Toast.makeText(getApplicationContext(), "" + id, Toast.LENGTH_LONG).show();

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
