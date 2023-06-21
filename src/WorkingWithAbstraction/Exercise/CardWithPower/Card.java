package WorkingWithAbstraction.Exercise.CardWithPower;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;
    private int power;

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank.name(), this.cardSuit.name(), this.getPower());
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getPower() {
        return this.cardSuit.getPower() + this.cardRank.getPower();
    }

    public void setPower(int power) {
        this.power = power;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

}
