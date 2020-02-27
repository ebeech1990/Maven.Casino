package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public class GoFishNPC extends CardPlayer {

    public GoFishNPC()
    {
        super("Fishin' Joe",new Wallet(0));
    }

    public ArrayList<Card> fishedFrom(Card.Rank targetRank)
    {
        ArrayList<Card> fishedCards = new ArrayList<>();

        for(Card card : this.hand)
        {
            if(card.rank() == targetRank)
            {
                this.discard(card);
                fishedCards.add(card);
            }
        }

        return fishedCards;
    }

}