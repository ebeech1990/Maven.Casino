package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Console.*;
import io.zipcoder.casino.utilities.Display;
import io.zipcoder.casino.utilities.Prompt;

public class Casino {




    public  Integer displayMenu(){
    String welcome = "Welcome to our casino!\nPlease select an option:\n" +
            "(1) Play a game\n(2) Create an account\n(3) Quit application";
         Integer userChoice = Prompt.getInteger(welcome);
         if(userChoice == 1) {
            Menu.listGames();
         }
         else if(userChoice == 2) {
            Menu.createAccount();

         }
         else if(userChoice == 3) {
             Menu.quitApp();
         }
         else {
             System.out.println("Invalid input");
         }
         return userChoice;
    }




    public static void main(String[] args) {

        // write your tests before you start fucking with this
     


    }
}