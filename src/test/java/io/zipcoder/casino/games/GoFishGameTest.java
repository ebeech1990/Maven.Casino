package io.zipcoder.casino.games;

<<<<<<< HEAD
import static org.junit.Assert.*;

public class GoFishGameTest {

}
=======
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Wallet;
import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;
import io.zipcoder.casino.gamePlayers.GoFishNPC;
import org.junit.Test;

public class GoFishGameTest {
    public void playFish()
    {
        GoFishGame testGame = new GoFishGame(new Deck(), new GoFishHumanPlayer("James", new Wallet()), new GoFishNPC());
    }
}
>>>>>>> 59f06d0d2c7c743e28c5507f53e9f506eab9ca63
