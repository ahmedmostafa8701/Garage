package com.company;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class Garage {

    private static Garage garage;

    public static Garage getGarage(){
        if(garage == null){
            garage = new Garage();
        }
        return garage;
    }
    private double totalIncome = 0;
    private List<Vehicle> vehicles;
    private List<Slot> slots;

    public boolean isFull(){
        return true;
    }
    private Garage() {
        vehicles = new LinkedList();
        slots = new LinkedList<>();
    }
    public boolean addSlot(Slot slot) {
        if (isFull()){
            slots.add(slot);
        }
        return !isFull();
    }

    /***
     * add vehicle to the garage
     * @param vehicle
     * @param slot
     */
    public void addVehicle(Vehicle vehicle, Slot slot){
        slot.setVehicle(vehicle);
        vehicle.setSlot(slot);
        vehicles.add(vehicle);
    }
    public Vehicle getVehicle(int id){
        if(id >= 1 && id <= vehicles.size()){
            return vehicles.get(id - 1);
        }
        return null;
    }
    public double getTotalIncome(){
        return totalIncome;
    }
    public void changeIncome(double change) {
        this.totalIncome += change;
    }
    public List<Slot> getSlots() {
        return slots;
    }
}
