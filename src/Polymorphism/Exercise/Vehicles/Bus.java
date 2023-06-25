package Polymorphism.Exercise.Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    private boolean isEmpty;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);

    }

    @Override
    public void refuel(double fuel) {
        if (fuel<=0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.setFuelQuantity(this.getFuelQuantity()+fuel);

        }
    }

    @Override
    public void drive(double kilometers) {
        double res = this.getFuelConsumption()*kilometers;
        if (res<this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity()-res);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            System.out.printf("Bus travelled %s km%n", decimalFormat.format(kilometers));
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    public Double getFuelConsumption() {
        if (this.isEmpty){
            return this.fuelConsumption;

        } else {
            return this.fuelConsumption +1.4;
        }
    }
}
