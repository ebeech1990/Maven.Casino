package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Wallet;

public class GoFishHumanPlayer extends CardPlayer
{
    public Integer score = 0;

    public GoFishHumanPlayer(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }


    public Boolean fishing(Integer number)
    {

        return false;
    }

    public Boolean takeSet(Integer number)
    {
        //if player has set increase score by 1
        //remove sets from player hand?
        return false;
    }
}git
