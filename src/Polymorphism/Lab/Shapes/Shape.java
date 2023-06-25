package Polymorphism.Lab.Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return calculatePerimeter();
    }

    public Double getArea() {
        return calculateArea();
    }
    public abstract double calculatePerimeter();
    public abstract double calculateArea();
}
