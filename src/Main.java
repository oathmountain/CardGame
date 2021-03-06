import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String statFile = "statistics.txt";
        Statistics stats = new Statistics();
        stats = readStats(statFile, stats);
        doMenu(sc, statFile, stats);
    }

    private static Statistics readStats(String statFile, Statistics stats) {
        try{
            FileInputStream fis = new FileInputStream(statFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            stats = (Statistics)ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception e){
            System.out.println("Stats reed error" + e);
        }
        return stats;
    }

    private static void doMenu(Scanner sc, String statFile, Statistics stats){
        Patience game;
        boolean notQuitting = true;
        while (notQuitting) {
            Menus.printMainMenu();
            switch(sc.nextInt()){
                case 1:
                    game = new Patience();
                    stats.playedAGame();
                    writeStatistics(stats,statFile);
                    boolean hasWon = game.doGameLoop(sc);
                    if(hasWon){
                        stats.wonAGame();
                        writeStatistics(stats,statFile);
                    }
                    break;
                case 2:
                    Menus.printPatienceRules();
                    break;
                case 3:
                    System.out.println("Total amount of games played: "+stats.getGamesPlayed());
                    System.out.println("Total number of won games: " + stats.getGamesWon());
                    break;
                case 4:
                    notQuitting = false;
                    System.out.println("Exiting game");
                    break;
            }
        }
    }

    private static void writeStatistics(Statistics stats, String statFile) {
        try{
            FileOutputStream out = new FileOutputStream(statFile);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(stats);
            oout.close();
            out.close();
        }catch(Exception e){
            System.out.println("Stats write error" + e);
        }
    }
}
