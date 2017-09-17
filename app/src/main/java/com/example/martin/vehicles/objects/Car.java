package com.example.martin.vehicles.objects;

import java.util.ArrayList;

/**
 * Created by Martin on 15/09/2017.
 */

public class Car extends Vehicle {

    private int speed;
    private String color, type;
    private ArrayList<Attribute> attributes = new ArrayList<>();

    public Car(String id, int power, boolean operational, int speed, String color, String type) {
        super(id, power, operational);

        this.speed = speed;
        this.color = color;
        this.type = type;

        this.attributes.add(new Attribute("License plate", id));
        this.attributes.add(new Attribute("Engine power", Integer.toString(power) + " kW"));
        this.attributes.add(new Attribute("Top speed", Integer.toString(speed) + " km/h"));
        this.attributes.add(new Attribute("Color", color));
        this.attributes.add(new Attribute("Type", type));

        super.createAttributes(attributes);
    }

    public String toString() {
        return "License plate: " + super.getId() + "   " +
                "Engine power: " + super.getPower() + " kW   " +
                "Maximum speed: " + speed + " km/h   " +
                "Color: " + color + "   " +
                "Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;

        return super.getId().equals(car.getId()) &&
                super.getId() == car.getId() &&
                this.speed == car.speed &&
                this.color.equals(car.color) &&
                this.type.equals(car.type);
    }

}
