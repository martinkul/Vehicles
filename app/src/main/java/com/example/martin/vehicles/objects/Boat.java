package com.example.martin.vehicles.objects;

import java.util.ArrayList;

/**
 * Created by Martin on 15/09/2017.
 */

public class Boat extends Vehicle {

    private int speed, tonnage;
    private ArrayList<Attribute> attributes = new ArrayList<>();

    public Boat(String id, int power, boolean operational, int speed, int tonnage) {
        super(id, power, operational);

        this.speed = speed;
        this.tonnage = tonnage;

        this.attributes.add(new Attribute("Registration", id));
        this.attributes.add(new Attribute("Engine power", Integer.toString(power) + " kW"));
        this.attributes.add(new Attribute("Top speed", Integer.toString(speed) + " knots per hour"));
        this.attributes.add(new Attribute("Gross tonnage", Integer.toString(tonnage) + " kg"));

        super.createAttributes(attributes);
    }

    public String toString() {
        return "Registration: " + super.getId() + "   " +
                "Engine power: " + super.getPower() + " kW   " +
                "Maximum speed: " + speed + " knots per hour   " +
                "Gross tonnage: " + tonnage + " kg";
    }

}
