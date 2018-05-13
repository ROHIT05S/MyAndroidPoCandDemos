package com.example.rohit.bayerspocfieldprofilingnewdetails.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.rohit.bayerspocfieldprofilingnewdetails.Latlong;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohit on 27-03-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String Database_Name = "FarmerDatabase.db";
    public static final String Table1 = "PincodeDetails";
    public static final String Table2 = "Fielddetais";
    public static final String PinId = "PincodeId";
    public static final String PinCode = "Pincode";
    public static final String PinLatlng = "PincodeLatlng";
    Latlong latlong = new Latlong();


    public Cursor cursor;

    public DatabaseHelper(Context context)
    {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

       // Log.d("inside oncreate db","inside oncreate db");
        String sqlQuery = "CREATE TABLE PincodeDetails ( PINCODE INTEGER  NOT NULL , PINLATLONG TEXT);";
        //Log.d("sql query", "table created");
        try
        {
            db.execSQL(sqlQuery);

        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL(" DROP TABLE IF EXISTS PincodeDetails");
        onCreate(db);

    }
    public void savePindetails(Latlong latlong)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("PINCODE",latlong.getPincode());
        cv.put("PINLATLONG", latlong.getLatlng());
        db.insert("PincodeDetails",null,cv);
    }

    public List<Latlong> getList()
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "select * from PincodeDetails";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        List<Latlong> list = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do
            {
                Latlong latlong =new Latlong();

                latlong.setPincode(cursor.getString(0));
                latlong.setLatlng(cursor.getString(1));

                list.add(latlong);

            }while (cursor.moveToNext());

        }
        return list;
    }
}
