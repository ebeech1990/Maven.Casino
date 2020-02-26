package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardPlayer extends Player
{
    private ArrayList<PlayingCard> hand;

    public CardPlayer(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public ArrayList<PlayingCard> getHand(){
        return this.hand;
    }

}
