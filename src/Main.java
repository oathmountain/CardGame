import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //PlayingCardDeck deck = new PlayingCardDeck();
        //test(deck);
        Scanner sc = new Scanner(System.in);
        doMenu(sc);
    }

    private static void doMenu(Scanner sc) {
        PlayingCardGame game;
        boolean notQuitting = true;
        while (notQuitting) {
            MainMenu.printMenu();
            switch(sc.nextInt()){
                case 1:
                    game = new PlayingCardGame();
                    game.doGameLoop(sc);
                    break;
                case 4:
                    notQuitting = false;
                    System.out.println("Exiting game");
                    //showGameRules
                    //showStatistics
                    //Quit
                    break;
            }
        }
    }

/*    private static CardType getType(String typeString){
        switch(typeString){
            case "CLOVER":
                return CardType.CLOVER;
            case "DIAMONDS":
                return CardType.DIAMONDS;
            case "HEARTS":
                return CardType.HEARTS;
            case "SPADES":
                return CardType.SPADES;
        }
        return null;
    }*/

/*    private static void test(PlayingCardDeck deck) {

        deck.shuffleDeck();
        deck.drawCard().printCard();
        deck.drawCard().printCard();
        deck.drawCard().printCard();
        deck.putCard(new PlayingCard(CardType.BACKSIDE, 0));
        deck.printDeck();
    }*/
}
