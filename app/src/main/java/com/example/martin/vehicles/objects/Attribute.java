package com.example.martin.vehicles.objects;

/**
 * Created by Martin on 15/09/2017.
 */

public class Attribute {

    private String attribute, value;

    public Attribute(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
