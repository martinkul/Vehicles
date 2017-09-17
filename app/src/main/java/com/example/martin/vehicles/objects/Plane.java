package com.example.martin.vehicles.objects;

import java.util.ArrayList;

/**
 * Created by Martin on 15/09/2017.
 */

public class Plane extends Vehicle {

    private int wingspan, capacity, weight;
    private String type;
    private ArrayList<Attribute> attributes = new ArrayList<>();

    public Plane(String id, int power, boolean operational, int wingspan, int capacity, int weight, String type) {
        super(id, power, operational);

        this.wingspan = wingspan;
        this.capacity = capacity;
        this.weight = weight;
        this.type = type;

        this.attributes.add(new Attribute("Registration", id));
        this.attributes.add(new Attribute("Engine power", Integer.toString(power) + " kW"));
        this.attributes.add(new Attribute("Wind span", Integer.toString(wingspan) + "m"));
        this.attributes.add(new Attribute("Load capacity", Integer.toString(capacity) + "t"));
        this.attributes.add(new Attribute("Net weight", Integer.toString(weight) + "t"));
        this.attributes.add(new Attribute("Type", type));

        super.createAttributes(attributes);
    }

    public String toString() {
        return "Registration: " + super.getId() + "   " +
                "Engine power: " + super.getPower() + " kW   " +
                "Wing span: " + wingspan + "m   " +
                "Load capacity: " + capacity + "t   " +
                "Net weight: " + weight + "t   " +
                "Type: " + type;
    }

}
