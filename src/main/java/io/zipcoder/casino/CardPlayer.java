package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardPlayer extends Player
{
    private ArrayList<Card> hand;

    public CardPlayer(String name, Wallet gamblingWallet)
    {
        super(name, gamblingWallet);
    }

    public ArrayList<Card> getHand()
    {
        return this.hand;
    }

}
