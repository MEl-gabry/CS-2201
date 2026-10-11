// File name: TrieNode.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #9
// Honor Statement:  I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Implementation of a TrieNode
// Last Changed: 11/19/2025

public class TrieNode {
    private static final int CHILDREN_LENGTH = 26;
    private final char letter;
    private boolean isEnd;
    private final TrieNode[] children;


    /**
     * Constructor -- sets letter, flag, and initializes children to null
     * @param letter The character the node will contain
     * @param flag A boolean value that represents whether this node ends a word
     */
    public TrieNode(char letter, boolean flag) {
        this.letter = letter;
        isEnd = flag;
        children = new TrieNode[CHILDREN_LENGTH];
    }

    /**
     *  insert
     *  Insert str starting with the given TrieNode. Creates new TrieNodes
     *  as needed and sets the boolean flag on the last node to true.
     *  @param str A lowercase alphabetic string or is empty
     */
    public void insert(String str) {
        if (str.isEmpty()) {
            return;
        }

        boolean flag = str.length() == 1;

        int index = str.charAt(0) - 'a';

        if (children[index] == null) {
            TrieNode newNode = new TrieNode(str.charAt(0), flag);
            children[index] = newNode;
        } else if (flag) {
            children[index].isEnd = true;
        }

        children[index].insert(str.substring(1));
    }

    /**
     *  isWord
     *  Returns false if str is empty otherwise checks to see if str is in the
     *  sub-Trie starting at the given TrieNode
     *  @param str A lowercase alphabetic string or is empty
     *  @return False if the String is empty otherwise checks to see if str is in the
     *  sub-Trie starting at the given TrieNode
     */
    public boolean isWord(String str) {
        if (str.isEmpty()) {
            return false;
        }

        String newStr;

        if (letter == ' ') {
            newStr = str;
        } else if (str.length() == 1) {
            return isEnd;
        } else {
            newStr = str.substring(1);
        }

        int index = newStr.charAt(0) - 'a';

        if (children[index] == null) {
            return false;
        }

        return children[index].isWord(newStr);
    }

    /**
     *  isPrefix
     *  Returns true if str is a prefix of a word in the sub-Trie starting at
     *  the given TrieNode, else returns false
     *  @param str A lowercase alphabetic string or is empty
     *  @return True if str is a prefix of a word in the sub-Trie starting at
     *  the given TrieNode, else returns false
     */
    public boolean isPrefix(String str) {
        if (str.isEmpty()) {
            return true;
        }

        String newStr;

        if (letter == ' ') {
            newStr = str;
        } else if (str.length() == 1) {
            return true;
        } else {
            newStr = str.substring(1);
        }

        int index = newStr.charAt(0) - 'a';

        if (children[index] == null) {
            return false;
        }

        return children[index].isPrefix(newStr);
    }

    /**
     *  toString
     *  Returns a string containing all words starting at the given TrieNode.
     *  Each word is followed immediately by a newline character.
     *  @param pre A string containing the letters of all previous TrieNode objects
     *  @return A string containing all words starting at the given TrieNode.
     *  Each word is followed immediately by a newline character.
     */
    public String toString(String pre) {
        StringBuilder retStr = new StringBuilder();

        if (letter != ' ') {
             pre += letter;
        }

        if (isEnd) {
            retStr = new StringBuilder(pre);
            retStr.append("\n");
        }

        for (TrieNode node : children) {
            if (node != null) {
                retStr.append(node.toString(pre));
            }
        }

        return retStr.toString();
    }

    /**
     *  wordCount
     *  Returns a count all the nodes in the sub-Trie that end a word.
     *  @return A count all the nodes in the sub-Trie that end a word.
     */
    public int wordCount() {
        int count = 0;

        if (isEnd) {
            count++;
        }

        for (TrieNode node : children) {
            if (node != null) {
                count += node.wordCount();
            }
        }

        return count;
    }

    /**
     *  clone
     *  Return a clone/copy of the TrieNode (and the entire sub-Trie).
     *  @return A clone/copy of the TrieNode (and the entire sub-Trie)
     */
    public TrieNode clone() {
        TrieNode cloneNode = new TrieNode(letter, isEnd);

        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                cloneNode.children[i] = children[i].clone();
            }
        }

        return cloneNode;
    }

    /**
     *  equals
     *  Determine equality of two TrieNodes. Two TrieNodes are equals if
     *  they have the same letter and same end-of-word flag, and all their
     *  children TrieNodes are equal.
     *  @param other Any object
     *  @return True if the TrieNodes are equal, else it returns false
     */
    public boolean equals(Object other) {
        if (!(other instanceof TrieNode node)) {
            return false;
        }

        if (letter != node.letter || isEnd != node.isEnd) {
            return false;
        }

        for (int i = 0; i < children.length; i++) {
            if (!java.util.Objects.equals(children[i], node.children[i])) {
                return false;
            }
        }

        return true;
    }
}
