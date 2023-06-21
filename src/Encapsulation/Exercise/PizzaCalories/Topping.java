package Encapsulation.Exercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat")||toppingType.equals("Veggies")||toppingType.equals("Cheese")||toppingType.equals("Sauce")) {
            this.toppingType=toppingType;
        }else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }

    }

    private void setWeight(double weight) {
        if (weight<0|| weight>50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.toppingType));
        } else {
            this.weight = weight;
        }
    }
    public double calculateCalories() {
        double modifier;
        if (this.toppingType.equals("Meat")) {
            modifier = 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            modifier = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            modifier = 1.1;
        } else {
            modifier = 0.9;
        }
        return (this.weight*2)*modifier;

    }
}
