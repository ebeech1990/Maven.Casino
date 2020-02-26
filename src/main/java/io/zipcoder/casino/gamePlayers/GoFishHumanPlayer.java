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

    public Boolean fishing(CardPlayer target, Card.Rank desiredRank)
    {


        return false;
    }

    public ArrayList<Card> fishedFrom(Integer number)
    {
        ArrayList<Card> fishedCards = new ArrayList<>();

        for(Card card : this.hand)
        {

        }

        return fishedCards;
    }

    public Boolean takeSet(Card.Rank set)
    {

        //if player has set increase score by 1
        //remove sets from player hand?
        return false;
    }
}
