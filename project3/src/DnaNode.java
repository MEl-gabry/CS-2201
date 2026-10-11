// File name: DnaNode.java
// Author: Roth -- CS2201 @Vanderbilt

/**
 * DnaNode -- represents a single node in a linked list. Each node contains a
 * character value, and a reference to the next node.
 * The data fields are public for easy access. No accessors/mutators are
 * provided since the user has direct access to the data.
 * Several constructors are provided for convenience.
 *
 * Note: you are NOT allowed to change this class
 */

public class DnaNode {
    public char val;        // Each node contains a character
    public DnaNode next;    // And a reference to the next node

    // constructor that takes in a character
    public DnaNode(char val) {
        this(val, null);
    }
    
    // constructor that takes in a character and a next reference
    public DnaNode(char val, DnaNode next) {
        this.val = val;
        this.next = next;
    }
}