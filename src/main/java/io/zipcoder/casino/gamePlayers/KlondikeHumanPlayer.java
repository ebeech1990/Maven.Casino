package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Dice;
import io.zipcoder.casino.DicePlayer;
import io.zipcoder.casino.Wallet;
import jdk.nashorn.internal.runtime.logging.DebugLogger;

import java.util.logging.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KlondikeHumanPlayer extends DicePlayer
{

    private Integer score = 0;
    private ArrayList<Dice> hand;

    public KlondikeHumanPlayer(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public ArrayList<Dice> getDiceHand()
    {
        return this.hand;
    }

    public Integer getScore(){
        return score;
    }

    public ArrayList<Integer> humanHand()
    {
        Dice humanDice = new Dice();
        ArrayList<Integer> playerHand = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            playerHand.add(humanDice.roll());
        }

        return playerHand;
    }
}
