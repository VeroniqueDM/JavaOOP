package solid;

import java.util.List;

public class Printer {
    private CalorieCalculator calorieCalculator;

    public Printer(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";
    public void printSum(List<Object> products) {
        System.out.printf((SUM) + "%n", calorieCalculator.sum(products));
    }

    public void printAverage(List<Object> products) {
        System.out.printf((AVERAGE) + "%n", calorieCalculator.average(products));
    }
}
