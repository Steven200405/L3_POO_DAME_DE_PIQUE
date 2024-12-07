package fr.pantheonsorbonne.miage.game;

import Card;
import java.util.Random;

public class Deck extends Card{
    private final static int DECK_SIZE = 13;
    private final static Card[] cards;
    private int countDistributedCard = 0;

static {
        cards = new Card[52];
        Random rand = new Random();
        cards.mixCards();

    }
    private static void mixCards(){
        int index = 0;
        for(CardColor color: CardColor.values()){
            for(CardValue value: CardValue.values()){
                cards[index++] = new Card(value, color);
            }
        }

        for (int j = 0; j < cards.length; j++){
            Card temp = cards[j];
            int indexAleatoire = rand.nextInt(0, cards.length);
            cards[j] = cards[indexAleatoire];
            cards[indexAleatoire] = temp;
            }
    }
   
    private Card[] giveCards(int countRestCard){
        Card[] handle = new Card[DECK_SIZE];
        for (int i = countDistributedCard; i < cards.length; i++){
                handle[i] = cards[i];
                if(i % DECK_SIZE == 0){
                    countDistributedCard = countDistributedCard + i;
                    break;
                }
            }
            return handle;
    }
}
        
    

