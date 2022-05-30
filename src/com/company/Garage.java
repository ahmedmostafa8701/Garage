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
    public void addVehicle(Vehicle vehicle, Slot slot){
        slot.setVehicle(vehicle);
        vehicle.setSlot(slot);
        vehicles.add(vehicle);
    }
    public boolean pay(Vehicle vehicle){
        double minutes = Duration.between(vehicle.getTime_in(), vehicle.getTime_out()).toMinutes();
        int hours = minutes % 60 == 0 ? (int)minutes / 60 : (int)minutes / 60 + 1;
        totalIncome += hours * 5 ;
        return true;
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
