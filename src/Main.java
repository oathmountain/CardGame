import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //PlayingCardDeck deck = new PlayingCardDeck();
        PlayingCardGame game = new PlayingCardGame();
        while(true) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch(input){
                case 1:
                    game.drawCard();
                    break;
                case 2:
                    game.showHand();
                    break;
                case 3:
                    game.deck.printDeck();
                    break;
                case 4:
                    String type = sc.nextLine();
                    sc.nextLine();

                    int value = sc.nextInt();
                    System.out.println(game.hand.removeCard(getType(type),value));
            }

        }
        //test(deck);
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
