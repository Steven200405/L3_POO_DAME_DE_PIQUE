package fr.pantheonsorbonne.miage.engine;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.enums.CardColor;
import fr.pantheonsorbonne.miage.game.Card;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.*;


public class QueenOfSpadesGame {
    private Player player1 = new Player("player1");
    private Player player2 = new Player("player2");
    private Player player3 = new Player("player3");
    private Player player4 = new Player("player4");
    private int turn = 1;

    

    public void getWinnerTurn(Queue<Card> roundDeck){

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

        while(true){
            final Queue<Player> players = orderPlayer();
            Queue<Card> roundDeck = new LinkedList<>();
            Player firstPlayerInRound = players.poll();
            players.offer(firstPlayerInRound);
            roundDeck.add(firstPlayerInRound.throwCard(roundDeck));
            Player secondPlayerInRound = players.poll();
            players.offer(secondPlayerInRound);
            roundDeck.add(secondPlayerInRound.throwCard(roundDeck));
            Player thirdPlayerInRound = players.poll();
            players.offer(secondPlayerInRound);
            roundDeck.add(thirdPlayerInRound.throwCard(roundDeck));
            Player fourthPlayerInRound = players.poll();
            players.offer(fourthPlayerInRound);
            roundDeck.add(fourthPlayerInRound.throwCard(roundDeck));

            getWinnerTurn(null);
            Player winner = new Player(null);

            if (fourthPlayerInRound.getCards().length == 0){
                System.out.println(winner.getName() + "gagné");
                break;
            }
        }

    }

    public Player searchPlayerWithTwoOfSpade(){
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

    public Queue<Player> orderPlayer(){
        Player first = searchPlayerWithTwoOfSpade();
        Queue<Player> queue = new LinkedList<>();
        queue.add(first);
        if(first.equals(player1)){
            queue.add(player2);
            queue.add(player3);
            queue.add(player4);
        }
        else if (first.equals(player2)){
            queue.add(player3);
            queue.add(player4);
            queue.add(player1);

        }
        else if (first.equals(player3)){
            queue.add(player4);
            queue.add(player1);
            queue.add(player2);
        }
        else if(first.equals(player4)){      
            queue.add(player1);      
            queue.add(player2);
            queue.add(player3);
        }
        return queue;
    }
    
    public static void main(String[] args){
        QueenOfSpadesGame queenOfSpadesGame = new QueenOfSpadesGame();
        queenOfSpadesGame.play();
    }
}
