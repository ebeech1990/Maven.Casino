package io.zipcoder.casino;

import sun.lwawt.macosx.CSystemTray;

import java.util.Random;

public class ConsoleDisplays {

    public static void openingMenu(){

    }

    public static void printXNTimes(String x, Integer n) {
        for(int i = 1; i <= n; i++){
            System.out.println(x);
        }
    }


    public static void mainAscii() {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        Character[] suite = new Character[]{'\u2660', '\u2666', '\u2764', '\u2663'};
        Random randomSuite = new Random();

        for(int i = 1; i < 51; i++) {
            System.out.print(suite[randomSuite.nextInt(3)]+" ");
        }
        System.out.println(" ");
        try {
            artGen.printTextArt("C a s i n o", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_MONO,"$");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        for(int i = 1; i < 51; i++) {
            System.out.print(suite[randomSuite.nextInt(3)]+" ");
        }
        System.out.println(" ");
        System.out.println(" ");

    }

    public static String mainMenu(){
        return "Welcome to our casino!\nPlease select an option:\n" +
                "(1) Load Account\n(2) Create an account\n(3) Quit application";
    }

    public static String enterID(){
        return "Please enter your ID";
    }

    public static String gamesMenu(){
        return "(4) Blackjack\n(5) Go Fish\n(6) Craps\n" +
                "(7) Klondike\n(8) Quit Application";
    }
    /*
     - - -
    |     |
    |     |
    |     |
     - - -
     */
    public static void printCard(String value, String suite){
        Character symbol = '0';
        if(suite.equals("S")) {
            symbol = '\u2660';
        }
        else if(suite.equals("D")){
            symbol = '\u2666';
        }
        else if(suite.equals("H")){
            symbol = '\u2764';
        }
        else if(suite.equals("C")){
            symbol = '\u2663';
        }
        else{
            System.out.println("invalid input");
        }
        System.out.print(" - - -\n|  " +value+ "  |\n|  "+symbol+"  |\n|  "+value+"  |\n - - -");
    }
//    public String toString()
//    {
//        return rank + " of " + suit + "(" + cardValue() + ")";
//    }
}
