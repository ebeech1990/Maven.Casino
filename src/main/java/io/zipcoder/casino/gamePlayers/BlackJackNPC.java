package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Wallet;

public class BlackJackNPC extends CardPlayer
{
    public BlackJackNPC(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public void underSeventeen(Integer handValue){
        if(handValue < 17){
            this.hand.add(Deck[0]);
        }
    }


}
