package WorkingWithAbstraction.Lab.HotelReservation;

public class PriceCalculator {
    public static double calculateFinalPrice(double pricePerDay, int numOfDays, Season season, Discount discount ) {
        return pricePerDay*numOfDays*season.getMultiplier()*(1-discount.getAmount());
    }
}
