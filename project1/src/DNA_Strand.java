// File name: DNA_Strand.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 9/5/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework. I further acknowledge that the instructors are the
//                  copyright owners of this HW.
// Assignment Number: #1
// Description: Implementation of a DNA_Strand class, where a strand is a sequence
//                of characters


/**
 * DNA_Strand
 * This is a simplified class that will represent a DNA strand that consists of a
 * sequence of characters. The class allows the user to use any characters in the
 * strand, not just the character 'A', 'C', 'G' and 'T' -- this allows the insertion
 * of special markers if they are desired. Currently, the class is limited to 
 * representing strands up to 50 characters in length.
 */
public class DNA_Strand {

    /**
     * MAX_DNA -- the default size of myDNA
     */
    public static final int MAX_DNA = 50;  

    /**
     * mySize -- Current size of the DNA_Strand; i.e., how many elements of the array are
     *     currently being used (since this is a partially-filled array)
     */
    private int mySize;

    /**
     * myDNA -- array of characters that represent the strand (partially-filled)
     */
    private char[] myDNA;

    /**
     * Default Constructor -- Create an empty strand (one with no characters). Allocates 
     *      an array of MAX_DNA elements to hold characters when they get added.
     */
    public DNA_Strand() {
        this("");
    }

    /**
     * Alt Constructor -- Create a strand that is initialized with the characters
     *      from the parameter string. Allocates an array of MAX_DNA elements to 
     *      hold characters. If the parameter string is larger than MAX_DNA, then 
     *      only the first MAX_DNA characters are used to initialize the strand.
     */
    public DNA_Strand(String ipStr) {
        myDNA = new char[MAX_DNA];
        mySize = Math.min(ipStr.length(),MAX_DNA);

        for (int i = 0; i < mySize; i++)  {
            myDNA[i] = ipStr.charAt(i);
        }
    }

    /**
     * inRange -- private helper function
      * @param index -- the index to be verified
     * @return true if index is within range, i.e., 0 <= index < mySize else returns false.
     */
    private boolean inRange(int index) {
        return index >= 0 && index < mySize;
    }

    /**
     * toString()
     * Purpose: Return a string equivalent of the DNA strand
     * @return  String containing all the characters in the strand.
     *          Returns an empty string if the strand is empty.
     */
    public String toString() {
        StringBuilder strDNA = new StringBuilder();

        for (int i = 0; i < mySize; i++) {
            strDNA.append(myDNA[i]);
        }

        return strDNA.toString();
    }

    /**
     * set -- change a character in the strand at a given location to a new character.
     * @param index -- index where the new character is to be placed.
     * @param new_item -- the character to place at that index.
     * Throws IndexOutOfBoundsException if index is out of range.
     * Uses zero-based indexing.
     */
    public void set(int index, char new_item) {
        if (!inRange(index)) {
            throw new IndexOutOfBoundsException("bad index");
        }

        myDNA[index] = new_item;
    }

    /**
     * get -- return a character in the strand at a given location.
     * @param index -- index of the character to be returned.
     * Throws IndexOutOfBoundsException if index is out of range.
     * Uses zero-based indexing.
     */
    public char get(int index) {
        if (!inRange(index)) {
            throw new IndexOutOfBoundsException("bad index");
        }

        return myDNA[index];
    }


    // Returns the current size of the DNA.

    /**
     * size -- returns the size of the strand.
      * @return the number of characters in the strand.
     */
    public int size() {
        return mySize;
    }

    /**
     * equals(Object other)
     * <p>
     * Purpose:  compare two objects for equality
     * @param other -- an object
     * @return true if the two DNA_Strand objects are equal, otherwise false
     * <p>
     * Behavior: Returns true if the  size()'s of the two DNA_Strands are equal and 
     *  all the elements from 0..size()-1 are equal, else false.
     */
    public boolean equals(Object other) {
        // Check if object is a DNA_Strand and if it has size mySize then compare characters
        if (!(other instanceof DNA_Strand otherDNA)) {
            return false;
        } else if (otherDNA.size() != mySize) {
            return false;
        }

        for (int i = 0; i < mySize; i++) {
            if (myDNA[i] != otherDNA.get(i)) {
                return false;
            }
        }

        return true;
    }

    // countEnzyme
    // Counts the number of occurrences of a single character target sequence
    // in the DNA strand.

    /**
     * countEnzyme -- Counts the number of occurrences of a single character in the strand
     * @param target -- the character to count
     * @return number of occurrences of the parameter character
     */
    public int countEnzyme(char target) {
        // Search for character and increment count until it is not found
        int count = 0;

        for (int i = 0; i < mySize; i++) {
            if (myDNA[i] == target) {
                count++;
            }
        }

        return count;
    }

    // search
    // Look for target in current DNA strand and return index.
    // Return -1 if not found.

    /**
     * search(String) -- Look for the first occurrence of the parameter string in the
     *     strand and return its index. Return -1 if not found.
     * @param target -- the string to find.
     * @return the index of the first occurrence of target or -1 if it is not found.
     */
    public int search(String target) {
        return search(0, target);
    }

    /**
     * search(int, String) -- Look for the first occurrence of the parameter string in the
     *     strand starting from a given position and return its index. Return -1 if not found.
     * @param pos -- the starting index for the search.
     * @param target -- the string to find.
     * @return the index of the first occurrence of target or -1 if it is not found.
     */
    public int search(int pos, String target) {
        if (mySize == 0 || target.isEmpty() || !inRange(pos)) {
            return -1;
        }

        // Search for target starting at every index from pos until myDNA is exhausted or target
        // is found
        boolean found;
        for (int startIndex = pos; startIndex <= mySize - target.length(); startIndex++) {
            found = true;
            for (int index = startIndex; index - startIndex < target.length() && found; index++) {
                if (myDNA[index] != target.charAt(index - startIndex)) {
                    found = false;
                }
            }

            if (found) {
                return startIndex;
            }
        }

        return -1;
    }

    /**
     * cleave(String) -- Removes from the current strand the sequence between the 
     *   end of the first occurrence of passed target sequence (e.g. "TTG"), through 
     *   the end of the second occurrence of the target sequence. If two occurrences
     *   are not present, then no cleaving is performed and the strand is unchanged.
     *   pre-condition: Strand is ACTTGACCTTGA and target is "TTG"
     *   post-condition: Strand is ACTTGA  (ACCTTG has been removed)
     * @param target -- the string marking the ends of the cleave
     */
    public void cleave(String target) {
        cleave(0, target);
    }

    /**
     * cleave(int, String) -- Similar to cleave(String) above expect a starting 
     *   position is specified. The cleave only occurs after the starting position.
     *   pre-condition: Strand is ACTTGACCTTGA, pos is 1, and target is "TTG"
     *   post-condition: Strand is ACTTGA  (ACCTTG has been removed) and 5 is returned.
     * @param pos -- the starting index
     * @param target -- the string marking the ends of the cleave
     * @return the index after the cleaved portion or -1 if no cleaving was performed
     */
    public int cleave(int pos, String target) {
        int start = search(pos, target) + target.length();

        if ((start - target.length() == -1)) {
            return -1;
        }

        int end = search(start, target) + target.length();

        if ((end - target.length()) == -1) {
            return -1;
        }

        // Copy every character from after the end of the cleaved segment to the cleaved segment
        // starting at the beginning of it. Set mySize to size after cleaving (newSize).
        int newSize = mySize - (end - start);

        for (int i = 0; i + end < mySize; i++) {
            myDNA[start + i] = myDNA[end + i];
        }

        mySize = newSize;

        return start;
    }
    
    /**
     * cleaveAll -- Removes from current strand the sequence between pairs of target
     *    sequences, i.e. from the end the first occurrence through the end of the second
     *    occurrence, and from the end of the third occurrence through the end of the
     *    fourth occurrence, etc.  (Make sure that you understand the specification)
     *    pre-condition: Strand is ACTTGATTGGGTTGCTTGCC and target is "TTG"
     *    post-condition: Strand is ACTTGGGTTGCC (ATTG and CTTG removed)
     * @param target -- the string marking the ends of the cleaves
     */
    public void cleaveAll(String target) {
        int pos = 0;

        while (pos != -1) {
            pos = cleave(pos, target);
        }
    }

}
