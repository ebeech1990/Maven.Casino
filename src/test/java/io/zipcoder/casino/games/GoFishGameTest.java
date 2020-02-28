package io.zipcoder.casino.games;
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Wallet;
import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;
import io.zipcoder.casino.gamePlayers.GoFishNPC;

public class GoFishGameTest {
    public void playFish()
    {
        GoFishGame testGame = new GoFishGame(new Deck(), new GoFishHumanPlayer("James", new Wallet()), new GoFishNPC());
    }
}
