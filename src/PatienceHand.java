import java.util.ArrayList;

class PatienceHand {
    private ArrayList<PlayingCard> hand = new ArrayList<>();

    void printCards(){
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

    void addCard(PlayingCard card){
        hand.add(card);
    }

    PlayingCard removeCard(int cardNumber){
        return hand.remove(cardNumber);
    }

    PlayingCard getCard(int cardNumber) {
        return hand.get(cardNumber);
    }

    int getSize() {
        return hand.size();
    }
}
