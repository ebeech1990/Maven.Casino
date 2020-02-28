package io.zipcoder.casino;


import io.zipcoder.casino.gamePlayers.GoFishHumanPlayer;
import io.zipcoder.casino.gamePlayers.GoFishNPC;
import io.zipcoder.casino.games.GoFishGame;
import io.zipcoder.casino.utilities.Display;
import io.zipcoder.casino.utilities.Prompt;

public class Casino  {

    public static void main(String[] args) throws Exception {

        // write your tests before you start fucking with this

        //
        //AsciiHolder.mainAscii();



            //AsciiHolder.printCard("K", "U+2662");

        Menu menu = new Menu();
        menu.displayMenu();
//        GoFishGame g = new GoFishGame(new Deck(), new GoFishHumanPlayer("James", new Wallet()), new GoFishNPC());
//        g.gameSetup();
    }
}
