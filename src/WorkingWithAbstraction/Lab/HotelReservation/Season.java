package WorkingWithAbstraction.Lab.HotelReservation;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4)
    ;

    public int getMultiplier() {
        return multiplier;
    }

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    private int multiplier;
}
