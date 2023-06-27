package SOLIDPrinciples.Exercise.solid.products.food;

import SOLIDPrinciples.Exercise.solid.products.Product;

public abstract class Food implements Product {
    private double grams;
    private double caloriesPer100grams;

    public Food(double grams, double caloriesPer100grams) {
        this.grams = grams;
        this.caloriesPer100grams = caloriesPer100grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return caloriesPer100grams*(getGrams()/100);
    }
    public double getKilograms(){
        return grams/1000;
    }
}
