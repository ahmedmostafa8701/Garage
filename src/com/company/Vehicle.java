package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Vehicle {

    private String modelName;
    private int ID;
    static int generateID = 0;
    private double width;
    private double depth;
    private LocalDateTime time_in;
    private LocalDateTime time_out;

    private Slot slot;

    public Vehicle(String modelName, double width, double depth) {
        this.modelName = modelName;
        this.width = width;
        this.depth = depth;
        ID = ++generateID;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getModelName() {
        return modelName;
    }
    public void setTime_in(LocalDateTime time_in) {
        this.time_in = time_in;
    }

    public void setTime_out(LocalDateTime time_out) {
        this.time_out = time_out;
    }

    public LocalDateTime getTime_in() {
        return time_in;
    }

    public LocalDateTime getTime_out() {
        return time_out;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "ID: " + getID()
                + ", Model Name: " + getModelName()
                + ", Width: " + getWidth() + " m"
                + ", Depth: " + getDepth() + " m"
                + ", Arrival Time: " + getTime_in()
                + ", Leave Time: " + getTime_out();
    }
}
