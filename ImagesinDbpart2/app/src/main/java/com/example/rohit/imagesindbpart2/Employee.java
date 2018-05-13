package com.example.rohit.imagesindbpart2;

import android.graphics.Bitmap;

/**
 * Created by Rohit on 03-06-2017.
 */

public class Employee
{
    String name;
    int age;
    Bitmap bitmap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Employee(Bitmap bitmap, String name, int age) {
        this.name = name;
        this.age = age;
        this.bitmap = bitmap;
    }

    public Employee()
    {

    }
}
