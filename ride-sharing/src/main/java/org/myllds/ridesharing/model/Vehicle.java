package org.myllds.ridesharing.model;

public class Vehicle {
    private String owner;
    private String name;
    private String number;

    public Vehicle(String owner, String name, String number) {
        this.owner = owner;
        this.name = name;
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

