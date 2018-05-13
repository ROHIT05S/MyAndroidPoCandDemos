package com.itcinfotech.a24343.xmlparsingandroiddemo;

/**
 * Created by 24343 on 10/12/2017.
 */

public class Employee
{
    private int id;
    private String name;
    private float salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return " Id= "+id + "\n Name= " + name + "\n Salary= " + salary;
    }
}
