import java.util.Scanner;

public class PlayingCardGame {
    PlayingCardDeck deck;
    PlayingCardHand hand;
    PlayingCard[] completed;
    PatienceBoard board;
    public PlayingCardGame(){
        deck = new PlayingCardDeck();
        hand = new PlayingCardHand();
        completed = new PlayingCard[4];
        for(int i = 0; i<4;i++) {
            PlayingCard card = new PlayingCard(PlayingCardType.values()[i+1], 0);
            card.flipCard();
            completed[i] = card;
        }
        board = new PatienceBoard(deck);
    }

    public boolean doGameLoop(Scanner sc) {
        boolean hasWon = false;
        boolean keepPlaying = true;
        while (keepPlaying) {
            hasWon = checkWinCondition();
            if (!hasWon) {
                Menus.printPatienceOptions();
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        drawCard(3);
                    case 2:
                        hand.printCards();
                        break;
                    case 3:
                        board.printBoard();
                        break;
                    case 4:
                        printCompleted();
                        break;
                    case 5:
                        System.out.println("To pile number:");
                        PlayingCard card = hand.getCard(hand.getSize() - 1);
                        if (board.addCard(sc.nextInt(), card)) {
                            hand.removeCard(hand.getSize() - 1);
                        }
                        break;
                    case 6:
                        completeHandCard();
                        printCompleted();
                        break;
                    case 7:
                        System.out.println("From pile number:");
                        int fromPile = sc.nextInt();
                        System.out.println("From card number:");
                        int fromCard = sc.nextInt();
                        System.out.println("To pile number:");
                        int toPile = sc.nextInt();
                        board.moveCard(fromPile, fromCard, toPile);
                        break;
                    case 8:
                        System.out.println("From pile number:");
                        completeBoardCard(sc.nextInt());
                        printCompleted();
                        break;
                    case 9:
                        keepPlaying = false;
                        break;
                }
                sc.nextLine();
            }else{
                System.out.println("YOU WON!!!!!!!");
                keepPlaying = false;
            }
        }
        return hasWon;
    }

    private boolean checkWinCondition() {
        for(PlayingCard card : completed){
            if(card.getValue() != 13){
                return false;
            }
        }
        return true;
    }

    public void drawCard(int amount){
        if(deck.getSize()== 0){
            int size = hand.getSize();
            for(int i = size; i>0;i--){
                PlayingCard card = hand.removeCard(i-1);
                card.flipCard();
                deck.addCard(card);
            }
        }
        if(deck.getSize() < amount){
            amount = deck.getSize();
        }
        for(int i = 0; i < amount; i++){
            PlayingCard card = deck.drawCard();
            if(card.getValue() != -1){
                hand.addCard(card);
            }
        }
    }

    public void completeHandCard(){
        PlayingCard handCard = hand.getCard(hand.getSize()-1);
        int index = completeCard(handCard);
        if(index != -1){
            PlayingCard compCard = hand.removeCard(hand.getSize()-1);
            completed[index] = compCard ;
        }
    }

    public void completeBoardCard(int pileNumber){
        PlayingCard boardCard = board.getCard(pileNumber);
        int index = completeCard(boardCard);
        if(index != -1){
            PlayingCard compCard = board.completeCard(pileNumber);
            completed[index] = compCard ;
        }
    }

    private int completeCard(PlayingCard card){
        int index = card.getType().ordinal()-1;
        PlayingCard completedCard = completed[index];

        if(card.getType() == completedCard.getType()) {
            if (card.getValue() == completedCard.getValue() + 1) {
                return index;
            }
        }
        return -1;
    }

    public void printCompleted(){
        System.out.println("The completed cards so far is:");
        for(PlayingCard card : completed){
            card.printCard();
        }
        System.out.println();
    }
}
