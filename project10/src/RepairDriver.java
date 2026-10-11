// File name: Repair.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #10
// Honor Statement:  I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Contains main program to find and print all possible sentences for a given string
// Last Changed: 12/4/2025

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RepairDriver {
    /**
     *  isAlpha
     *  Determines if word is alphabetic or not and returns true if it is and false if it isn't
     *  @param word The word to be tested
     *  @return True if word is alphabetic otherwise false
     */
    public static boolean isAlpha(String word) {
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String userResponse;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Sentence Reconstructor.");
        System.out.println();

        Repair.loadLexicon();

        do {
            String sentence;
            do {
                System.out.print("Enter the letters of the sentence: ");
                sentence = keyboard.next();

                if (!isAlpha(sentence) || !sentence.equals(sentence.toLowerCase())) {
                    if (!isAlpha(sentence)) {
                        System.out.println("You must enter only alphabetic characters.");
                    } else if (!sentence.equals(sentence.toLowerCase())) {
                        System.out.println("The sentence must contain only lowercase letters.");
                    }
                    System.out.println();
                }
            } while (!sentence.equals(sentence.toLowerCase()) || !isAlpha(sentence));

            Repair repairer = new Repair(sentence);

            repairer.findAndPrintWords();

            System.out.print("Do you want to do it again? (Y|N) ");
            userResponse = keyboard.next();

            System.out.println();
        } while (userResponse.toLowerCase().charAt(0) == 'y');
    }
}
