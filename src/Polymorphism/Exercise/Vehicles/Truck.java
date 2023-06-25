package Polymorphism.Exercise.Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
      public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption+1.6, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel<=0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.setFuelQuantity(this.getFuelQuantity()+fuel*0.95);

        }

    }

    @Override
    public void drive(double kilometers) {
//        this.setFuelConsumption(this.getFuelConsumption()+1.6);
        double res = this.getFuelConsumption()*kilometers;
        if (res<this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity()-res);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            System.out.printf("Truck travelled %s km%n", decimalFormat.format(kilometers));

        }else {
            System.out.println("Truck needs refueling");
        }
    }

}
