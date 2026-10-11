// File name: Queue.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #7
// Description: Implementation of a queue
// Last Changed: 11/2/2025
//

public class Queue<T> {
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

    private Node front;
    private Node end;
    private int size;

    /**
     * Default Constructor -- Create an empty queue.
     */
    public Queue() {
        front = null;
        end = null;
        size = 0;
    }


    /**
     *  isEmpty
     *  Tests whether the queue is empty.
     *  pre:  A queue exists.
     *  post: Returns true if it IS empty, false if NOT empty.
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     *  enqueue
     *  Add an item to the end of the queue.
     *  pre:  Queue exists and item is passed.
     *  post: The item is placed at the end of the queue, and size is incremented.
     */
    public void enqueue(T item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            front = newNode;
        } else {
            end.next = newNode;
        }
        end = newNode;
        size++;
    }


    /**
     * dequeue
     * Remove the item at the front of the queue. If a dequeue() is attempted on an
     * empty queue then throw a RuntimeException exception.
     * pre:  Queue exists.
     * post: Removes item from front of queue.  If the queue
     *       was already empty, throws a RuntimeException exception.
     */
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        front = front.next;

        if (front == null) {
            end = null;
        }

        size--;
    }


    /**
     *  front
     *  Return the item at the front of the queue without removing it. If a front( ) is
     * attempted on an empty queue then throw a RuntimeException exception.
     *  pre:  Queue exists.
     *  post: Returns item at front of queue.  If the queue
     *        was already empty, throws a RuntimeException exception.
     */
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return front.data;
    }


    /**
     *  size
     *  Return the number of items on the queue.
     *  post: Returns size from the private section of class.
     */
    public int size() {
        return size;
    }


    /**
     * clone
     * Return a clone of the current Queue object.
     * The clone should have its own list (of the same size) and contain all the values
     * of 'this' object.
     */
    public Queue<T> clone() {
        Queue cloneDbl = new Queue();

        Node cur = front;
        while (cur != null) {
            cloneDbl.enqueue(cur.data);

            cur = cur.next;
        }

        cloneDbl.size = size();

        return cloneDbl;
    }


    /**
     * equals
     * Determine the equality of two Queue objects
     * @param other -- The object to compare
     * @return true if the two Queues are equivalent (same size and same data)
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Queue queue)) {
            return false;
        }

        if (this == queue) {
            return true;
        } else if (size() != queue.size()) {
            return false;
        }

        Node thisCurrent = front;
        Node queueCurrent = queue.front;

        while (thisCurrent != null) {
            if (!thisCurrent.data.equals(queueCurrent.data)) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            queueCurrent = queueCurrent.next;
        }

        return true;
    }
}
