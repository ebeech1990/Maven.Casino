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

public class GoFishGame extends CardTable
{
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
        return null;
    }

    public void takeTurn(CardPlayer playerInControl)
    {
        // TODO: Really need to make NPC a GoFisher who implements AI
    }
}
>>>>>>> 741f82efad06a764c1bb1d8327e01059e2c3a4c9
