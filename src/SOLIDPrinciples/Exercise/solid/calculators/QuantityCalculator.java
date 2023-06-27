package SOLIDPrinciples.Exercise.solid.calculators;

import SOLIDPrinciples.Exercise.solid.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator{
    public QuantityCalculator() {
    }

    public double sum (List<Product> products) {
        return products.stream().mapToDouble(Product::getKilograms).sum();
    }
    public double average (List <Product > products) {
        return sum(products) / products.size();
    }

}
