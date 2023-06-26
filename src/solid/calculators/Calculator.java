package solid.calculators;

import solid.products.Product;

import java.util.List;

public interface Calculator {
    public double sum(List<Product> products);
    public double average(List<Product> products);
}
