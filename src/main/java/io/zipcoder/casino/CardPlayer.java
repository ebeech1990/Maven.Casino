package io.zipcoder.casino;

import java.util.ArrayList;

public class CardPlayer extends Player {
    private ArrayList<PlayingCard> hand;

    public CardPlayer(){

    }

    public ArrayList<PlayingCard> getHand(){
        return this.hand;
    }

}
