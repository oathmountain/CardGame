import java.util.Scanner;

class Patience {
    private PlayingCardDeck deck;
    private PatienceHand hand;
    private PlayingCard[] completed;
    private PatienceBoard board;

    Patience(){
        deck = new PlayingCardDeck();
        hand = new PatienceHand();
        completed = new PlayingCard[4];
        for(int i = 0; i<4;i++) {
            PlayingCard card = new PlayingCard(PlayingCardType.values()[i+1], 0);
            card.flipCard();
            completed[i] = card;
        }
        board = new PatienceBoard(deck);
    }

    boolean doGameLoop(Scanner sc) {
        boolean keepPlaying = true;
        while (keepPlaying) {
            if (checkWinCondition()) {
                Menus.printPatienceOptions();
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        drawCard();
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
                        moveHandCardToBoard(sc);
                        break;
                    case 6:
                        completeHandCard();
                        printCompleted();
                        break;
                    case 7:
                        moveBoardCards(sc);
                        break;
                    case 8:
                        completeBoardCard(sc);
                        printCompleted();
                        break;
                    case 9:
                        keepPlaying = false;
                        break;
                }
                sc.nextLine();
            }else{
                System.out.println("YOU WON!!!!!!!");
                return true;
            }
        }
        return false;
    }

    private void moveBoardCards(Scanner sc) {
        System.out.println("From pile number:");
        int fromPile = sc.nextInt();
        System.out.println("From card number:");
        int fromCard = sc.nextInt();
        System.out.println("To pile number:");
        int toPile = sc.nextInt();
        board.moveCard(fromPile, fromCard, toPile);
    }

    private void moveHandCardToBoard(Scanner sc) {
        System.out.println("To pile number:");
        PlayingCard card = hand.getCard(hand.getSize() - 1);
        if (board.addCard(sc.nextInt(), card)) {
            hand.removeCard(hand.getSize() - 1);
        }
    }

    private boolean checkWinCondition() {
        for(PlayingCard card : completed){
            if(card.getValue() != 13){
                return false;
            }
        }
        return true;
    }

    private void drawCard(){
        int amount = 3;
        if(deck.getSize()== 0){
            refillDeckFromHand();
        }
        if(deck.getSize() < amount){
            amount = deck.getSize();
        }
        drawTheCards(amount);
    }

    private void drawTheCards(int amount) {
        for(int i = 0; i < amount; i++){
            PlayingCard card = deck.drawCard();
            if(card.getValue() != -1){
                hand.addCard(card);
            }
        }
    }

    private void refillDeckFromHand() {
        int size = hand.getSize();
        for(int i = size; i>0;i--){
            PlayingCard card = hand.removeCard(i-1);
            card.flipCard();
            deck.addCard(card);
        }
    }

    private void completeHandCard(){
        PlayingCard handCard = hand.getCard(hand.getSize()-1);
        int index = completeCard(handCard);
        if(index != -1){
            PlayingCard compCard = hand.removeCard(hand.getSize()-1);
            completed[index] = compCard ;
        }
    }

    private void completeBoardCard(Scanner sc){
        System.out.println("From pile number:");
        int pileNumber = sc.nextInt();
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

    private void printCompleted(){
        System.out.println("The completed cards so far is:");
        for(PlayingCard card : completed){
            card.printCard();
        }
        System.out.println();
    }
}
