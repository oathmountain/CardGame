class PlayingCard {
    private PlayingCardType type;
    private int value;
    private boolean faceUp = false;

    PlayingCard(PlayingCardType playingCardType, int value){
        this.type = playingCardType;
        this.value = value;
    }
    void flipCard() {
        faceUp = !faceUp;
    }

    PlayingCardType getType(){
        if(faceUp) {
            return type;
        }else{
            return PlayingCardType.BACKSIDE;
        }
    }
    int getValue(){
        if(faceUp) {
            return value;
        }else{
            return -1;
        }
    }
    void printCard(){
        System.out.println(getType() +" " + getValue());
    }
}
