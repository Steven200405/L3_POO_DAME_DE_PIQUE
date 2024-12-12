package fr.pantheonsorbonne.miage.game;
import java.util.Queue;

import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.enums.CardValue;

public class Player {
    private String name;
    private Card[] cards;
    private int points;
    public Player(String name){
        this.name = name;
        this.cards = new Card[13];
        this.points = 0;
    }
    public void setCards(Card[] cards){
        this.cards = cards;
    }

    public String getName(){
        return this.name;
    }

    public Card[] getCards(){
        return this.cards;
    }

    public void swap3Cards(Player otherPlayer) {
        Card[] swapCardsHand1 = this.getSwap3Cards();
        Card[] swapCardsHand2 = otherPlayer.getSwap3Cards();

        swapCards(this, swapCardsHand1, swapCardsHand2);
        swapCards(otherPlayer, swapCardsHand2, swapCardsHand1);

    }

    private Card[] getSwap3Cards() {
        Card[] cardsToGive = new Card[3];
        Card maxCard = this.cards[0];
        int index = 0;
        while (index != 2) {
            for (Card card : this.cards) {
                if (card.getValue().getRank() > maxCard.getValue().getRank()) {
                    maxCard = card;
                }
            }
            cardsToGive[index++] = maxCard;
        }
        return cardsToGive;
    }

    private void swapCards(Player player, Card[] swapCardsHand1, Card[] swapCardsHand2) {
        Card[] handle = player.getCards();
        for (int i = 0; i < handle.length; i++) {
            for (int j = 0; j < swapCardsHand1.length; j++) {
                if (handle[i].equals(swapCardsHand1[j])) {
                    handle[i] = swapCardsHand2[j];
                }
            }
        }
        player.setCards(handle);
    }

    public Card throwCard(Queue roundDeck){
        Card bestCards= this.cards[0];
        if(roundDeck.size()<=4){
            
        }
        else{
            for(Card card : this.cards){
            }
        }

    }
}
