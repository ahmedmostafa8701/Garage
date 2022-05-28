package com.company;

import java.util.List;
import java.util.Scanner;

public class Form {

    Scanner scanner = new Scanner(System.in);
    private static Form form;
    private boolean isHomeOpen = false;
    private Form(){
        firstVisit();
    }
    private void firstVisit(){
        System.out.println("Enter garage capacity: ");
        int capacity = scanner.nextInt();
        double width, depth;
        for (int i = 0; i < capacity; i++) {
            System.out.print("Enter width of slot " + (i + 1) + ": ");
            width = scanner.nextDouble();
            System.out.print("Enter depth of slot " + (i + 1) + ": ");
            depth = scanner.nextDouble();
            Garage.getGarage().addSlot(new Slot(width, depth));
        }
    }
    public static Form getForm(){
        if(form == null){
            form = new Form();
        }
        return form;
    }
    public void displaySLots(List<Slot> slots){
        if(slots.size() == 0){
            System.out.println("There's no slot");
            return;
        }
        for (Slot slot:slots) {
            System.out.println(slot.toString());
        }
    }
    public void displayVehicles(List<Vehicle> vehicles){
        if(vehicles.size() == 0){
            System.out.println("There's no vehicle");
            return;
        }
        for (Vehicle vehicle:vehicles) {
            System.out.print(vehicle.toString());
        }
    }
    public void homeForm(){
        isHomeOpen = true;
        int choice;
        do{
            System.out.println("1. Customer Form");
            System.out.println("2. Admin Form");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            if(choice == 1){
                customerForm();
            }
            else if (choice == 2){
                adminMenu();
            }
            else if(choice == 0){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }while (true);
        isHomeOpen = false;
        System.out.println("Thanks.");
    }
    public void adminMenu(){
        int choice;
        do{
            System.out.println("1. get Total Income");
            System.out.println("2. Display all vehicles in garage");
            System.out.println("3. Add slots");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("Total income: " + Garage.getGarage().getTotalIncome());
            }
            else if(choice == 2){
                displayVehicles(Controller.getController().getParkedVehicle());
            }
            else if(choice == 3){
                System.out.println("Entre number of slots:");
                int capacity = scanner.nextInt();
                double width, depth;
                for (int i = 0; i < capacity; i++) {
                    System.out.print("Enter width of slot " + (i + 1) + ": ");
                    width = scanner.nextDouble();
                    System.out.print("Enter depth of slot " + (i + 1) + ": ");
                    depth = scanner.nextDouble();
                    Slot slot = new Slot(width, depth);
                    if(!Garage.getGarage().addSlot(slot)){
                        System.out.println("Can't add this slot");
                        slot = null;
                    }
                }
            }
            else if(choice == 0){
                if(!isHomeOpen){
                    homeForm();
                }
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }while (true);
    }
    public void customerForm(){
        int choice;
        String modelName;
        double width, depth;
        do{
            System.out.println("1. Display available slots");
            System.out.println("2. Display suitable slots");
            System.out.println("3. Park in");
            System.out.println("4. Park out");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            if(choice == 1){
                displaySLots(Controller.getController().getAvaliableSlots());
            }
            else if(choice == 2){
                System.out.print("Enter width: ");
                width = scanner.nextDouble();
                System.out.print("Enter depth: ");
                depth = scanner.nextDouble();
                displaySLots(Controller.getController().getSuitableSlots(width, depth));
            }
            else if(choice == 3){
                System.out.print("Enter vehicle model name: ");
                modelName = scanner.next();
                System.out.print("Enter vehicle width: ");
                width = scanner.nextDouble();
                System.out.print("Enter vehicle depth: ");
                depth = scanner.nextDouble();
                System.out.print("choose park-in method\n1-first come\n2-best fit\n");
                choice = scanner.nextInt();
                Slot slot = null;
                if(choice == 1){
                    slot = Controller.getController().parkIn(new Vehicle(modelName, width, depth), new FirstCome());
                }
                else if (choice == 2) {
                    slot = Controller.getController().parkIn(new Vehicle(modelName, width, depth), new BestFit());
                }
                if(slot == null){
                    System.out.println("Can't find suitable slot for you");
                }
                else{
                    System.out.println("Done successfully slot detail: ");
                    System.out.println(slot.getVehicle().toString());
                    System.out.println(slot.toString());
                }
            }
            else if(choice == 4){
                System.out.print("Enter vehicle ID: ");
                int vehicleId = scanner.nextInt();
                Vehicle vehicle = null;
                for (Slot slot:Garage.getGarage().getSlots()) {
                    if(!slot.getStatus() && slot.getVehicle().getID() == vehicleId){
                        vehicle = slot.getVehicle();
                        Controller.getController().parkOut(vehicle, new SimplyParkOutMethod());
                        break;
                    }
                }
                if(vehicle == null){
                    System.out.println("Can't find vehicle with this id.");
                }
                else{
                    System.out.println("Park out done successfully.");
                    System.out.println(vehicle.getSlot().toString());
                    if(Controller.getController().pay(vehicle, new SimplePayMethod())){
                        System.out.println("Pay done successfully.");
                        System.out.println(vehicle.toString());
                    }
                    else {
                        System.out.println("Failed to pay");
                    }
                }
            }
            else if(choice == 0){
                if(!isHomeOpen){
                    homeForm();
                }
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }while (true);
    }
}
