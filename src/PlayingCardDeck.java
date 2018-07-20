import java.util.ArrayList;

public class PlayingCardDeck {
    private ArrayList<PlayingCard> cardDeck = new ArrayList<>();

    public PlayingCardDeck() {
        for (int card = 0; card < 13; card++) {
            for (CardType type : CardType.values())
                if (type != CardType.BACKSIDE) {
                    cardDeck.add(new PlayingCard(type, (card % 13) + 1));
                }
        }
    }

    public void shuffleDeck() {
        ArrayList<PlayingCard> tempDeck = new ArrayList<>();

        while (!cardDeck.isEmpty()) {

            int index = (int) (Math.random() * cardDeck.size() - 1);
            PlayingCard card = cardDeck.remove(index);
            tempDeck.add(card);
        }
        cardDeck = tempDeck;
        printDeck();
    }

    public void printDeck() {
        System.out.println(cardDeck.size());
        for (PlayingCard card : cardDeck) {
            card.flipCard();
            System.out.println(card.getType() + " " + card.getValue());
            card.flipCard();
        }
    }

    public PlayingCard drawCard() {
        if (!cardDeck.isEmpty()) {
            PlayingCard card = cardDeck.remove(cardDeck.size() - 1);
            card.flipCard();
            return card;
        }
        return new PlayingCard(CardType.BACKSIDE, -1);
    }

    public void putCard(PlayingCard card) {
        card.flipCard();
        cardDeck.add(card);
    }
}