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

    public Integer pairHuman(ArrayList<Integer> a)
    {
        score = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = i + 1; j < 5; j++)
            {
                if ((a.get(i).equals(a.get(j))) && (a.get(i) > score))
                {
                    score = a.get(i);
                }
            }
        }
        if (score == 0)
        {
            return 0;
        }
        else
        {
            return score;
        }
    }

    public Integer twoPairHuman(ArrayList<Integer> a) {
        score = 0;
        int count = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = i + 1; j < 5; j++)
            {
                if ((a.get(i).equals(a.get(j))) && (a.get(i) != score))
                {
                    count++;
                    if (a.get(i) > score)
                    {
                        score = a.get(i);
                    }
                }
            }
        }
        if (count == 2)
        {
            return score;
        }
        else
        {
            return 0;
        }
    }

    public Integer tripleHuman(ArrayList<Integer> a)
    {
        score = 0;
        int count = 0;
        for (int i = 0; i < 4; i++)
        {
            if (count == 2)
            {
                score = a.get(i);
            }
            count = 0;
            for (int j = i + 1; j < 5; j++)
            {
                if (a.get(i).equals(a.get(j)))
                {
                    count++;
                }
            }
        }
        return score;
    }

    public Integer fullHouseHuman(ArrayList<Integer> a)
    {
        score = 0;
        int count = 0;
        for (int i = 0; i < 4; i++)
        {
            if (count == 2)
            {
                score = a.get(i);
            }
            count = 0;
            for (int j = i + 1; j < 5; j++)
            {
                if (a.get(i).equals((a.get(j))))
                {
                    count++;
                }
            }
        }
        if (score != 0)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = i + 1; j < 5; j++)
                {
                    if ((a.get(i).equals(a.get(j))) && (a.get(i) != score))
                    {
                        return score;
                    }
                }
            }
        }
        return 0;
    }
}
