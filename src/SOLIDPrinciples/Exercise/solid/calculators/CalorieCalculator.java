package SOLIDPrinciples.Exercise.solid.calculators;

import SOLIDPrinciples.Exercise.solid.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {


    public CalorieCalculator() {
    }

    public double sum(List<Product> products) {
//        double sum = 0;
//        for (Product product : products) {
//            sum += product.getCalories();
//        }
//        return sum;
        return products.stream().mapToDouble(Product::getCalories).sum();
    }
        public double average (List <Product > products) {
            return sum(products) / products.size();
        }


    }
