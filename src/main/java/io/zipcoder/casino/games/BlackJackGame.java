package io.zipcoder.casino.games;

import io.zipcoder.casino.*;
import io.zipcoder.casino.gamePlayers.BlackJackHumanPlayer;
import io.zipcoder.casino.gamePlayers.BlackJackNPC;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.zipcoder.casino.Menu.quitApp;

public class BlackJackGame extends CardTable
{
    private static final Logger LOGGER = Logger.getLogger(BlackJackGame.class.getName());
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


    public Integer handSum(ArrayList<Card> hand) {
        Integer sum = 0;
        for(int i = 0; i < hand.size(); i++)
            sum += hand.get(i).rank().getRankValue();
        LOGGER.log(Level.INFO, "sum is: " + sum);
        return sum;
        }

        public Boolean is21(ArrayList<Card> hand) {
            if (handSum(hand).equals(21)) {
                return true;
            } else {return false;}
        }

        public void playerWins() {
            //pot += bet;
            System.out.println("You Win! Would you like to continue playing?");
            //input from player C/Q
            //continuePlaying ? setUp() : quitApp();
            LOGGER.log(Level.INFO, "player wins!" );
        }

        public void dealerWins() {
            pot = 0;
            System.out.println("Dealer wins - would you like to continue playing?");
            //input from player C/Q
           // continuePlaying ? setUp() : quitApp();
            LOGGER.log(Level.INFO, "dealer wins!" );
        }
        public void playerDecision() {
            System.out.println("What would you like to do?");
           // input.equals("H") ? playerTurn() : dealerTurn();
            LOGGER.log(Level.INFO, "What would you like to do?" );
        }

        public void playerTurn() {
            bjPlayer.receiveCard(bjDeck.deal());
            if (bjPlayer.handSum.is21()) {
                playerWins();
            } else if (bjPlayer.handSum > 21) {
                dealerWins();
            }else {playerDecision();
                }
        }

        public void dealerTurn(); {

        while (bjDealer.handSum < 17) {
            bjDealer.receiveCard(bjDeck.deal());
        }
        if (bjDealer.handSum > 21) {
            playerWins();
        } else if (bjDealer.handSum() > bjPlayer.handSum()) {
            dealerWins();
        } else {playerWins();
            }
        }
//        public Boolean instanceOfAce(ArrayList<Integer> hand); {
//            if ((handSum() > 21) && handSum().instanceof(ACE))
//}
            public void playBlackJack () {

                if (bjDealer.handSum.is21()) {
                    dealerWins();
                }
                if (bjPlayer.handSum.is21()) {
                    playerWins();
                }
                System.out.println("Dealer is showing <face up card>");
                playerDecision();
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
            public String displayTable (){
            return null;
            }


}

