// File name: Stack.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #7
// Description: Implementation of a stack.
// Last Changed: 11/2/2025
//

public class Stack<T> {
    public class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    /**
     * Default Constructor -- Create an empty stack.
     */
    public Stack() {
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
    public void push(T item) {
        Node newNode = new Node(item, top);
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
            throw new RuntimeException("Stack is empty");
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
    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
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
     * Return a new Stack object that is a clone of the 'this' object.
     * The clone should have its own list (of the same size) and contain all the values
     * of 'this' object.
     */
    public Stack<T> clone() {
        Stack cloneStack = new Stack();

        if (!isEmpty()) {
            cloneStack.push(top.data);

            Node cloneCur = cloneStack.top;
            Node cur = top.next;
            while (cur != null) {
                Node newNode = new Node(cur.data);
                cloneCur.next = newNode;

                cur = cur.next;
                cloneCur = cloneCur.next;
            }
        }

        cloneStack.size = size();

        return cloneStack;
    }


    /**
     * equals
     * Determine if two Stack objects are equal
     * @param other -- The object to compare
     * @return true if the two Stacks are equivalent (same size and same data)
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Stack stack)) {
            return false;
        }

        if (this == stack) {
            return true;
        } else if (size() != stack.size()) {
            return false;
        }

        Node thisCurrent = top;
        Node stackCurrent = stack.top;

        while (thisCurrent != null) {
            if (!thisCurrent.data.equals(stackCurrent.data)) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            stackCurrent = stackCurrent.next;
        }

        return true;
    }


}