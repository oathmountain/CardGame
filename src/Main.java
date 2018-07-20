public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        deck.shuffleDeck();
        deck.drawCard().printCard();
        deck.drawCard().printCard();
        deck.drawCard().printCard();
        deck.putCard(new PlayingCard(CardType.BACKSIDE, 0));
        deck.printDeck();
    }
}
