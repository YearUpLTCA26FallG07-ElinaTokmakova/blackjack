package com.pluralsight.models;

import java.util.ArrayList;

// dependent on Card class
public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // Card is dealt to Hand
    // Hand is responsible to store tha card
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    // Hand uses methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue() {
        int value = 0;

        for (Card card : cards) {
            card.flip();      // hide the card again
            value += card.getPointValue();
            card.flip();      // turn the card over to see the value
        }

        return value;
    }

    @Override
    public String toString() {
        StringBuilder hand = new StringBuilder();
        for (Card card : cards) {
            hand.append(card).append(", ");
        }
        hand.deleteCharAt(hand.length() - 2);
        return hand.toString();
    }
}
