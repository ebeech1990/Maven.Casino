package io.zipcoder.casino.games;

import io.zipcoder.casino.*;
import io.zipcoder.casino.gamePlayers.BlackJackHumanPlayer;
import io.zipcoder.casino.gamePlayers.BlackJackNPC;
import io.zipcoder.casino.utilities.Console;

import java.util.Collections;
import java.util.List;

public class BlackJackGame extends CardTable
{
    Integer pot;// set to 0 for initial test;
    Integer tableMin;
    BlackJackHumanPlayer user;
    BlackJackNPC dealer;
    Deck bjDeck;

//    playerTurn();

    public BlackJackGame(BlackJackHumanPlayer user, Integer minAnte) {
        this.pot = 0;
        this.user = user;
        tableMin = minAnte;
        bjDeck = new Deck();
        dealer = new BlackJackNPC();
    }

    public void setUp() {
        Collections.shuffle((List<?>) bjDeck);
        bjDeck.deal();

    }



//    "Welcome to El Casino BlackJack"
//    "Please enter you bet: "

    public void displayCards()
    {

    }

    public void flip()
    {

    }







}

