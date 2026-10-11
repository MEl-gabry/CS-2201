// File name: Trie.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #10
// Honor Statement:  I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Implementation of a Trie ADT
// Last Changed: 11/19/2025

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {
    public TrieNode root;

    /**
     * Constructor -- creates root TrieNode
     */
    public Trie() {
        root = new TrieNode(' ', false);
    }

    /**
     *  insert
     *  Insert the parameter word into the Trie
     *  @param word A lowercase alphabetic string
     */
    public void insert(String word) {
        root.insert(word);
    }

    /**
     *  loadFromFile
     *  Insert all words in the specified file into the Trie. Throws a
     *  FileNotFoundException exception if the specified file cannot be
     *  opened
     *  @param filename A valid string
     */
    public void loadFromFile(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner infile = new Scanner(f);

        while (infile.hasNext()) {
            insert(infile.next());
        }

        infile.close();
    }

    /**
     *  isWord
     *  Returns true if word is in the Trie, else returns false
     *  @param word A lowercase alphabetic string
     *  @return  True if word is in the Trie, else returns false
     */
    public boolean isWord(String word) {
        return root.isWord(word);
    }

    /**
     *  isPrefix
     *  Returns true if str is a prefix of a word in the Trie, else returns false
     *  @param str A lowercase alphabetic string or is empty
     *  @return True if str is a prefix of a word in the Trie, else returns false
     */
    public boolean isPrefix(String str) {
        return root.isPrefix(str);
    }

    /**
     *  toString
     *  Return a string of all words in the Trie, in dictionary/alphabetical order.
     *  @return A string of all words in the Trie, in dictionary/alphabetical order
     */
    public String toString() {
        return root.toString("");
    }

    /**
     *  wordCount
     *  Returns a count all the words in the Trie
     *  @return A count all the words in the Trie
     */
    public int wordCount() {
        return root.wordCount();
    }

    /**
     *  clone
     *  Return a clone/copy of the Trie.
     *  @return A clone/copy of the Trie.
     */
    public Trie clone() {
        Trie cloneTrie = new Trie();

        cloneTrie.root = root.clone();

        return cloneTrie;
    }

    /**
     *  equals
     *  Determine equality of two Tries. Two Tries are equals if they contain
     *  the exact same collection of words.
     *  @param other Any object
     *  @return True if the Tries are equal, else it returns false
     */
    public boolean equals(Object other) {
        if (!(other instanceof Trie trie)) {
            return false;
        }

        return root.equals(trie.root);
    }
}
