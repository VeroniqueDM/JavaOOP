package Polymorphism.Exercise.Vehicles;

public abstract class Vehicle {
    protected Double fuelQuantity;
    protected Double fuelConsumption;
    protected Double tankCapacity;

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        if (tankCapacity<0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.tankCapacity = tankCapacity;
        }
    }

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        setTankCapacity(tankCapacity);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity>this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract void refuel(double fuel);
    public abstract void drive(double kilometers);
}
