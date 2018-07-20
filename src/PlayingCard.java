public class PlayingCard {
    private CardType type;
    private int value;
    private boolean faceUp = false;

    public PlayingCard(CardType cardType, int value){
        this.type = cardType;
        this.value = value;
    }
    public void flipCard() {
        faceUp = !faceUp;
    }

    public CardType getType(){
        if(faceUp) {
            return type;
        }else{
            return CardType.BACKSIDE;
        }
    }
    public int getValue(){
        if(faceUp) {
            return value;
        }else{
            return -1;
        }
    }
}
