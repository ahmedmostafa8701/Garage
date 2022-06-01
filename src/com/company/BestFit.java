package com.company;

import java.time.LocalDateTime;
/***
 * class repersent one of park in types which detect the smallest suitable slot for the vehicle
 */
public class BestFit implements IParkIn{
    @Override
    public Slot parkIn(Vehicle vehicle) {
        Slot fit = null ;
        for (Slot slot: Garage.getGarage().getSlots()) {
            if (slot.suitable(vehicle.getWidth(), vehicle.getDepth()) && (fit == null || slot.isSmaller(fit))){
                fit = slot;
            }
        }
        if(fit != null){
            Garage.getGarage().addVehicle(vehicle, fit);
            vehicle.setTime_in(LocalDateTime.now());
        }
        return fit;
    }
}
