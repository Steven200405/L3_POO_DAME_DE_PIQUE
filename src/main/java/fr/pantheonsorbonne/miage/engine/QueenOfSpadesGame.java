package fr.pantheonsorbonne.miage.engine;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.game.Card;

import java.util.*;


public class QueenOfSpadesGame {
    private Player player1 = new Player("player1");
    private Player player2 = new Player("player2");
    private Player player3 = new Player("player3");
    private Player player4 = new Player("player4");
    private int turn = 1;

    public Card getWinnerCard(Queue<Card> roundDeck){
        Card highCardValue = roundDeck.peek();
        Card currentCard = roundDeck.peek();
        while(roundDeck.size() !=0){
            if (currentCard.getValue().ordinal() > highCardValue.getValue().ordinal()){
                highCardValue = currentCard;
            }
            currentCard = roundDeck.peek();
        }
        return highCardValue;
    }

    public int givePointsToWinnerTurn(Queue<Card> roundDeck){
        int countPointsHeartCards = 0;
        Card currentCard = roundDeck.peek();
        while (roundDeck.size() !=0){
            if(currentCard.getColor().toString().equals("Spade")){
                if(currentCard.getValue().toString().equals("Queen")){
                    countPointsHeartCards += 13;
                }
            }
            else if (currentCard.getColor().toString().equals("Heart")){
                countPointsHeartCards++;
            }
            roundDeck.poll();
            currentCard = roundDeck.peek();
        }
        return countPointsHeartCards;
    }

    public Player getWinnerTurn(Queue<Player> playersOrder, Queue<Card> roundDeck){
        Player winnerPlayer = null;
        Card winnerCard = getWinnerCard(roundDeck);
        Card currentCard = roundDeck.peek();
        Player currentPlayer = playersOrder.peek();
        while(currentCard != winnerCard){
            roundDeck.poll();
            playersOrder.poll();
            currentCard = roundDeck.peek();
            currentPlayer = playersOrder.peek();
            
        }
        winnerPlayer = currentPlayer;
        winnerPlayer.setPoints(givePointsToWinnerTurn(roundDeck));
        return winnerPlayer;
    }

    public void play(){
        player1.setCards(Deck.giveCards());
        player2.setCards(Deck.giveCards());
        player3.setCards(Deck.giveCards());
        player4.setCards(Deck.giveCards());


        /* 
        if(){
        final Queue <String> players = new LinkedList();
            swap3Cards(player1);
            swap3Cards(player2);
            swap3Cards(player3);
            swap3Cards(player4);
        }
        */
        Player firstPlayer=null;
        while(true){                
            if(turn == 1){
                 firstPlayer = searchPlayerWithTwoOfClub();
            }
            Queue<Player> players = orderPlayer(firstPlayer);
            Queue<Card> roundDeck = new LinkedList<>();
            
            Player firstPlayerInRound = players.poll();
            players.offer(firstPlayerInRound);

            roundDeck.offer(throwCard(Card card));
            Player secondPlayerInRound = players.poll();
            players.offer(secondPlayerInRound);
            roundDeck.offer(throwCard(Card card));
            Player thirdPlayerInRound = players.poll();
            players.offer(secondPlayerInRound);
            roundDeck.offer(throwCard(Card card));
            Player fourthPlayerInRound = players.poll();
            players.offer(fourthPlayerInRound);
            roundDeck.offer(throwCard(Card card));

            Player winner = getWinnerTurn(players, roundDeck);
            firstPlayer = winner;
            if (fourthPlayerInRound.getCards().length == 0){
                System.out.println(winner.getName() + "gagné");
                break;
            }
            turn++;
        }

    }

    public Player searchPlayerWithTwoOfClub(){
        Player firstPlayer = null;
        Iterable<Player> players = new ArrayList<>();
        for(Player player : players){
            for(Card card: player.getCards()){
                if(card.getValue().getRank() == 2 && card.getColor() == CardColor.valueOf("CLUB")){
                    firstPlayer = player;
                }
            }
        }
        return firstPlayer;
    }

    public Queue<Player> orderPlayer(Player first){
        Queue<Player> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(player1, player2, player3, player4));
        Player playerPeeked = queue.peek();
        while(!first.equals(playerPeeked)){
            queue.poll();
            queue.offer(playerPeeked);
            playerPeeked = queue.peek();
        }
        return queue;
    }
    
    public static void main(String[] args){
        QueenOfSpadesGame queenOfSpadesGame = new QueenOfSpadesGame();
        queenOfSpadesGame.play();
    }
}
