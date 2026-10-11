// File name: QueueTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #7
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Tests the Queue class
// Last Changed: 11/2/2025

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void testIsEmpty_Empty() {
        Queue<Double> queue = new Queue<Double>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue_Empty() {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(1.0);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testEnqueue_Normal() {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testDequeue_Empty() {
        Queue<Double> queue = new Queue<Double>();
        Exception e = assertThrows(RuntimeException.class, () -> queue.dequeue());
        assertEquals("Queue is empty", e.getMessage());
    }

    @Test
    public void testDequeue_One() {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(1.0);
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeue_Normal() {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.dequeue();
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(2.0, queue.front());
    }

    @Test
    public void testFront_Empty() {
        Queue<Double> queue = new Queue<Double>();
        Exception e = assertThrows(RuntimeException.class, () -> queue.front());
        assertEquals("Queue is empty", e.getMessage());
    }

    @Test
    public void testFront_Normal() {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(1.0);
        assertEquals(1.0, queue.front());
    }

    @Test
    public void testSize_Empty() {
        Queue<Double> queue = new Queue<Double>();
        assertEquals(0, queue.size());
    }

    @Test
    public void testClone_Empty() {
        Queue<Double> queue = new Queue<Double>();
        Queue<Double> queueClone = queue.clone();
        assertEquals(queue, queueClone);
    }

    @Test
    public void testClone_Normal() {
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.enqueue(3.0);
        queue.enqueue(4.0);
        queue.enqueue(5.0);


        Queue<Double> queueClone = queue.clone();

        assertEquals(queue, queueClone);

        queueClone.dequeue();
        assertNotEquals(queue, queueClone);
    }

    @Test
    public void testEquals_Normal() {
        Queue<Double> queue1 = new Queue<Double>();
        queue1.enqueue(1.0);

        Queue<Double> queue2 = new Queue<Double>();
        queue2.enqueue(1.0);

        Queue<Double> queue3 = new Queue<Double>();
        queue3.enqueue(2.0);

        assertTrue(queue1.equals(queue2));
        assertFalse(queue1.equals(queue3));
    }

    @Test
    public void testEquals_DifferentSize() {
        Queue<Double> queue1 = new Queue<Double>();
        queue1.enqueue(1.0);

        Queue<Double> queue2 = new Queue<Double>();

        assertFalse(queue1.equals(queue2));
    }

    @Test
    public void testEquals_NotQueue() {
        Queue<Double> queue = new Queue<Double>();

        assertFalse(queue.equals(1.0));
    }

    @Test
    public void testEquals_Same() {
        Queue<Double> queue = new Queue<Double>();

        assertTrue(queue.equals(queue));
    }
}
