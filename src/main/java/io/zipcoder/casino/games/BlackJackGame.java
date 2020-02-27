package io.zipcoder.casino.games;

import io.zipcoder.casino.*;
import io.zipcoder.casino.gamePlayers.BlackJackHumanPlayer;
import io.zipcoder.casino.gamePlayers.BlackJackNPC;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.zipcoder.casino.Menu.quitApp;

public class BlackJackGame extends CardTable
{
    Integer pot;// set to 0 for initial test;
    Integer tableMin;
    BlackJackHumanPlayer bjPlayer;
    BlackJackNPC bjDealer;

    Deck bjDeck;

//    playerTurn();

    public BlackJackGame(BlackJackHumanPlayer user, Integer minAnte) {
        this.pot = 0;
        this.bjPlayer = user;
        tableMin = minAnte;
        bjDeck = new Deck();
        bjDealer = new BlackJackNPC();

    }

    public void setUp() {
        Integer bet = 0; //place holder for user input
 //     User input - What do you want to bet?
        if (bet < tableMin) {quitApp();}
        Collections.shuffle((List<?>) bjDeck);
        bjPlayer.receiveCard(bjDeck.deal());
//        bjDealer.receiveCard(bjDeck.deal()); bjDealer not set up yet
        bjPlayer.receiveCard(bjDeck.deal());
//        bjDealer.receiveCard(bjDeck.deal()); bjDealer not set up yet
    }

    public Integer handSum(ArrayList<Integer> hand) {
        Integer sum = 0;
        for(int i = 0; i < hand.size(); i++)
            sum += hand.get(i);
        return sum;
    }

        public Boolean is21(ArrayList<Integer> hand) {
            if (hand.equals(21)) {
                return true;
            } else {return false;}
        }

        public void playBlackJack() {

        if (bjDealer.handSum.equals(21) {
            pot -= bet;
            System.out.println("Dealer wins - would you like to continue playing?");
            //input from player C/Q
            continuePlaying ? setUp() : quitApp();
            }
        }


//    public void playBlackJack() {
////        C = continue playing       Q = exit game
//        if (bjDealer.handSum() == 21) {
//            pot -= bet;
////          "Dealer wins - would you like to continue playing?" C/Q
//            continuePlaying ? setUp() : quitApp();
//        }
//        if (bjPlayer.handSum == 21) {
//            pot += bet;
////          "You Win! Would you like to continue playing?" Q/C
//            continuePlaying ? setUp() : quitApp();
//        }
////       "Dealer is showing <face up card> - what would you like to do?"
////          "Hit" or "Stand"
//        if (input == "H") {bjPlayer.receiveCard(bjDeck.deal());}
//
//        if (bjDealer.handSum < 17) {
//            bjDealer.receiveCard(bjDeck.deal());
//        }
//
//
//    }

    public void displayCards()
    {

    }

    {

    }







}

