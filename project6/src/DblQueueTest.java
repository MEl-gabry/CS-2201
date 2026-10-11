// File name: DblQueueTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #6
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Tests the DblQueue class
// Last Changed: 10/22/2025

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DblQueueTest {
    @Test
    public void testIsEmpty_Empty() {
        DblQueue queue = new DblQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue_Empty() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testEnqueue_Normal() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testDequeue_Empty() {
        DblQueue queue = new DblQueue();
        Exception e = assertThrows(RuntimeException.class, () -> queue.dequeue());
        assertEquals("DblQueue is empty", e.getMessage());
    }

    @Test
    public void testDequeue_One() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeue_Normal() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.dequeue();
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(2.0, queue.front());
    }

    @Test
    public void testFront_Empty() {
        DblQueue queue = new DblQueue();
        Exception e = assertThrows(RuntimeException.class, () -> queue.front());
        assertEquals("DblQueue is empty", e.getMessage());
    }

    @Test
    public void testFront_Normal() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testSize_Empty() {
        DblQueue queue = new DblQueue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testClone_Empty() {
        DblQueue queue = new DblQueue();
        DblQueue queueClone = queue.clone();
        assertEquals(queue, queueClone);
    }

    @Test
    public void testClone_Normal() {
        DblQueue queue = new DblQueue();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.enqueue(3.0);
        queue.enqueue(4.0);
        queue.enqueue(5.0);


        DblQueue queueClone = queue.clone();

        assertEquals(queue, queueClone);

        queueClone.dequeue();
        assertNotEquals(queue, queueClone);
    }

    @Test
    public void testEquals_Normal() {
        DblQueue queue1 = new DblQueue();
        queue1.enqueue(1.0);

        DblQueue queue2 = new DblQueue();
        queue2.enqueue(1.0);

        DblQueue queue3 = new DblQueue();
        queue3.enqueue(2.0);

        assertTrue(queue1.equals(queue2));
        assertFalse(queue1.equals(queue3));
    }

    @Test
    public void testEquals_DifferentSize() {
        DblQueue queue1 = new DblQueue();
        queue1.enqueue(1.0);

        DblQueue queue2 = new DblQueue();

        assertFalse(queue1.equals(queue2));
    }

    @Test
    public void testEquals_NotQueue() {
        DblQueue queue = new DblQueue();

        assertFalse(queue.equals(1.0));
    }

    @Test
    public void testEquals_Same() {
        DblQueue queue = new DblQueue();

        assertTrue(queue.equals(queue));
    }
}
