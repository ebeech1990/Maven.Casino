package io.zipcoder.casino.games;

import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Game;

abstract public class CardTable implements Game
{
    Deck deck;

    public CardTable(Deck deck) {
        this.deck = deck;
    }

    abstract public String displayTable();
}