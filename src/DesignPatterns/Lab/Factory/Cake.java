package DesignPatterns.Lab.Factory;


public class Cake implements CakeInterface {
    public double diameter;
    public double price;
    public int pieces;
    private String type;

    public Cake(double diameter, double price, int pieces) {
        this.diameter = diameter;
        this.price = price;
        this.pieces = pieces;
    }

    public void prepare() {
        System.out.println("Prepare cake");
    }

    public void bake() {
        System.out.println("Bake cake");
    }

    public void box() {
        System.out.println("Box cake");
    }

    ;
}
