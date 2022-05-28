package com.company;

import java.time.LocalDateTime;

public class SimplyParkOutMethod implements IParkOut{
    @Override
    public Slot parkOut(Vehicle vehicle) {
        vehicle.getSlot().freeSlot();
        vehicle.setTime_out(LocalDateTime.now());
        return vehicle.getSlot();
    }
}
