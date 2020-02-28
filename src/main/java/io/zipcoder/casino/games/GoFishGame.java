package io.zipcoder.casino.games;

import io.zipcoder.casino.*;
import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;
import io.zipcoder.casino.gamePlayers.GoFishNPC;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Prompt;

import java.util.logging.Level;
import java.util.logging.Logger;

import static io.zipcoder.casino.Card.Rank.*;

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
                Card.Rank chosenRank = DEUCE;
                String userChoice = Prompt.getStringInput("What'cha looking for?");
                if(userChoice.equalsIgnoreCase("two") || userChoice.equals("2"))
                {
                    chosenRank = DEUCE;
                } else if(userChoice.equalsIgnoreCase("three") || userChoice.equals("3"))
                {
                    chosenRank = THREE;
                } else if(userChoice.equalsIgnoreCase("four") || userChoice.equals("4"))
                {
                    chosenRank = FOUR;
                } else if(userChoice.equalsIgnoreCase("five") || userChoice.equals("5"))
                {
                    chosenRank = FIVE;
                } else if(userChoice.equalsIgnoreCase("six") || userChoice.equals("6"))
                {
                    chosenRank = SIX;
                } else if(userChoice.equalsIgnoreCase("seven") || userChoice.equals("7"))
                {
                    chosenRank = SEVEN;
                } else if(userChoice.equalsIgnoreCase("eight") || userChoice.equals("8"))
                {
                    chosenRank = EIGHT;
                } else if(userChoice.equalsIgnoreCase("nine") || userChoice.equals("9"))
                {
                    chosenRank = NINE;
                } else if(userChoice.equalsIgnoreCase("ten") || userChoice.equals("10"))
                {
                    chosenRank = TEN;
                } else if(userChoice.equalsIgnoreCase("jack") || userChoice.equals("j"))
                {
                    chosenRank = JACK;
                }
                else if(userChoice.equalsIgnoreCase("queen") || userChoice.equals("q"))
                {
                    chosenRank = QUEEN;
                }
                else if(userChoice.equalsIgnoreCase("king") || userChoice.equals("k"))
                {
                    chosenRank = KING;
                }
                else if(userChoice.equalsIgnoreCase("ace") || userChoice.equals("a"))
                {
                    chosenRank = ACE;
                } else
                {
                    console.println("Please input a singular noun (Such as ten or ace)");
                }

                if(human.fishing(NPC, chosenRank))
                {
                    console.println("Here are your " + chosenRank);
                    if(human.takeSet(chosenRank))
                    {
                        console.println("Human claims " + chosenRank);
                    }
                    takeTurn((CardPlayer)activePlayer);
                }
                else
                {
                    Prompt.getStringInput("Go Fish!");
                    Card drawnCard = deck.deal();
                    human.receiveCard(drawnCard);
                    takeTurn(NPC);
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
                if(human.takeSet(DEUCE))
                {
                    console.println("Human claims " + DEUCE);
                }
                takeTurn((CardPlayer)NPC);
            }
            else
            {
                Prompt.getStringInput("Go Fish!");
                ((GoFishNPC) activePlayer).receiveCard(deck.deal());
                takeTurn(human);
            }
        }
    }
}