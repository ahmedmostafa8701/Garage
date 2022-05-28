package com.company;

import java.time.LocalDateTime;
import java.util.*;

public class Slot {

    private double width;
    private double depth;
    private int ID;
    private int Fees;
    public static int generateID = 0;
    private boolean active = true;
    private Vehicle vehicle;
    public Slot(double width, double depth) {
        this.width = width;
        this.depth = depth;
        ID = ++generateID;
        Fees = 5;
    }

    public int getFees() {
        return Fees;
    }
    public void freeSlot(){
        vehicle = null;
        active = true;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        active = false;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean suitable(double width, double depth){
        return width <= this.width &&  depth <= this.depth && active;
    }
    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public int getID() {
        return ID;
    }

    public boolean getStatus() {
        return active;
    }
    public boolean isSmaller(Slot slot){
        return this.width * this.depth < slot.getWidth() * slot.getDepth();
    }
    @Override
    public String toString() {
        return "Slot ID: " + getID()
                + ", Slot Width: " + getWidth() + " m"
                + ", Slot Depth: " + getDepth() + " m";
    }
}
