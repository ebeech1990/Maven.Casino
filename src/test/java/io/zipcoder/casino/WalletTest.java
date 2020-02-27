package io.zipcoder.casino;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WalletTest {
    Wallet testWallet;

    @Test
    public void checkBalance()
    {
        // GIVEN

        testWallet = new Wallet(500);
        Integer expected = 500;

        // WHEN

        Integer actual = testWallet.balance();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void depositWallet()
    {
        // GIVEN

        testWallet = new Wallet(500);
        Integer expected = 1000;

        // WHEN

        Integer actualFeedback = testWallet.deposit(500);
        Integer actualBalance = testWallet.balance();

        // THEN

        assertEquals(expected, actualFeedback);
        assertEquals(expected, actualBalance);
    }

    @Test
    public void withdrawWallet()
    {
        // GIVEN

        testWallet = new Wallet(500);
        Integer expected = 500;
        Integer expectedBalance = 0;

        // WHEN

        Integer actual = testWallet.withdraw(500);
        Integer actualBalance = testWallet.balance();

        // THEN

        assertEquals(expected, actual);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void overdrawWallet()
    {
        // GIVEN

        testWallet = new Wallet(500);
        Integer expected = 0;
        Integer expectedBalance = 500;

        // WHEN

        Integer actual = testWallet.withdraw(1000);
        Integer actualBalance = testWallet.balance();

        // THEN

        assertEquals(expected, actual);
        assertEquals(actualBalance, actualBalance);
    }

    @Test
    public void depositNegative()
    {
        // GIVEN

        testWallet = new Wallet(500);
        Integer expected = -1;
        Integer expectedBalance = 500;
        // WHEN

        Integer actual = testWallet.deposit(-500);
        Integer actualBalance = testWallet.balance();

        // THEN

        assertEquals(expected, actual);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void withdrawNegative()
    {
        // GIVEN

        testWallet = new Wallet(500);
        Integer expected = 0;
        Integer expectedBalance = 500;

        // WHEN

        Integer actual = testWallet.withdraw(-500);
        Integer actualBalance = testWallet.balance();

        // THEN

        assertEquals(expected, actual);
        assertEquals(expectedBalance, actualBalance);
    }
}