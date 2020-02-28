package io.zipcoder.casino.games;

<<<<<<< HEAD
//import io.zipcoder.casino.CardTable;
//import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;

//public class GoFishGame extends CardTable {

//    GoFishHumanPlayer goFishPlayer = new GoFishHumanPlayer();
//    Deck goFishDeck = new Deck();

//}
=======
import io.zipcoder.casino.*;
import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;
import io.zipcoder.casino.gamePlayers.GoFishNPC;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Prompt;

import java.util.logging.Level;
import java.util.logging.Logger;

import static io.zipcoder.casino.Card.Rank.DEUCE;
import static io.zipcoder.casino.Card.Rank.THREE;

public class GoFishGame extends CardTable
{
    private static final Logger LOGGER = Logger.getLogger(GoFishGame.class.getName());
    Player activePlayer;
    GoFishHumanPlayer human;
    GoFishNPC NPC;
    Console console;
    Prompt prompt;

    public GoFishGame(Deck goFishDeck, GoFishHumanPlayer goFishPlayer, GoFishNPC goFishNPC)
    {
        super(goFishDeck);
        human = goFishPlayer;
        NPC = goFishNPC;
        activePlayer = NPC;
        console = new Console(System.in, System.out);
        prompt = new Prompt();
    }

    @Override
    public Boolean endGame() {
        if(human.getScore() >= 7)
        {
            String userInput = console.getStringInput("You won!  Would you like to play again? (Y/n)");
            if(userInput.equalsIgnoreCase("Y"))
            {
                gameSetup();
                return true;
            }
            else
            {
                leaveGame();
                return true;
            }
        }
        else if(NPC.getScore() >= 7)
        {
            String userInput = console.getStringInput("You got outfished!  Would you like to play again? (Y/n)");
            if(userInput.equalsIgnoreCase("Y"))
            {
                gameSetup();
                return true;
            }
            else
            {
                leaveGame();
                return true;
            }
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
        console.println("Thank you for playing!");
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
            output.append(String.format("%s\n", "[ ? ? ? ]"));
        }
        console.println(output.toString());
        return output.toString();
    }

    public void takeTurn(CardPlayer playerInControl)
    {
        displayTable();
        // TODO: Really need to make NPC and Human just a GoFishPlayer, who implements AI behaviors
        if(playerInControl instanceof GoFishHumanPlayer)
        {
            if(endGame())
            {
                //stuff
            }
            else
            {
                Card.Rank chosenRank;
                String userChoice = Prompt.getStringInput("What'cha looking for?");
                if(userChoice.equalsIgnoreCase("two") || userChoice.equalsIgnoreCase("2"))
                {
                    chosenRank = DEUCE;
                } else if(userChoice.equalsIgnoreCase("three") || userChoice.equalsIgnoreCase("3"))
                {
                    chosenRank = THREE;
                } else if(userChoice.equalsIgnoreCase("four") || userChoice.equalsIgnoreCase("4"))
                {

                } else if(userChoice.equalsIgnoreCase("five") || userChoice.equalsIgnoreCase("5"))
                {

                } else if(userChoice.equalsIgnoreCase("six") || userChoice.equalsIgnoreCase("6"))
                {

                } else if(userChoice.equalsIgnoreCase("seven") || userChoice.equalsIgnoreCase("7"))
                {

                } else if(userChoice.equalsIgnoreCase("eight") || userChoice.equalsIgnoreCase("8"))
                {

                }
            }
        }
        else
        {
            if(endGame())
            {
            }

            Prompt.getStringInput("Got any twos?");
            if(((GoFishNPC)activePlayer).fishing(human, DEUCE))
            {
                Prompt.getStringInput("Here they are.");
                takeTurn((CardPlayer)activePlayer);
            }
            else
            {
                Prompt.getStringInput("Go Fish!");
                ((GoFishNPC) activePlayer).receiveCard(deck.deal());
                takeTurn((GoFishHumanPlayer)human);
            }
        }
    }
}
>>>>>>> 741f82efad06a764c1bb1d8327e01059e2c3a4c9
