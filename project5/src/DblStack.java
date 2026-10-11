// File name: DblStack.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #5
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Description: A stack of double values
// Last Changed: 10/19/2025

public class DblStack {
    public static class DblNode {
        public double data;
        public DblNode next;

        public DblNode(double data) {
            this(data, null);
        }

        public DblNode(double data, DblNode next) {
            this.data = data;
            this.next = next;
        }
    }

    private DblNode top;
    private int size;

    /**
     * Default Constructor -- Create an empty stack.
     */
    public DblStack() {
        top = null;
        size = 0;
    }

    /**
     *  isEmpty
     *  Checks if the stack is empty
     *  pre:  A stack exists.
     *  post: Returns true if it IS empty, false if NOT empty.
     */
    public boolean isEmpty() {
        return (size() == 0);
    }


    /**
     *  push
     *  Pushes an item on top of the stack.
     *  pre:  Stack exists and item is passed.
     *  post: the item is placed on top of the stack, and size is incremented.
     */
    public void push(double item) {
        DblNode newNode = new DblNode(item, top);
        top = newNode;
        size++;
    }


    /**
     * pop
     * Pops the top item off the stack.
     * pre:  Stack exists.
     * post: Removes item on top of stack.  If the stack
     *       was already empty, throws a RuntimeException exception.
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("DblStack is empty");
        }

        top = top.next;
        size--;
    }


    /**
     *  top
     *  Returns the top item of the stack without popping it.
     *  pre:  Stack exists.
     *  post: Returns item on top of stack.  If the stack
     *        was already empty, throws a RuntimeException exception.
     */
    public double top() {
        if (isEmpty()) {
            throw new RuntimeException("DblStack is empty");
        }

        return top.data;
    }


    /**
     *  size
     *  Returns the number of items on the stack.
     *  post: Returns size from the private section of class.
     */
    public int size() {
        return size;
    }


    /**
     * clone
     * Return a new DblStack object that is a clone of the 'this' object.
     * The clone should have its own list (of the same size) and contain all the values
     * of 'this' object.
     */
    public DblStack clone() {
        DblStack cloneDbl = new DblStack();

        if (!isEmpty()) {
            cloneDbl.push(top.data);

            DblNode cloneCur = cloneDbl.top;
            DblNode cur = top.next;
            while (cur != null) {
                DblNode newNode = new DblNode(cur.data);
                cloneCur.next = newNode;

                cur = cur.next;
                cloneCur = cloneCur.next;
            }
        }

        cloneDbl.size = size();

        return cloneDbl;
    }


    /**
     * equals
     * Determine if two DblStack objects are equal
     * @param other -- The object to compare
     * @return true if the two DblStacks are equivalent (same size and same data)
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DblStack stack)) {
            return false;
        }

        if (this == stack) {
            return true;
        } else if (size() != stack.size()) {
            return false;
        }

        DblNode thisCurrent = top;
        DblNode strandCurrent = stack.top;

        while (thisCurrent != null) {
            if (thisCurrent.data != strandCurrent.data) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            strandCurrent = strandCurrent.next;
        }

        return true;
    }
}
