package com.pluralsight.models;

// primary object in Application
public class Card {
    private String suit;
    private String value; // Ace, King, Queen, Jack, 2, 3, 4, 5, 6, 7, 8, 9, 10
    private boolean faceUp;

    //constructor
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
    }

    //getters
    public String getSuit() {
        // only return the suit if the card is face up
        if (faceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        // only return the value if the card is face up
        if (faceUp) {
            // this is the string value of the card
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
       // only return the value if the card is face up
        if (faceUp) {
            //todo determine point value and return it
            return switch (this.value.toUpperCase()) {
                case "ACE" -> 11;
                case "KING", "JACK", "QUEEN", "10" -> 19;
                case "9" -> 9;
                case "8" -> 8;
                case "7" -> 7;
                case "6" -> 6;
                case "5" -> 5;
                case "4" -> 4;
                case "3" -> 3;
                case "2" -> 2;
                default -> throw new IllegalStateException("Invalid value: " + this.value.toUpperCase());
            };
        } else {
            return 0;
        }
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    //methods
    public boolean flip() {
        //change faceUp to false if true and vice versa
        return (this.faceUp = !this.faceUp);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value='" + value + '\'' +
                ", faceUp=" + faceUp +
                '}';
    }
}
