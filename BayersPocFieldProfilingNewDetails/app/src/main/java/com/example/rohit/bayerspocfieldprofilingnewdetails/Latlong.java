package com.example.rohit.bayerspocfieldprofilingnewdetails;

/**
 * Created by Rohit on 28-03-2017.
 */

public class Latlong
{
    String pincode;
    String Latlng;

    public Latlong() {
    }

    public Latlong(String pincode, String latlng) {
        this.pincode = pincode;
        Latlng = latlng;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLatlng() {
        return Latlng;
    }

    public void setLatlng(String latlng) {
        Latlng = latlng;
    }
}
