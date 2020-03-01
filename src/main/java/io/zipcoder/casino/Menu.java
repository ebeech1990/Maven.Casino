package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Prompt;

public class Menu implements GameCreator{
    private String message;
    private AccountData user;
    boolean running =true;


    public void displayMenu()  {
        while (running) {
            ConsoleDisplays.mainAscii();
            message = ConsoleDisplays.mainMenu();
            Integer userChoice = Prompt.getInteger(message);
            callOption(userChoice);
        }
    }

    public  void callOption(Integer userChoice) {

        if (userChoice == 1) {
            message = ConsoleDisplays.enterID();
            Integer userId = Prompt.getInteger(message);
            try {
                user = Persistence.readData(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Welcome back! User " + user.getId() + " Chips: " + user.getWallet().chipsBalance);
            listGames(user);
        } else if (userChoice == 2) {
            createAccount();

        } else if (userChoice == 3) {

            System.exit(0);
        } else {
            System.out.println("Invalid input");
        }

    }

    public  AccountData createAccount() {
        AccountData newPlayer = new AccountData();
        user = newPlayer;
        System.out.println(user.getId());
        listGames(newPlayer);
        return newPlayer;
    }

    public  void quitApp() {
        Persistence.gatherData(user);
        System.exit(0);


    }

    public void chooseGame(Integer choice){
        System.out.println("User id : " + user.getId());
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
        else if(choice == 8) {
            quitApp();
        }

        else {
            System.out.println("Invalid input");
        }

    }

    public  void listGames(AccountData user) {
        while (running) {
            message = ConsoleDisplays.gamesMenu();
            Integer choice = Prompt.getInteger(message);
            chooseGame(choice);
        }
    }


}

