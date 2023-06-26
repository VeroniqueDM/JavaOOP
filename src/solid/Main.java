package solid;

import solid.calculators.Calculator;
import solid.calculators.CalorieCalculator;
import solid.calculators.ProteinCalculator;
import solid.calculators.QuantityCalculator;
import solid.output.ConsoleOutput;

public class Main {

    public static void main(String[] args) {
        Calculator calorieCalculator = new CalorieCalculator();
        Calculator quantityCalculator = new QuantityCalculator();
        Calculator proteinCalculator = new ProteinCalculator();
        ConsoleOutput printerCalories = new ConsoleOutput(calorieCalculator);
        ConsoleOutput printerQuantity = new ConsoleOutput(quantityCalculator);
        ConsoleOutput printerProteins = new ConsoleOutput(proteinCalculator);


    }
}
