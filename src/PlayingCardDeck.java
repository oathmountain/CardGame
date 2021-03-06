import java.util.ArrayList;

class PlayingCardDeck {
    private ArrayList<PlayingCard> cardDeck = new ArrayList<>();

    PlayingCardDeck() {
        for (int card = 0; card < 13; card++) {
            for (PlayingCardType type : PlayingCardType.values())
                if (type != PlayingCardType.BACKSIDE) {
                    cardDeck.add(new PlayingCard(type, (card % 13) + 1));
                }
        }
        shuffleDeck();
        shuffleDeck();
        shuffleDeck();
        shuffleDeck();
    }

    private void shuffleDeck() {
        ArrayList<PlayingCard> tempDeck = new ArrayList<>();
        while (!cardDeck.isEmpty()) {
            int index = (int) (Math.random() * cardDeck.size() - 1);
            PlayingCard card = cardDeck.remove(index);
            tempDeck.add(card);
        }
        cardDeck = tempDeck;
    }

    PlayingCard drawCard() {
        if (!cardDeck.isEmpty()) {
            PlayingCard card = cardDeck.remove(cardDeck.size() - 1);
            card.flipCard();
            return card;
        }
        return new PlayingCard(PlayingCardType.BACKSIDE, -1);
    }


    void addCard(PlayingCard card) {
        cardDeck.add(card);
    }

    int getSize() {
        return cardDeck.size();
    }
}