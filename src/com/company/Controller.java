package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Controller controller;
    private Controller(){

    }
    public static Controller getController() {
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }
    public Slot parkIn(Vehicle vehicle, IParkIn iparkIn) {
        return iparkIn.parkIn(vehicle);
    }
    public Slot parkOut(Vehicle vehicle, IParkOut iParkOut){
        return iParkOut.parkOut(vehicle);
    }
    public boolean pay(Vehicle vehicle, IPay iPay){
        return iPay.pay(vehicle);
    }
    public List<Slot> getAvaliableSlots() {
        List<Slot> slots = new ArrayList<>();
        for (Slot slot : Garage.getGarage().getSlots()) {
            if (slot.getStatus()) {
                slots.add(slot);
            }
        }
        return slots;
    }
    public List<Slot> getSuitableSlots(double width, double depth){
        List<Slot> slots = new ArrayList<>();
        for (Slot slot : Garage.getGarage().getSlots()) {
            if (slot.getStatus() && slot.suitable(width, depth)) {
                slots.add(slot);
            }
        }
        return slots;
    }
    public List<Vehicle> getParkedVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Slot slot : Garage.getGarage().getSlots()) {
            if(!slot.getStatus()){
                vehicles.add(slot.getVehicle());
            }
        }
        return vehicles;
    }
}
