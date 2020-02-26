package io.zipcoder.casino;

import java.util.Random;

public class Dice
{
    private Random randomizer;

    public Dice()
    {
        randomizer = new Random();
    }

    protected Dice(Long seed)
    {
        randomizer = new Random(seed);
    }

    public Integer roll()
    {
        return(randomizer.nextInt(6) + 1);
    }
}