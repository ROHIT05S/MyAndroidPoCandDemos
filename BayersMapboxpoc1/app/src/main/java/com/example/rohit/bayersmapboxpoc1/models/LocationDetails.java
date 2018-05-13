package com.example.rohit.bayersmapboxpoc1.models;

/**
 * Created by Rohit on 18-04-2017.
 */

public class LocationDetails
{
    String place;
    String latitude,longitude;

    public LocationDetails() {
    }

    public LocationDetails(String place, String latitude, String longitude) {
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
