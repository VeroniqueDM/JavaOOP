package SOLIDPrinciples.Exercise.solid;

import SOLIDPrinciples.Exercise.solid.calculators.Calculator;
import SOLIDPrinciples.Exercise.solid.calculators.CalorieCalculator;
import SOLIDPrinciples.Exercise.solid.calculators.ProteinCalculator;
import SOLIDPrinciples.Exercise.solid.calculators.QuantityCalculator;
import SOLIDPrinciples.Exercise.solid.output.ConsoleOutput;

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
