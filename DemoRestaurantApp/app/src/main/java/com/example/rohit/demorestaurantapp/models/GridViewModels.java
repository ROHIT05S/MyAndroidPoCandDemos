package com.example.rohit.demorestaurantapp.models;

/**
 * Created by Rohit on 26-09-2017.
 */

public class GridViewModels
{
    String imageId,imageName;

    public GridViewModels(String imageId, String imageName) {
        this.imageId = imageId;
        this.imageName = imageName;
    }

    public String getImageId() {
        return imageId;
    }

    public String getImageName() {
        return imageName;
    }
}
