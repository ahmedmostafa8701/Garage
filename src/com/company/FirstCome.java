package com.company;

import java.time.LocalDateTime;

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
