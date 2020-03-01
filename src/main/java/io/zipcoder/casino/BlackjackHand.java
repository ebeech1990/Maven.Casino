package io.zipcoder.casino;

public class BlackjackHand extends Hand implements Comparable<BlackjackHand>
{
    public Integer sumOfHand()
    {
        Integer aceCounter = 0;
        Integer sum = 0;

        for(Card card : currentHand)
        {
            if(card.rank().equals(Card.Rank.ACE))
            {
                aceCounter++;
            }
            sum += card.rank().getRankValue();
        }

        while(sum > 21 && aceCounter > 1)
        {
            sum -= 10;
            aceCounter--;
        }

        return sum;
    }

    public Boolean handBusted()
    {
        if(this.sumOfHand() > 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int compareTo(BlackjackHand opponentHand)
    {
        return this.sumOfHand() - opponentHand.sumOfHand();
    }
}
