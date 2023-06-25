package Polymorphism.Exercise.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carTokens = scanner.nextLine().split("\\s+");
        Vehicle car= new Car(Double.parseDouble(carTokens[1]),Double.parseDouble(carTokens[2]),Double.parseDouble(carTokens[3]));
        String[] truckTokens = scanner.nextLine().split("\\s+");
        Vehicle truck= new Truck(Double.parseDouble(truckTokens[1]),Double.parseDouble(truckTokens[2]),Double.parseDouble(truckTokens[3]));
        String[] busTokens = scanner.nextLine().split("\\s+");
        Vehicle bus= new Bus(Double.parseDouble(busTokens[1]),Double.parseDouble(busTokens[2]),Double.parseDouble(busTokens[3]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] actionTokens = scanner.nextLine().split("\\s+");
            String typeAction = actionTokens[0];
            String typeVehicle = actionTokens[1];
            Double amount = Double.parseDouble(actionTokens[2]);
            switch (typeAction) {
                case "Drive":
                    if (typeVehicle.equals("Car")){
                        car.drive(amount);
                    } else if (typeVehicle.equals("Truck")){
                        truck.drive(amount);
                    } else if(typeVehicle.equals("Bus")) {
                        ((Bus) bus).setEmpty(false);
                        bus.drive(amount);
                    }
                    break;
                case "Refuel":
                    if (typeVehicle.equals("Car")){
                        car.refuel(amount);
                    } else if (typeVehicle.equals("Truck")){
                        truck.refuel(amount);
                    } else if(typeVehicle.equals("Bus")){
                        bus.refuel(amount);
                    }
                    break;
                case "DriveEmpty":
                    ((Bus) bus).setEmpty(true);
                    bus.drive(amount);
                    break;
            }
        }
        System.out.printf("Car: %.2f%n",car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n",truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n",bus.getFuelQuantity());

    }
}
