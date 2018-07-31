public class PlayingCard {
    private PlayingCardType type;
    private int value;
    private boolean faceUp = false;

    public PlayingCard(PlayingCardType playingCardType, int value){
        this.type = playingCardType;
        this.value = value;
    }
    public void flipCard() {
        faceUp = !faceUp;
    }

    public PlayingCardType getType(){
        if(faceUp) {
            return type;
        }else{
            return PlayingCardType.BACKSIDE;
        }
    }
    public int getValue(){
        if(faceUp) {
            return value;
        }else{
            return -1;
        }
    }
    public void printCard(){
        System.out.println(getType() +" " + getValue());
    }
}
