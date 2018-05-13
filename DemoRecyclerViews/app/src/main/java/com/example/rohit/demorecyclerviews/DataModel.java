package com.example.rohit.demorecyclerviews;

/**
 * Created by Rohit on 30-03-2018.
 */

public class DataModel
{
    private String title;
    private int image;

    public DataModel(String title,  int image) {

        this.title = title;

        this.image = image;
    }

    public String getTitle() {
        return title;
    }



    public int getImage() {
        return image;
    }
}
