package SOLIDPrinciples.Exercise.solid.output;

import SOLIDPrinciples.Exercise.solid.calculators.Calculator;
import SOLIDPrinciples.Exercise.solid.products.Product;

import java.util.List;

public class ConsoleOutput implements Output {
    private Calculator calculator;

    public ConsoleOutput(Calculator calculator) {
        this.calculator = calculator;
    }

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public void outputSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void outputAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
