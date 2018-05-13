package com.rohit.ciphersecurityimplementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends AppCompatActivity
{
    private String iv = "fedcba9876543210";            // Dummy iv (CHANGE IT!)
    private IvParameterSpec ivspec;
    private SecretKeySpec keyspec;
    private Cipher cipher;
    private String SecretKey = "0123456789abcdef";
    EditText ed;
    Button encrypt,decrypt;
    TextView result,result1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=(EditText)findViewById(R.id.editText);
        final String[] textResult = new String[1];
        encrypt=(Button) findViewById(R.id.button_encrypt);
        decrypt=(Button) findViewById(R.id.button_decrypt);
        result=(TextView)findViewById(R.id.textView_result);
        result1=(TextView)findViewById(R.id.textView_result1);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = ed.getText().toString();
                try {
                    byte[] dataEncrypted = encrypt(data);
                    Log.d("data_Encrypted",dataEncrypted.toString());
                    textResult[0] = byteArrayToHexString(dataEncrypted);
                    result.setText(textResult[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
       decrypt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               try {
                   byte[] dataDecrypted = decrypt(textResult[0]);
                   Log.d("data_Encrypted",dataDecrypted.toString());
                   Log.d("textResult",textResult[0].toString());
                   textResult[0] = byteArrayToHexString(dataDecrypted);
                  String decryptedString =  hexToString(textResult[0]);
                   result1.setText(decryptedString);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });


        ivspec = new IvParameterSpec(iv.getBytes());
        keyspec = new SecretKeySpec(SecretKey.getBytes(), "AES");

        try {

// cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

    }
    public byte[] encrypt(String text) throws Exception
    {
        if (text == null || text.length() == 0)
            throw new Exception("Empty string");

        byte[] encrypted = null;
        try {
// Cipher.ENCRYPT_MODE = Constant for encryption operation mode.
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);

            encrypted = cipher.doFinal(padString(text).getBytes());
        } catch (Exception e) {
            throw new Exception("[encrypt] " + e.getMessage());
        }
        return encrypted;
    }
    public byte[] decrypt(String text) throws Exception
    {
        if (text == null || text.length() == 0)
            throw new Exception("Empty string");

        byte[] decrypted = null;
        try {
// Cipher.DECRYPT_MODE = Constant for decryption operation mode.
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            decrypted = cipher.doFinal(hexToBytes(text));
        } catch (Exception e) {
            throw new Exception("[decrypt] " + e.getMessage());
        }
        return decrypted;
    }
    private static String padString(String source) {
        char paddingChar = 0;
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;
        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }
        return source;
    }
    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {

            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(
                        str.substring(i * 2, i * 2 + 2), 16);

            }
            return buffer;
        }
    }
    public static String byteArrayToHexString(byte[] array) {
        StringBuffer hexString = new StringBuffer();
        for (byte b : array) {
            int intVal = b & 0xff;
            if (intVal < 0x10)
                hexString.append("0");
            hexString.append(Integer.toHexString(intVal));
        }
        return hexString.toString();
    }
    public String hexToString(String txtInHex)
    {
        byte [] txtInByte = new byte [txtInHex.length() / 2];
        int j = 0;
        for (int i = 0; i < txtInHex.length(); i += 2)
        {
            txtInByte[j++] = Byte.parseByte(txtInHex.substring(i, i + 2), 16);
        }
        return new String(txtInByte);
    }
}

