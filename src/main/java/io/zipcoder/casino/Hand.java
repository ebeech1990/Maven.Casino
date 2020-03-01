package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    ArrayList<Card> currentHand;

    public Hand()
    {
        this(new ArrayList<Card>());
    }

    public Hand(List<Card> cardsForHand)
    {
        currentHand = new ArrayList<>();
        currentHand.addAll(cardsForHand);
    }

    public ArrayList<Card> getCurrentHand()
    {
        return currentHand;
    }

    public Boolean addCard(Card cardToBeAdded)
    {
        currentHand.add(cardToBeAdded);
        return currentHand.contains(cardToBeAdded);
    }

    public Boolean removeCard(Card cardToRemove)
    {
        currentHand.remove(cardToRemove);

        return (!currentHand.contains(cardToRemove));
    }
}