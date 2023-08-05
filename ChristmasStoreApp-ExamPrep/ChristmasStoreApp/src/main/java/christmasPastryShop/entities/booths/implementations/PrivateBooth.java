package christmasPastryShop.entities.booths.implementations;

public class PrivateBooth extends BaseBooth{
    private static final double PRICE_PER_PERSON = 3.50;
    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON);
    }
}
