package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.ArrayList;

public class AppCLI {
    public static void main(String[] args) {
        // welcome message
        Menu.welcome();

        // prompt for number of players
        int numberOfPlayers = Console.promptForInt("How many players are playing (2-7): ");

        // prompt for names of each player
        ArrayList<String> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(Console.promptForString("Name of player " + i + ": "));
        }

        // create Hand for each player
        ArrayList<Hand> hands = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            Hand hand = new Hand();
            hands.add(hand);
        }

        // create a deck
        Deck deck = new Deck();

        // shuffle cards
        deck.shuffle();

        System.out.println();
        Menu.pressEnterTo("deal 2 cards to each player: ");

        // deal 2 cards to each hand
        for (Hand hand : hands) {
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        // display each player's hand and score
        System.out.println();
        int highestScore = 0;
        String winner = "";
        for (int i = 0; i < players.size(); i++) {
            String thisPlayer = players.get(i);
            Hand thisHand = hands.get(i);
            int score = thisHand.getValue();

            System.out.println(thisPlayer + " cards: " + thisHand);
            System.out.println(thisPlayer + " score: " + score);
            System.out.println();

            //determine which player is closest to 21 without going over
            if(score <= 21 && score > highestScore) {
                highestScore = score;
                winner = players.get(i);
            }
        }

        //declare that player as the winner
        System.out.println("The winner is: " + winner);
    }
}
