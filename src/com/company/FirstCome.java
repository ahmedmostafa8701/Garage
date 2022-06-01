package com.company;

import java.time.LocalDateTime;

/***
 * class repersent one of park in types which detect the first suitable slot for the vehicle
 */
public class FirstCome implements IParkIn{
    @Override
    public Slot parkIn(Vehicle vehicle) {
        for (Slot slot: Garage.getGarage().getSlots()) {
            if (slot.suitable(vehicle.getWidth(), vehicle.getDepth())){
                Garage.getGarage().addVehicle(vehicle, slot);
                vehicle.setTime_in(LocalDateTime.now());
                return slot;
            }
        }
        return null;
    }
}
