package io.zipcoder.casino.games;

import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.CardTable;
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.gamePlayers.BlackJackHumanPlayer;
import io.zipcoder.casino.gamePlayers.BlackJackNPC;
import io.zipcoder.casino.utilities.Console;

public class BlackJackGame extends CardTable
{
    Integer pot = 0;// set to 0 for initial test;
    Integer tableMin = 20;

//    setUp(int);
//    playerTurn();

    BlackJackHumanPlayer bjPlayer = new BlackJackHumanPlayer(); // not defined yet
    BlackJackNPC bjDealer = new BlackJackNPC();
    Deck bjDeck = new Deck();


    public BlackJackGame(Integer pot) {
        this.pot = pot;
    }

//    "Welcome to El Casino BlackJack"
//    "Please enter you bet: "









}

