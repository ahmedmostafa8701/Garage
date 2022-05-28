package com.company;

import java.time.Duration;

public class SimplePayMethod implements IPay {
    @Override
    public boolean pay(Vehicle vehicle) {
        double minutes = Duration.between(vehicle.getTime_in(), vehicle.getTime_out()).toMinutes();
        int hours = minutes % 60 == 0 ? (int)minutes / 60 : (int)minutes / 60 + 1;
        Garage.getGarage().changeIncome(hours * vehicle.getSlot().getFees());
        return true;
    }
}
