package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Wallet;

public class BlackJackHumanPlayer extends CardPlayer {


    public BlackJackHumanPlayer(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public Boolean doubleDown(){
        // TODO: if true double wager

        return null;
    }

    public Boolean split(){
        // TODO: player has option to split only if both cards match

        return null;
    }

}
