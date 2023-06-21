package WorkingWithAbstraction.Exercise.CardSuit;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        CardSuit[] cardSuit = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit cardS :
                cardSuit) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardS.ordinal(), cardS);
        }

    }
}
