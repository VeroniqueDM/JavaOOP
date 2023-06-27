package SOLIDPrinciples.Exercise.solid.output;

import SOLIDPrinciples.Exercise.solid.products.Product;

import java.util.List;

public interface Output {
    void outputSum(List<Product> products);
    void outputAverage(List<Product> products);
}
