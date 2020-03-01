package io.zipcoder.casino.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            try {
                String userInput = scanner.nextLine();
                return userInput;
            } catch (java.util.InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    public static Integer getInteger(String prompt) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            try {
                String userInput = scanner.nextLine();
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please select one of the options above.");
                scanner.nextLine();

            }
        }

    }
}