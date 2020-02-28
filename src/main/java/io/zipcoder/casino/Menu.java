package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Prompt;

public class Menu implements GameCreator{

    private AccountData user;
    boolean running =true;


    public void displayMenu() {
        while (running) {
            String welcome = "Welcome to our casino!\nPlease select an option:\n" +
                    "(1) Load Account\n(2) Create an account\n(3) Quit application";
            Integer userChoice = Prompt.getInteger(welcome);
            callOption(userChoice);
        }
    }

    public  void callOption(Integer userChoice) {

        if (userChoice == 1) {
            Integer userId = Prompt.getInteger("Please enter your ID");
            user = Persistence.readData(userId);
            System.out.println("Welcome back!" + user.getId() + " " + user.getWallet().chipsBalance);
            listGames(user);
        } else if (userChoice == 2) {
            createAccount();

        } else if (userChoice == 3) {

            quitApp();
        } else {
            System.out.println("Invalid input");
        }

    }

    public  AccountData createAccount() {
        AccountData newPlayer = new AccountData();
        newPlayer.setId();
        // newPlayer = user;
        user = newPlayer;

        listGames(newPlayer);

        return newPlayer;
        //Persistence.gatherData(newPlayer);

    }

    public  void quitApp() {
        Persistence.gatherData(user);
        System.exit(0);


    }

    public void chooseGame(Integer choice){

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

    public  Integer listGames(AccountData user) {

        Integer choice = Prompt.getInteger("(4) Blackjack\n(5) Go Fish\n(6) Craps\n" +
                "(7) Klondike\n(8) Quit Application");


        chooseGame(choice);
        return choice;
    }




}

