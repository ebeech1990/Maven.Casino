package io.zipcoder.casino.utilities;

import java.util.Scanner;

public class Prompt {

    public static String getStringInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getInteger(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return Integer.parseInt(userInput);
    }
}