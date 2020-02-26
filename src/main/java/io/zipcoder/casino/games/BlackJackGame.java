package io.zipcoder.casino.games;

import io.zipcoder.casino.CardTable;

public class BlackJackGame extends CardTable {
    Integer pot = 0;
    Deck bjDeck;

    setUp(int);
    playerTurn();

    CardPlayer bjPlayer = new CardPlayer();
}
