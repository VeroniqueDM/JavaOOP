package Encapsulation.Exercise.ShoppingSpree;


import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new LinkedList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty())  {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else
            this.money = money;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String res;
        if (this.products.isEmpty()) {
            res = String.format("%s – Nothing bought", this.getName());
        } else {
            res = String.format("%s - %s", this.name, String.join(", " ,this.products.toString()).replace("[","").replace("]",""));
        }
        return res;
    }

    public void buyProduct (Product product){
        if (this.money<product.getCost()) {
            throw new RuntimeException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        } else {
            System.out.printf("%s bought %s%n", this.getName(),product.getName());
            this.products.add(product);
            setMoney(this.money-product.getCost());
        }
    }
}
