package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Wallet;

public class BlackJackNPC extends CardPlayer
{
    public BlackJackNPC(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public boolean underSeventeen(Integer handValue){
        return handValue < 17;
    }



}
