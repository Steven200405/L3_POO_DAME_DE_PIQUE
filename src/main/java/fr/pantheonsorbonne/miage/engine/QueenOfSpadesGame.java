package fr.pantheonsorbonne.miage.engine;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.Player;

public class QueenOfSpadesGame {
    private Player player1 = new Player("player1");
    private Player player2 = new Player("player2");
    private Player player3 = new Player("player3");
    private Player player4 = new Player("player4");
    public void play(){
        player1.setCards(Deck.giveCards());
        player2.setCards(Deck.giveCards());
        player3.setCards(Deck.giveCards());
        player4.setCards(Deck.giveCards());
        System.out.println("test");
    }
    
    public static void main(String[] args){
        QueenOfSpadesGame queenOfSpadesGame = new QueenOfSpadesGame();
        queenOfSpadesGame.play();
    }
}
