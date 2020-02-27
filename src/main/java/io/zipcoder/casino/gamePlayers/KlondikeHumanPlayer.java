package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Dice;
import io.zipcoder.casino.DicePlayer;
import io.zipcoder.casino.Wallet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KlondikeHumanPlayer extends DicePlayer
{
    private Integer score = 0;
    private Integer numOfRolls = 0;
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
        for (int i = 0; i < 5; i++)
        {
            humanHand().add(humanDice.roll());
        }

        return humanHand();
    }
}
