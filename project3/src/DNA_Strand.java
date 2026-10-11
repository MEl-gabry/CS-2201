// File name: DNA_Strand.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 9/28/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #3
// Description: Implementation of a DNA_Strand class, where a strand is a sequence
//                of characters


/**
 * DNA_Strand
 * This is a simplified class that will represent a DNA strand that consists of a
 * sequence of characters. The class allows the user to use any characters in the
 * strand, not just the character 'A', 'C', 'G' and 'T' -- this allows the insertion
 * of special markers if they are desired. This class will use a linked-list as the
 * basis for the representation rather than a portially-filled array.
 */
public class DNA_Strand {
    /**
     * mySize -- Current size of the DNA_Strand; i.e., how many elements are currently
     *    being stored in the strand. Also represents the number of nodes in the linked list.
     */
    private int mySize;

    /**
     * myDNA -- the head pointer for our linked list. Contains a reference to the first node.
     */
    private DnaNode myDNA;

    /**
     * Default Constructor -- Create an empty strand (one with no characters). This is
     *     represented by an empty linked list.
     */
    public DNA_Strand() {
        myDNA = null;
        mySize = 0;
    }

    /**
     * Alt Constructor -- Create a strand that is initialized with the characters
     *      from the parameter string. Creates a linked list with one node per
     *      character of the paremeter string.
     */
    public DNA_Strand(String ipStr) {
        myDNA = null;
        mySize = ipStr.length();
        for (int i = ipStr.length() - 1; i >= 0; i--) {
            DnaNode tmp = new DnaNode(ipStr.charAt(i));
            tmp.next = myDNA;
            myDNA = tmp;
        }
    }

    /**
     * inRange -- private helper function
     * @param index -- the index to be verified
     * @return true if index is within range, i.e., 0 <= index < mySize else returns false.
     */
    private boolean inRange(int index) {
        return (index >= 0 && index < size());
    }

    /**
     * toString()
     * Purpose: Return a string equivalent of the DNA strand
     * @return  String containing all the characters in the strand.
     *          Returns an empty string if the strand is empty.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        DnaNode cur = myDNA;

        while (cur != null) {
            str.append(cur.val);
            cur = cur.next;
        }

        return str.toString();
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

        DnaNode cur = myDNA;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.val = new_item;
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

        DnaNode cur = myDNA;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }
    
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
       if (!(other instanceof DNA_Strand strand)) {
           return false;
       }

        if (this == strand) {
           return true;
        } else if (size() != strand.size()) {
           return false;
        }

       DnaNode thisCurrent = myDNA;
       DnaNode strandCurrent = strand.myDNA;

       while (thisCurrent != null) {
           if (thisCurrent.val != strandCurrent.val) {
               return false;
           }
           thisCurrent = thisCurrent.next;
           strandCurrent = strandCurrent.next;
       }

       return true;
    }

    /**
     * countEnzyme -- Counts the number of occurrences of a single character in the strand
     * @param target -- the character to count
     * @return number of occurrences of the parameter character
     */
    public int countEnzyme(char target) {
        DnaNode cur = myDNA;
        int count = 0;

        while (cur != null) {
            if (cur.val == target) {
                count++;
            }
            cur = cur.next;
        }

        return count;
    }

    /**
     * countEnzyme -- overloaded, string parameter version. Counts non-overlapping 
     *  instances of the target.
     *  Eg, the target "AAA" appears 3 non-overlapping times in the DNA "AAAAAAAAAAA".
     * @param target -- the string to count
     * @return number of non-overlapping occurrences of the parameter string
     */
    public int countEnzyme(String target) {
        int pos = 0;
        int count = 0;

        pos = search(pos, target);

        while (pos != -1) {
            count++;
            pos = search(pos + target.length(), target);
        }

        return count;
    }

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
        if (!inRange(pos) || target.isEmpty()) {
            return -1;
        }

        int index = 0;

        DnaNode beginNode = myDNA;

        while (index < pos) {
            beginNode = beginNode.next;
            index++;
        }

        // Search for target starting at every node from the node at pos until myDNA is exhausted
        // or target is found
        boolean found;
        while (beginNode != null) {
            DnaNode node = beginNode;
            found = true;
            for (int i = 0; found && i < target.length(); i++)  {
                if (node == null) {
                    return -1;
                } else if (node.val != target.charAt(i)) {
                    found = false;
                }
                node = node.next;
            }

            if (found) {
                return index;
            }

            beginNode = beginNode.next;
            index++;
        }

        return -1;
    }

    /**
     * search(DnaNode, String) -- Look for the first occurrence of the parameter string in the
     *     strand starting from a given node and return a reference to the node where the
     *     target starts. Return null if not found.
     * @param startNode -- the node at which to start the search.
     * @param target -- the string to find.
     * @return reference to node of first occurrence of target or null if it is not found.
     */
    public DnaNode search(DnaNode startNode, String target) {
        if (size() == 0 || target.isEmpty()) {
            return null;
        }

        // Search for target starting at every node from startNode until myDNA is exhausted or
        // target is found
        DnaNode beginNode = startNode;

        boolean found;
        while (beginNode != null) {
            DnaNode node = beginNode;
            found = true;
            for (int i = 0; found && i < target.length(); i++)  {
                if (node == null) {
                    return null;
                } else if (node.val != target.charAt(i)) {
                    found = false;
                }
                node = node.next;
            }

            if (found) {
                return beginNode;
            }

            beginNode = beginNode.next;
        }

        return null;
    }

    /**
     * clone -- make and return a copy of the DNA_Strand
     * @return a copy of the DNA_Strand object
     */
    public DNA_Strand clone() {
        return new DNA_Strand(toString());
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
     * Note that this method is now a void method -- it does not return a value.
     */
    public void cleave(int pos, String target) {
        if (!inRange(pos)) {
            return;
        }

        DnaNode cur = myDNA;

        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }

        cleave(cur, target);
    }

    /**
     * cleave(DnaNode, String) -- Similar to cleave(int, String) above expect the starting 
     *   position is specified via a node reference. The cleave only occurs after the  
     *   starting node.
     *   pre-condition: Strand is ACTTGACCTTGA, startPtr is pointing at the second node, 
     *     and target is "TTG"
     *   post-condition: Strand is ACTTGA  (ACCTTG has been removed) and a reference to 
     *     final 'A' node is returned.
     * @param startPtr -- the starting node where we begin the search
     * @param target -- the string marking the ends of the cleave
     * @return If no cleave is performed, returns null. Otherwise, return reference 
     *   to next node after the cleave, ie, returned ref points to the node after 
     *   the cleaved sequence (could be null if the cleaved sequence was at the end 
     *   of the strand).
     */
    private DnaNode cleave(DnaNode startPtr, String target) {
        DnaNode beginNode = search(startPtr, target);

        if (beginNode == null) {
            return null;
        }

        for (int i = 0; i < target.length() - 1; i++) {
            beginNode = beginNode.next;
        }

        if (beginNode.next == null) {
            return null;
        }

        DnaNode endNode = search(beginNode.next, target);

        if (endNode == null) {
            return null;
        }

        for (int i = 0; i < target.length(); i++) {
            endNode = endNode.next;
        }

        beginNode.next = endNode;

        int size = 0;

        for (DnaNode tmp = myDNA; tmp != null; tmp = tmp.next) {
            size++;
        }

        mySize = size;

        return endNode;
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
        DnaNode startPtr = myDNA;

        while (startPtr != null) {
            startPtr = cleave(startPtr, target);
        }
    }

    /**
     * append (accepting a string parameter) -- Append the characters of the parameter 
     *   to the end of the current DNA, growing the array only if necessary (the new 
     *   array should be the exact size to hold the characters of the strand).
     *   Example: if myDNA contained ACTTGA and "ACCTG" was received as a parameter, 
     *   then afterward myDNA will contain ACTTGAACCTG
     * @param rhs -- the characters to append to the end of the strand
     */
    public void append(String rhs) {
        append(new DNA_Strand(rhs));
    }

    /**
     * append (accepting a DNA_Strand parameter) -- Append the characters of the parameter 
     *   to the end of the current DNA, growing the array only if necessary (the new 
     *   array should be the exact size to hold the characters of the strand).
     *   Example: if myDNA contained ACTTGA and "ACCTG" was received as a parameter, 
     *   then afterward myDNA will contain ACTTGAACCTG
     * @param rhs -- the characters to append to the end of the strand
     */
    public void append(DNA_Strand rhs) {
        DnaNode cur = myDNA;

        if (cur == null) {
            myDNA = rhs.myDNA;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = rhs.myDNA;
        }

        mySize += rhs.size();
    }

    /**
     * splice -- finds first pair of targets in current DNA strand and replaces the 
     *  sequence between the end of the first target through the end of the second with 
     *  the insertSequence, growing the array if necessary. If two instances of the 
     *  target are not found, then no changes are made.
     *  Example: if myDNA contained AGTTGA, then splice("G","CCCCC") would change
     *  the strand to be AGCCCCCA.
     *  See project spec for note on efficiency.
     * @param target -- string to search for
     * @param insertSequence -- string to replace the cleaved sequence
    */
    public void splice(String target, String insertSequence) {
        splice(0, target, insertSequence);
    }

    /**
     * splice -- finds a pair of targets in current DNA strand after the start position 
     *  and replaces the sequence between the end of the first target through the end of 
     *  the second with the insertSequence. If two instances 
     *  of the target are not found, then no changes are made. 
     *  Example: if myDNA contained AGTTGA, then splice(1,"G","CCCCC") would change
     *  the strand to be AGCCCCCA.
     * @param pos -- starting position specified by an index
     * @param target -- string to search for
     * @param insertSequence -- string to replace the cleaved sequence
     * Note that this method is now a void method -- it does not return a value.
     */
    public void splice(int pos, String target, String insertSequence) {
        DnaNode cur = myDNA;

        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }

        splice(cur, target, insertSequence);
    }

    /**
     * splice -- finds a pair of targets in current DNA strand after the start position 
     *  specified via a DnaNode reference and replaces the sequence between the end of 
     *  the first target through the end of the second with the insertSequence. 
     *  If two instances of the target are not found, then no changes are made. 
     *  Example: if myDNA contained AGTTGA, then splice(1,"G","CCCCC") would change
     *  the strand to be AGCCCCCA and return a reference to the final 'A' node.
     * @param startPtr -- starting position specified by a reference to a node
     * @param target -- string to search for
     * @param insertSequence -- string to replace the cleaved sequence
     * @return reference to the next node after the inserted sequence if a splice 
     *    occurred, otherwise return null
     */
    public DnaNode splice(DnaNode startPtr, String target, String insertSequence) {
        DnaNode beginNode = search(startPtr, target);

        if (beginNode == null) {
            return null;
        }

        for (int i = 0; i < target.length() - 1; i++) {
            beginNode = beginNode.next;
        }

        if (beginNode.next == null) {
            return null;
        }

        DnaNode endNode = search(beginNode.next, target);

        if (endNode == null) {
            return null;
        }

        for (int i = 0; i < target.length(); i++) {
            endNode = endNode.next;
        }

        DNA_Strand insertStrand = new DNA_Strand(insertSequence);

        beginNode.next = insertStrand.myDNA;

        DnaNode insertStrandEnd = insertStrand.myDNA;

        while (insertStrandEnd.next != null) {
            insertStrandEnd = insertStrandEnd.next;
        }

        insertStrandEnd.next = endNode;

        int size = 0;

        for (DnaNode tmp = myDNA; tmp != null; tmp = tmp.next) {
            size++;
        }

        mySize = size;

        return endNode;
    }


    // Note: we are not asking you to write a spliceAll() method, though you should be
    // able to see how easy it would be given the definition of splice() above.

}
