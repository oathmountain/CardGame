import java.util.HashMap;

public class HandDeck{
    private HashMap<String, PlayingCard> cardDeck;

    public HandDeck(){
        cardDeck = new HashMap<>();
    }

    public void printCards(){
        for(HashMap.Entry<String, PlayingCard> entry : cardDeck.entrySet()){
            PlayingCard card = entry.getValue();
            //card.flipCard();
            card.printCard();
        }
    }
    public void addCard(PlayingCard card){
        //card.flipCard();
        cardDeck.put(card.getType() + " " + card.getValue(), card);
    }
    public PlayingCard removeCard(CardType type, int value){
        return cardDeck.remove(type + " " + value);
    }
}
