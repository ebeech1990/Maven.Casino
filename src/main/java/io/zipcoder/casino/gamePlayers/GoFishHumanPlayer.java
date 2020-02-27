package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardPlayer;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public class GoFishHumanPlayer extends CardPlayer {
    private Integer score = 0;

    public GoFishHumanPlayer(String name, Wallet gamblingWallet){
        super(name, gamblingWallet);

    }

    public Integer getScore()
    {
        return score;
    }



    public Boolean fishing(GoFishNPC target, Card.Rank desiredRank)
    {
        ArrayList<Card> stolenCards = target.fishedFrom(desiredRank);

        if(stolenCards.isEmpty())
        {
            return false;
        }
        else
        {
            hand.addAll(stolenCards);
            return true;
        }
    }

    public ArrayList<Card> fishedFrom(Card.Rank targetRank)
    {
        ArrayList<Card> fishedCards = new ArrayList<>();

        for(Card card : this.getHand())
        {
            if(card.rank().equals(targetRank))
            {
                fishedCards.add(card);
            }
        }

        this.getHand().removeAll(fishedCards);
        return fishedCards;
    }

    public Boolean takeSet(Card.Rank set)
    {
        Integer cardCount = 0;
        ArrayList<Card> foundCard = new ArrayList<>();

        if(hand.isEmpty())
        {
            return false;
        }

        for(Card card : this.hand)
        {
            if(card.rank().equals(set))
            {
                cardCount++;
                foundCard.add(card);
            }
        }

        if(cardCount < 4)
        {
            return false;
        }
        else
        {
            // TODO: Remove cards
            this.hand.removeAll(foundCard);
            score++;
            return true;
        }
    }
}