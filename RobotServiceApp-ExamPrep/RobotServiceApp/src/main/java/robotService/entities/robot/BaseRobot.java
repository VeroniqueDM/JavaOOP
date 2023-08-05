package robotService.entities.robot;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot{
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    protected BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        this.setKilograms(kilograms);
        this.setPrice(price);
        this.setKind(kind);
//        this.name = name;
//        this.kind = kind;
//        this.kilograms = kilograms;
//        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new NullPointerException(ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getKind() {
        return this.kind;
    }

    private void setKind(String kind) {
        if (kind.equals("") || kind == null) {
            throw new NullPointerException(ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    public int getKilograms() {
        return this.kilograms;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public abstract void eating() ;


}

