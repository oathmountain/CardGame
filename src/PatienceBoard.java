import java.util.ArrayList;

class PatienceBoard {
    private ArrayList<ArrayList<PlayingCard>> board;

    PatienceBoard(PlayingCardDeck deck){
        board = new ArrayList<>(7);
        for(int i= 0; i<7;i++){
            board.add(new ArrayList<>());
        }
        fillBoard(deck);
        printBoard();
    }

    private void fillBoard(PlayingCardDeck deck) {
        for(int i = 0;i<7;i++){
            for(int j = i;j<7;j++){
                PlayingCard card = deck.drawCard();
                if(i!=j){
                    card.flipCard();
                }
                board.get(j).add(card);
            }
        }
    }

    void printBoard(){
        for(int i = 0; i<7;i++){
            System.out.println("Pile "+i+":");
            for(int j = board.get(i).size()-1;j>=0;j--){
                if(board.get(i).size()>j){
                    System.out.print((j)+":");
                    board.get(i).get(j).printCard();
                }else{
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    void moveCard(int fromPile, int fromCard, int toPile){
        if(checkPileInputs(fromPile, toPile)){
            ArrayList<PlayingCard> fromDeck = board.get(fromPile);
            ArrayList<PlayingCard> toDeck = board.get(toPile);

            if(fromCard <= fromDeck.size()){
                PlayingCard movingCard = fromDeck.get(fromCard);

                if(isMovePossible(toDeck, movingCard)){
                    doMove(fromCard, fromDeck, toDeck);
                    printBoard();
                }
            }
        }
    }

    private void doMove(int fromCard, ArrayList<PlayingCard> fromDeck, ArrayList<PlayingCard> toDeck) {
        int size = fromDeck.size();
        for(int i = fromCard; i<size;i++){
            toDeck.add(fromDeck.remove(fromCard));
        }
        if(!fromDeck.isEmpty()){
            fromDeck.get(fromDeck.size()-1).flipCard();
        }
    }

    private boolean isMovePossible(ArrayList<PlayingCard> toDeck, PlayingCard movingCard) {
        boolean doMove = false;
        if(!toDeck.isEmpty()) {
            PlayingCard toCard = toDeck.get(toDeck.size() - 1);
            if(movingCard.getValue()+1 == toCard.getValue()){
                if(movingCard.getType().ordinal() % 2 != toCard.getType().ordinal() %2){
                    doMove = true;
                }
            }
        }

        if(movingCard.getValue() == 13 && toDeck.isEmpty()){
            doMove = true;
        }
        return doMove;
    }

    private boolean checkPileInputs(int fromPile, int toPile) {
        return fromPile > 0 && fromPile < 7 && toPile > 0 && toPile <7;
    }

    PlayingCard completeCard(int fromPile){
        ArrayList<PlayingCard> thePile = board.get(fromPile);
        PlayingCard card = thePile.remove(thePile.size()-1);

        if(!thePile.isEmpty() && thePile.get(thePile.size()-1).getValue() == -1) {
            thePile.get(thePile.size() - 1).flipCard();
        }
        printBoard();
        return card;
    }

    PlayingCard getCard(int pile){
        ArrayList<PlayingCard> cardPile = board.get(pile);
        return cardPile.get(cardPile.size()-1);
    }

    boolean addCard(int pile, PlayingCard card) {
        ArrayList<PlayingCard> thePile = board.get(pile);
        PlayingCard pileCard = thePile.get(thePile.size()-1);
        if(pileCard.getValue() == card.getValue()+1){
            if(pileCard.getType().ordinal() % 2 != card.getType().ordinal() %2) {
                thePile.add(card);
                printBoard();
                return true;
            }
        }
        System.out.println("Did not match");
        return false;
    }
}
