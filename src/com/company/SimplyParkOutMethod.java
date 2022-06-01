package com.company;

import java.time.LocalDateTime;

public class SimplyParkOutMethod implements IParkOut{
    /***
     * free the slot which vehicle was in then capture time out of the vehicle
     * @param vehicle
     * @return the slot which vehicle left
     */
    @Override
    public Slot parkOut(Vehicle vehicle) {
        vehicle.getSlot().freeSlot();
        vehicle.setTime_out(LocalDateTime.now());
        return vehicle.getSlot();
    }
}
