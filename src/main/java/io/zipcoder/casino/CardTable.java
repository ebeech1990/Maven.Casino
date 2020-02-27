package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardTable {
    Deck deck;
    Player players;

    abstract public void displayCards();
 //   abstract public void flip(); Redundant function ? Same as deal in Deck


}
