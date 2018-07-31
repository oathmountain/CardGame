import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doMenu(sc);
    }

    private static void doMenu(Scanner sc) {
        PlayingCardGame game;
        boolean notQuitting = true;
        while (notQuitting) {
            Menus.printMainMenu();
            switch(sc.nextInt()){
                case 1:
                    game = new PlayingCardGame();
                    game.doGameLoop(sc);
                    break;
                case 2:
                    Menus.printPatienceRules();
                    break;
                case 3:
                    break;
                case 4:
                    notQuitting = false;
                    System.out.println("Exiting game");
                    break;
            }
        }
    }
}
