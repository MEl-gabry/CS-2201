// File name: Repair.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #10
// Honor Statement:  I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Finds and prints all possible sentences for a given string
// Last Changed: 12/4/2025

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Repair {
    private static Trie lexicon = new Trie();
    private Deque<String> words;
    private String sentence;

    /**
     * Constructor -- instantiates words and sentence
     * @param sentence The string sentence will be set to
     */
    public Repair(String sentence) {
        words = new ArrayDeque<>();
        this.sentence = sentence;
    }

    /**
     *  loadLexicon
     *  Insert all words from dictionary.txt into the lexicon. Throws a
     *  FileNotFoundException exception if the specified file cannot be
     *  opened
     */
    public static void loadLexicon() throws FileNotFoundException {
        lexicon.loadFromFile("dictionary.txt");
    }

    /**
     *  findWord
     *  Find all possible sentences and print them
     */
    public void findAndPrintWords() {
        wordPrinter("", sentence);
        System.out.println();
    }

    /**
     *  wordPrinter
     *  Helper method to find all possible sentences and print them
     *  @param chars The current list of characters
     *  @param sentence The remaining characters from the sentence
     */
    private void wordPrinter(String chars, String sentence) {
        if (sentence.isEmpty()) {
            if (!chars.isEmpty()) {
                if (!words.isEmpty()) {
                    words.removeLast();
                }
                return;
            }

            for (String word : words) {
                System.out.print(word + " ");
            }

            words.removeLast();

            System.out.println();

            return;
        }

        chars += sentence.charAt(0);

        if (!lexicon.isPrefix(chars)) {
            if (!words.isEmpty()) {
                words.removeLast();
            }
            return;
        } else if (lexicon.isWord(chars)) {
            words.addLast(chars);
            wordPrinter("", sentence.substring(1));
        }

        wordPrinter(chars, sentence.substring(1));
    }

}
