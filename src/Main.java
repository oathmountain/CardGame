import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //PlayingCardDeck deck = new PlayingCardDeck();
        //test(deck);
        Scanner sc = new Scanner(System.in);
        doMenu(sc);
    }

    private static void doMenu(Scanner sc) {
        boolean notQutting = true;
        while (notQutting) {
            printMenu();
            switch(sc.nextInt()){
                case 1:
                    doGameLoop(sc);
                    //showGameRules
                    //showStatistics
                    //Quit
                    break;
            }
        }
    }

    private static void doGameLoop(Scanner sc) {
        PlayingCardGame game = new PlayingCardGame();
        boolean keepPlaying = true;
        while (keepPlaying) {
            printMenu();
            int input = sc.nextInt();
            String type;
            int value;
            switch (input) {
                case 1:
                    game.drawCard(52);
                    break;
                case 2:
                    game.showHand();
                    break;
                case 3:
                    game.deck.printDeck();
                    break;
                case 4:
                    type = getType(sc);
                    value = getValue(sc);
                    game.hand.removeCard(CardType.valueOf(type), value);
                    break;
                case 5:
                    type = getType(sc);
                    value = getValue(sc);
                    game.completeCard(CardType.valueOf(type), value);
                    game.printCompleted();
                    break;
            }
            sc.nextLine();
            System.out.println("Press enter to continue");
            sc.nextLine();
        }
    }


    private static int getValue(Scanner sc) {
        System.out.println("Type in the value of the card");
        int value = sc.nextInt();

        return value;
    }

    private static String getType(Scanner sc) {
        System.out.println("Type in the suit of the card");
        sc.nextLine();
        String type = sc.nextLine();
        type.trim();
        return type;
    }

    private static void printMenu() {
        System.out.println("Type 1 to draw a card from the deck");
        System.out.println("Type 2 to show the current hand");
        System.out.println("Type 3 to print the deck");
        System.out.println("Type 4 to remove a card from the hand");
        System.out.println("Type 5 to put a card in completed board");
    }

    private static CardType getType(String typeString){
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
    }

    private static void test(PlayingCardDeck deck) {

        deck.shuffleDeck();
        deck.drawCard().printCard();
        deck.drawCard().printCard();
        deck.drawCard().printCard();
        deck.putCard(new PlayingCard(CardType.BACKSIDE, 0));
        deck.printDeck();
    }
}
