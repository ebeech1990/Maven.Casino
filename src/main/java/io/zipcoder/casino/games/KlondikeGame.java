package io.zipcoder.casino.games;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Wallet;
import io.zipcoder.casino.gamePlayers.KlondikeHumanPlayer;
import io.zipcoder.casino.gamePlayers.KlondikeNPC;

import java.util.logging.Logger;

public class KlondikeGame
{
    private Integer humanScore;
    private Integer npcScore;
    Player activePlayer;
    KlondikeHumanPlayer human;
    KlondikeNPC NPC;

    public KlondikeGame(KlondikeHumanPlayer klondikeHuman, KlondikeNPC klondikeNPC)
    {

        human = klondikeHuman;
        NPC = klondikeNPC;
        activePlayer = human;



        //gameSetup();
    }
//    public Integer pairHuman()
//    {
//        humanScore = 0;
//        KlondikeHumanPlayer humanPoints = new KlondikeHumanPlayer("Bill", new Wallet());
//
//        for (int i = 0; i < 4; i++)
//        {
//            for (int j = i + 1; j < 5; j++)
//            {
//                if ()
//            }
//        }
//    }
}
