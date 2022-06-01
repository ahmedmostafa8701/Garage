package com.company;

import java.time.Duration;

/***
 * class having a funcion which increase the total income
 */
public class SimplePayMethod implements IPay {

    /***
     * get the duration between start and end time then calculate the receipt by multiply duration * fees then increase the income
     * @param vehicle
     * @return true if pay was done succesfully
     */
    @Override
    public boolean pay(Vehicle vehicle) {
        double minutes = Duration.between(vehicle.getTime_in(), vehicle.getTime_out()).toMinutes();
        int hours = minutes % 60 == 0 ? (int)minutes / 60 : (int)minutes / 60 + 1;
        Garage.getGarage().changeIncome(hours * vehicle.getSlot().getFees());
        return true;
    }
}
