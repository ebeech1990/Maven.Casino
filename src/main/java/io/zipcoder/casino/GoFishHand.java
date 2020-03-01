package io.zipcoder.casino;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Hand;

import java.util.HashMap;

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
}
