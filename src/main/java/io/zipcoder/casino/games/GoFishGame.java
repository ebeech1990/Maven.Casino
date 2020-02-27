package io.zipcoder.casino.games;

import io.zipcoder.casino.*;
import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;
import io.zipcoder.casino.gamePlayers.GoFishNPC;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoFishGame extends CardTable
{
    private static final Logger LOGGER = Logger.getLogger(GoFishGame.class.getName());
    Player activePlayer;
    GoFishHumanPlayer human;
    GoFishNPC NPC;

    public GoFishGame(Deck goFishDeck, GoFishHumanPlayer goFishPlayer, GoFishNPC goFishNPC)
    {
        super(goFishDeck);
        human = goFishPlayer;
        NPC = goFishNPC;
        activePlayer = human;

        gameSetup();
    }

    @Override
    public Boolean endGame() {
        if(human.getScore() >= 7)
        {
            String.format("Congrats!  You won!  Would you like to play again?");
            return true;
        }
        else if(NPC.getScore() >= 7)
        {
            String.format("You got outfished!  Would you like to try again?");
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void gameSetup()
    {
        for(Integer i = 0; i < 7; i++)
        {
            human.receiveCard(deck.deal());
            NPC.receiveCard(deck.deal());
        }

        takeTurn((CardPlayer)activePlayer);
    }

    @Override
    public void leaveGame()
    {

    }

    @Override
    public String displayTable()
    {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Your Score: %s\nHAND:\n", human.getScore()));
        for(Card card : human.getHand())
        {
            output.append(String.format("%s\n", card.toString()));
        }
        output.append(String.format("\n\nOpponent's Score: %s\nHAND\n", NPC.getScore()));
        for(Card card : NPC.getHand())
        {
            output.append(String.format("%s\n", card.toString()));
        }
        LOGGER.log(Level.INFO, output.toString());
        return output.toString();
    }

    public void takeTurn(CardPlayer playerInControl)
    {
        displayTable();
        // TODO: Really need to make NPC and Human just a GoFishPlayer, who implements AI behaviors
        if(playerInControl instanceof GoFishHumanPlayer)
        {
            System.out.println("Do you have any: ");
        }
        else
        {
            if(((GoFishNPC)activePlayer).fishing(human, Card.Rank.DEUCE))
            {
                takeTurn((CardPlayer)activePlayer);
            }
        }
    }
}