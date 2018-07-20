public class PlayingCardGame {
    PlayingCardDeck deck;
    HandDeck hand;
    PlayingCard[] completed;
    public PlayingCardGame(){
        deck = new PlayingCardDeck();
        hand = new HandDeck();
        completed = new PlayingCard[4];
        for(int i = 0; i<4;i++) {
            PlayingCard card = new PlayingCard(CardType.values()[i+1], 0);
            card.flipCard();
            completed[i] = card;
        }
    }
    public void drawCard(int amount){
        for(int i = 0; i < amount; i++){
            PlayingCard card = deck.drawCard();
            if(card.getValue() != -1){
                hand.addCard(card);
            }
        }
    }
    public void drawCard(){
        drawCard(1);
    }
    public void showHand(){
        hand.printCards();
    }
    public void showCompleted(){
        for(PlayingCard card : completed){
            card.printCard();
        }
    }
    public void completeCard(CardType type, int value){
        int index = type.ordinal()-1;
        PlayingCard completedCard = completed[index];
        if(type == completedCard.getType()){
            if(value == completedCard.getValue()+1){
                PlayingCard compCard = hand.removeCard(type, value);
                completed[index] = compCard ;
            }
        }
    }
    public void completeCard(PlayingCard card){
        completeCard(card.getType(),card.getValue());
    }
    public void printCompleted(){
        System.out.println("The completed cards so far is:");
        for(PlayingCard card : completed){
            card.printCard();
        }
    }
}
