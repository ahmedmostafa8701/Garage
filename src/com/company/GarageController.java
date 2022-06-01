package com.company;

import java.util.ArrayList;
import java.util.List;

/***
 * The class controller in the garage system it take the information from class garage and do operation then pass it to the form to display the result
 */
public class GarageController {
    private static GarageController garageController;
    private GarageController(){

    }
    public static GarageController getController() {
        if(garageController == null){
            garageController = new GarageController();
        }
        return garageController;
    }

    /***
     * The funtion will call the park in method in the class implementing IparkIn which is different depend on type of class(type of park in method best fit or first come)
     * @param vehicle
     * @param iparkIn the interface which point to the class having function park in
     * @return The slot that vehicle became in
     */
    public Slot parkIn(Vehicle vehicle, IParkIn iparkIn) {
        return iparkIn.parkIn(vehicle);
    }

    /***
     * The funtion will call the park out method in the class implementing IparkOut which is different depend on type of class(only on simple method)
     * @param vehicle
     * @param iParkOut the interface which point to the class having function park out
     * @return The slot that vehicle left
     */
    public Slot parkOut(Vehicle vehicle, IParkOut iParkOut){
        return iParkOut.parkOut(vehicle);
    }

    /***
     * system have only one type of pay which will icrease the income by fees * number of hours
     * @param vehicle
     * @param iPay
     * @return true if pay was done succesfully
     */
    public boolean pay(Vehicle vehicle, IPay iPay){
        return iPay.pay(vehicle);
    }

    /***
     * search in the garage slots to find slots with status true
     * @return all slot active in the garage
     */
    public List<Slot> getAvaliableSlots() {
        List<Slot> slots = new ArrayList<>();
        for (Slot slot : Garage.getGarage().getSlots()) {
            if (slot.getStatus()) {
                slots.add(slot);
            }
        }
        return slots;
    }

    /***
     * find all slots have suitable area for the vehicle having width and depth
     * @param width
     * @param depth
     * @return suitable slots
     */
    public List<Slot> getSuitableSlots(double width, double depth){
        List<Slot> slots = new ArrayList<>();
        for (Slot slot : Garage.getGarage().getSlots()) {
            if (slot.getStatus() && slot.suitable(width, depth)) {
                slots.add(slot);
            }
        }
        return slots;
    }

    /***
     * search in all slots in the garage and return the vehicles parked in slots having status false(busy slots)
     * @return all vehicled parked in the garage
     */
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
