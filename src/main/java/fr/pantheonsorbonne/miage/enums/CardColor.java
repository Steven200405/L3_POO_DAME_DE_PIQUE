package fr.pantheonsorbonne.miage.enums;

public enum CardColor {
    HEART, SPADE, CLUB, DIAMOND;

    public String getStringRepresentation(CardColor color) {
        return color.toString();
    }
}