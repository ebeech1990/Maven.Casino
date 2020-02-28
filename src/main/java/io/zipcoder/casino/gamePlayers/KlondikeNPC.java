package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Dice;
import io.zipcoder.casino.DicePlayer;
import io.zipcoder.casino.Wallet;
import jdk.nashorn.internal.runtime.logging.DebugLogger;

import java.util.logging.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class KlondikeNPC extends DicePlayer
{

    private Integer score = 0;
    private ArrayList<Dice> hand;

    public KlondikeNPC(String name, Wallet gamblingWallet) {
        super(name, gamblingWallet);
    }

    public ArrayList<Dice> getDiceHand()
    {
        return this.hand;
    }

    public Integer getScore(){
        return score;
    }

    public ArrayList<Integer> npcHand()
    {
        Dice npcDice = new Dice();
        ArrayList<Integer> opponentHand = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            opponentHand.add(npcDice.roll());
        }

        return opponentHand;
    }
}
