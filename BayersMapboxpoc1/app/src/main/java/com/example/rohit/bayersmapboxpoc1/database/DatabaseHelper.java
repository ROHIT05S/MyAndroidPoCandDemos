package com.example.rohit.bayersmapboxpoc1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.rohit.bayersmapboxpoc1.models.LocationDetails;

import java.util.ArrayList;

/**
 * Created by Rohit on 18-04-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
     Context context;

    // Database Name
    private static final String DATABASE_NAME = "LocationDetails";
    private static final String TABLE_Name= "fielddetails";
    private static final String place = "place";
    private static final String latitiude = "latitude";
    private static final String longitude = "longitude";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table fielddetails (place text, latitude text,longitude text)");
        /*String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Name + "("
                + place + " TEXT PRIMARY KEY," + latitiude + " TEXT "
                + longitude + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
        onCreate(db);
    }
    public boolean addLocation(LocationDetails locationDetails)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("place", locationDetails.getPlace()); // Contact Name
        values.put("latitude", locationDetails.getLatitude());
        values.put("longitude",locationDetails.getLongitude());

       long i =  db.insert(TABLE_Name, null, values);

        if(i != -1)
        {
            return true;
        }
        else
        {
            return false;
        }



    }


  public   ArrayList<String> getAllPlaces()
    {
        ArrayList<String> strings = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select place from "+TABLE_Name,null);
        while (cursor.moveToNext())
        {
            strings.add(cursor.getString(0));
        }
        return strings;

    }

    public LocationDetails getLocationDetails(String placeName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor cursor = db.rawQuery("select * from fielddetails where place = "+placeName,null);

        Cursor cursor = db.query(TABLE_Name, new String[] { "place",
                        "latitude","longitude" }, "place = ?",
                new String[] { placeName }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

       LocationDetails locationDetails = new LocationDetails(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        return locationDetails;
    }
}
