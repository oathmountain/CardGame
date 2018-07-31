import java.io.Serializable;

public class Statistics implements Serializable {
    private int gamesPlayed = 0;
    private int gamesWon = 0;

    public void wonAGame(){
        gamesWon++;
    }

    public void playedAGame(){
        gamesPlayed++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public int getGamesWon(){
        return gamesWon;
    }
}
