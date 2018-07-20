public class PlayingCardGame {
    PlayingCardDeck deck;
    HandDeck hand;
    public PlayingCardGame(){
        deck = new PlayingCardDeck();
        hand = new HandDeck();
    }
    public void drawCard(){
        hand.addCard(deck.drawCard());
    }
    public void showHand(){
        hand.printCards();
    }
}
