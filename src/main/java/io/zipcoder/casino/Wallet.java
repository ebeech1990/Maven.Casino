package io.zipcoder.casino;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wallet
{
    private static final Logger LOGGER = Logger.getLogger(Wallet.class.getName());
    Integer chipsBalance;

    public Wallet()
    {
        chipsBalance = 0;
    }

    public Wallet(Integer initChips)
    {
        chipsBalance = initChips;
    }

    public Integer deposit(Integer addedChips)
    {
        if(addedChips < 0)
        {
            LOGGER.log(Level.WARNING, String.format("Attempted to deposit a negative value (%d) to wallet", addedChips));
            return -1;
        }

        chipsBalance += addedChips;

        return chipsBalance;
    }

    public Integer withdraw(Integer removedChips)
    {

        if(removedChips < 0)
        {
            LOGGER.log(Level.WARNING, String.format("Attempted to withdraw a negative value (%d) to wallet", removedChips));

            return 0;
        }
        else if(removedChips > chipsBalance)
        {
            LOGGER.log(Level.WARNING, String.format("Attempted to overdraw (%d) wallet balance %d", removedChips, chipsBalance));
            return 0;
        }
        else
        {
            chipsBalance -= removedChips;

            return removedChips;
        }
    }

    public Integer balance()
    {
        return chipsBalance;
    }
}
