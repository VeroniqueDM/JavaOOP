package WorkingWithAbstraction.Lab.HotelReservation;

public enum Discount {
    VIP(0.2),
    SecondVisit(0.1),
    None(0);
    private double amount;

    public double getAmount() {
        return amount;
    }

    Discount(double amount) {
        this.amount = amount;
    }
}
