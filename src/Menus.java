class Menus {
    static void printMainMenu() {
        System.out.println("1: Start a game of Patience");
        System.out.println("2: Show Patience rules");
        System.out.println("3: Show Patience statistics");
        System.out.println("4: Quit");
    }
    static void printPatienceOptions() {
        System.out.println("1: Draw card(s) from the deck");
        System.out.println("2: Show Hand");
        System.out.println("3: Show Board");
        System.out.println("4: Show Completed");
        System.out.println("5: Put the top card from hand into board");
        System.out.println("6: Put the top card from hand into completed board");
        System.out.println("7: Move card(s) on the board");
        System.out.println("8: Complete a card on board");
        System.out.println("9: Quit Game");
    }

    static void printPatienceRules(){
        System.out.println("In this game, you need to fill a deck of completed cards for each suit, in the range from 1 to 13 to win.");
        System.out.println("To do this, you have a board with 7 piles, that at the start has 1 - 7 cards in them, with only one visible.");
        System.out.println("You also have a deck from which you can draw three cars at a time. You see all three, but can only take the top card at any time.");
        System.out.println("You can put cards in the board as well, and move them around. In an empty pile, only cards with a value of 13 can be put.");
        System.out.println("The pile cards have to range from a descending order, and the adjacent card has to be of a different color-suit.");
        System.out.println("To move cards, you either first select the deck or the board to take cards from.");
        System.out.println("From the deck you pull cards to your hand, and from the hand you can then take the top card and complete it, or put it in a pile based on its number.");
        System.out.println("From the board, you can either complete a card based on its pile number, which will complete the top card of the pile.");
        System.out.println("To move cards from one pile to another, you first select the pile to move one or more cards from, then enter the number corresponding to the highest card you want to move.");
        System.out.println("And then you enter the pile number that you want to move those cards to.");
        System.out.println("When all cards are in the completed area, you have won the game.");
    }
}
