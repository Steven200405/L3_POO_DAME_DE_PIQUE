package fr.pantheonsorbonne.miage.game;

public class Card {
    private CardValue value;
    private CardColor color;

    public Card(CardValue value, CardColor color){
        this.value = value;
        this.color = color;
    }

    public CardValue getValue(){
        return this.value;
    }

    public CardColor getColor(){
        return this.color;
    }

    @Override
    public String toString(){
        CardValue value = getValue();
        CardColor color = getColor();
        
        return "";
    }
}
