import java.io.Serializable;

public class Statistics implements Serializable {
    private int gamesPlayed = 0;
    private int gamesWon = 0;

    void wonAGame(){
        gamesWon++;
    }

    void playedAGame(){
        gamesPlayed++;
    }

    int getGamesPlayed() {
        return gamesPlayed;
    }
    int getGamesWon(){
        return gamesWon;
    }
}
