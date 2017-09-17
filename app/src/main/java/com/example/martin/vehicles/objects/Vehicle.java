package com.example.martin.vehicles.objects;

import java.util.ArrayList;

/**
 * Created by Martin on 15/09/2017.
 */

public class Vehicle {

    private String id;
    private int power;
    private  boolean operational;
    private ArrayList<Attribute> attributes;


    public Vehicle(String id, int power, boolean operational) {
        this.id = id;
        this.power = power;
        this.operational = operational;
    }

    public String getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public boolean getOperational() {
        return operational;
    }

    public void createAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

}
