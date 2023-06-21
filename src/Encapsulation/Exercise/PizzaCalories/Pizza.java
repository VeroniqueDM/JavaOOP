package Encapsulation.Exercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int countToppings) {
       setName(name);
       setToppings(countToppings);
    }

    private void setToppings(int amount) {
        if (amount>=0 && amount<=10) {
            this.toppings = new ArrayList<>(amount);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private void setName(String name) {
        if (name.trim().length()<1 || name.trim().length()>15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }
    public void addTopping (Topping topping){
        this.toppings.add(topping);

    }

    public double getOverallCalories () {
//        double res = 0;
//        res += this.dough.calculateCalories();
//        for (Topping topping : this.toppings) {
//            res += topping.calculateCalories();
//        }
//        return res;
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
