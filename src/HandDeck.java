import java.util.ArrayList;

public class HandDeck{
    private ArrayList<PlayingCard> hand;//linkedlist för performance när handen blandas in i leken?

    public HandDeck(){
        hand = new ArrayList<>();
    }

    public void printCards(){

        int i = hand.size()-3;
        if(hand.size() < 3){
            i = 0;
        }
        int cardCounter = i;
        for(; i<hand.size();i++){
            System.out.print((cardCounter)+": ");
            hand.get(i).printCard();
            cardCounter++;
        }
        System.out.println();
    }
    public void addCard(PlayingCard card){
        hand.add(card);
    }
    public PlayingCard removeCard(int cardNumber){
        return hand.remove(cardNumber);
    }

    public PlayingCard getCard(int cardNumber) {
        return hand.get(cardNumber);
    }

    public int getSize() {
        return hand.size();
    }
}
