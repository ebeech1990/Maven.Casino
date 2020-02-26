package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Console.*;
import io.zipcoder.casino.utilities.Display;
import io.zipcoder.casino.utilities.Prompt;

public class Casino {
private AccountData user;



    public  Integer displayMenu(){
    String welcome = "Welcome to our casino!\nPlease select an option:\n" +
            "(1) Load Account\n(2) Create an account\n(3) Quit application";
         Integer userChoice = Prompt.getInteger(welcome);
         if(userChoice == 1) {
            //Menu.listGames();
            user = (AccountData) Persistence.readData();
             System.out.println("Welcome back!" + user.getId()+ " " + user.getWallet());
         }
         else if(userChoice == 2) {
            Casino.createAccount();

         }
         else if(userChoice == 3) {
             Menu.quitApp();
         }
         else {
             System.out.println("Invalid input");
         }
         return userChoice;
    }

    public static AccountData createAccount() {
        AccountData newPlayer = new AccountData();
        System.out.println(newPlayer.getId());
        Persistence.gatherData(newPlayer);
        return newPlayer;
    }


    public static void main(String[] args) {

        // write your tests before you start fucking with this
     
        Casino c = new Casino();
        c.displayMenu();


    }
}