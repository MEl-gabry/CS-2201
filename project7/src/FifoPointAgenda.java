// File name: FifoPointAgenda.java
// Author: Marwan El-Gabry
// userid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #7
// Description:  Maintains an agenda of Points in FIFO order.
//     Implements PointAgenda interface: add, remove, peek, isEmpty, size.
// Last Changed: 11/2/2025

public class FifoPointAgenda implements PointAgenda {
    private Queue<Point> agenda;

    /**
     * Constructor -- initializes agenda queue
     */
    public FifoPointAgenda() {
        agenda = new Queue<Point>();
    }

    /**
     *  isEmpty
     *  Checks if the agenda is empty
     *  pre:  The agenda exists.
     *  post: Returns true if it IS empty, false if NOT empty.
     */
    public boolean isEmpty() {
        return agenda.isEmpty();
    }

    /**
     *  add
     *  adds a Point to the agenda.
     *  pre:  The agenda exists and item is passed.
     *  post: the item is added to the agenda, and size is incremented.
     */
    public void add(Point item) {
        agenda.enqueue(item);
    }

    /**
     *  remove
     *  removes the next Point from the agenda.
     *  pre:  The agenda exists.
     *  post: The next Point is removed from the agenda.  If the agenda
     *        was already empty, throws a RuntimeException exception.
     */
    public void remove() {
        agenda.dequeue();
    }

    /**
     *  peek
     *  returns the next Point from the agenda without removing it from the agenda.
     *  pre:  The agenda exists.
     *  post: Returns the next Point from the agenda.  If the agenda
     *        was already empty, throws a RuntimeException exception.
     */
    public Point peek() {
        return agenda.front();
    }

    /**
     *  size
     *  post: Returns the number of Points in the agenda.
     */
    public int size() {
        return agenda.size();
    }
}

