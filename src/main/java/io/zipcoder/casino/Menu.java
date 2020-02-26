package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Display;

public class Menu implements GameCreator{




    public void chooseGame(Integer choice) {
        if(choice == 4){
           //blackJack();

        }
        else if(choice == 5) {
            //goFish();
        }
        else if(choice == 6) {
            //craps();
        }
        else if(choice == 7) {
            //klondike();
        }
        else {
            System.out.println("Invalid input");
        }
    }

    public static void listGames() {
        System.out.println("(4) Blackjack\n(5) Go Fish\n(6) Craps\n(7) Klondike");
    }

    public static void quitApp() {

            System.exit(0);


    }

    public static AccountData createAccount() {
        AccountData newPlayer = new AccountData();
        System.out.println(newPlayer.getId());
        return newPlayer;
    }
}
