package io.zipcoder.casino;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GoFishHand extends Hand {

    public HashMap<Card.Rank, Integer> getRankInfo()
    {
        HashMap<Card.Rank, Integer> stats = new HashMap<>();

        for(Card card : currentHand)
        {
            if(stats.containsKey(card.rank()))
            {
                Integer count = stats.get(card.rank()) + 1;
                stats.put(card.rank(), count);
            }
            else
            {
                stats.put(card.rank(), 1);
            }
        }

        return stats;
    }

    public Boolean removeCardsOfRank(Card.Rank targetRank)
    {
        Map<Card.Rank, Integer> rankInfo = getRankInfo();

        if(rankInfo.get(targetRank) == 4)
        {
            ArrayList<Card> capturedCards = new ArrayList<>();

            for(Card card : currentHand)
            {
                if(card.rank().equals(targetRank))
                {
                    capturedCards.add(card);
                }
            }

            currentHand.removeAll(capturedCards);

            return true;
        }
        else
        {
            return false;
        }
    }
}
