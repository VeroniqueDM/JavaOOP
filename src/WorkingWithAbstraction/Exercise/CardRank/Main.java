package WorkingWithAbstraction.Exercise.CardRank;

public class Main {
    public static void main(String[] args) {
        CardRank[] cardRanks= CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank cardRank :cardRanks
                ) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank);
        }
    }
}
