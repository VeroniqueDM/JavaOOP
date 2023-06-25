package Polymorphism.Exercise.Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle{

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption+0.9, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel<=0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.setFuelQuantity(this.getFuelQuantity()+fuel);

        }    }

    @Override
    public void drive(double kilometers) {
        double res = this.getFuelConsumption()*kilometers;
        if (res<this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity()-res);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            System.out.printf("Car travelled %s km%n", decimalFormat.format(kilometers));
        } else {
            System.out.println("Car needs refueling");
        }
    }
}
