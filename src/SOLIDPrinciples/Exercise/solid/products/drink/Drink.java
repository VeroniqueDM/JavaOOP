package SOLIDPrinciples.Exercise.solid.products.drink;

import SOLIDPrinciples.Exercise.solid.products.Product;

public abstract class Drink implements Product {
    private double milliliters;
    private double density;
    private double caloriesPer100gram;

    public double getDensity() {
        return density;
    }

    public double getCaloriesPer100gram() {
        return caloriesPer100gram;
    }

    public Drink(double milliliters, double density, double caloriesPer100gram) {
        this.milliliters = milliliters;
        this.density = density;
        this.caloriesPer100gram = caloriesPer100gram;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        double grams =density*getMilliliters();
        return caloriesPer100gram*(grams/100);
    }
    @Override
    public double getKilograms(){
        return getLiters()*density;
    }
    public double getLiters(){
        return milliliters/1000;
    }
}
