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

    public void swap3Cards(Card[] hand1, Card[] hand2) {
        Card[] swapCardsHand1 = getSwap3Cards(hand1);
        Card[] swapCardsHand2 = getSwap3Cards(hand2);

        swapCards(hand1, swapCardsHand1, swapCardsHand2);
        swapCards(hand2, swapCardsHand2, swapCardsHand1);

    }

    private Card[] getSwap3Cards(Card[] hand) {
        Card[] cardsToGive = new Card[3];
        Card maxCard = hand[0];
        int index = 0;
        while (index != 2) {
            for (Card card : hand) {
                if (card.getValue().getRank() > maxCard.getValue().getRank()) {
                    maxCard = card;
                }
            }
            cardsToGive[index++] = maxCard;
        }
        return cardsToGive;
    }

    private void swapCards(Card[] hand, Card[] swapCardsHand1, Card[] swapCardsHand2) {
        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < swapCardsHand1.length; j++) {
                if (hand[i].equals(swapCardsHand1[j])) {
                    hand[i] = swapCardsHand2[j];
                }
            }
        }
    }

}
