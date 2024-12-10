package fr.pantheonsorbonne.miage.game;



import fr.pantheonsorbonne.miage.Card;
import java.util.Random;

public class Deck extends Card {
    private final static int DECK_SIZE = 13;
    private static Card[] cards;
    private static int countDistributedCard;
    private int manche;

    static {
        countDistributedCard = 0;
        cards = new Card[52];
        Random rand = new Random();
        cards.mixCards();
    }

    private static void mixCards() {
        int index = 0;
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                cards[index++] = new Card(value, color);
            }
        }

        for (int j = 0; j < cards.length; j++) {
            Card temp = cards[j];
            int indexAleatoire = rand.nextInt(0, cards.length);
            cards[j] = cards[indexAleatoire];
            cards[indexAleatoire] = temp;
        }
    }

    public Card[] giveCards() {
        Card[] hand = new Card[DECK_SIZE];
        for (int i = countDistributedCard; i < cards.length; i++) {
            handle[i] = cards[i];
            if (i % DECK_SIZE == 0) {
                countDistributedCard = countDistributedCard + DECK_SIZE;
                break;
            }
        }
        return hand;
    }

}
