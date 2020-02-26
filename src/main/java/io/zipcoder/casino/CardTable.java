package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardTable {
    Deck deck;
    ArrayList<Player> players;

    abstract public void displayCards();
    abstract public void flip();


}
