// File name: StackTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 11/2/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #7
// Description: Tests the Stack class

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void testIsEmpty_Empty() {
        Stack<Double> stack = new Stack<Double>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush_Normal() {
        Stack<Double> stack = new Stack<Double>();
        stack.push(1.0);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    public void testPop_Empty() {
        Stack<Double> stack = new Stack<Double>();
        Exception e = assertThrows(RuntimeException.class, () -> stack.pop());
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testPop_Normal() {
        Stack<Double> stack = new Stack<Double>();
        stack.push(1.0);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testTop_Empty() {
        Stack<Double> stack = new Stack<Double>();
        Exception e = assertThrows(RuntimeException.class, () -> stack.top());
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    public void testTop_Normal() {
        Stack<Double> stack = new Stack<Double>();
        stack.push(1.0);
        assertEquals(1.0, stack.top());
    }

    @Test
    public void testSize_Empty() {
        Stack<Double> stack = new Stack<Double>();
        assertEquals(0, stack.size());
    }

    @Test
    public void testClone_Empty() {
        Stack<Double> stack = new Stack<Double>();
        Stack<Double> stackClone = stack.clone();
        assertEquals(stack, stackClone);
    }

    @Test
    public void testClone_Normal() {
        Stack<Double> stack = new Stack<Double>();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        stack.push(5.0);


        Stack<Double> stackClone = stack.clone();

        assertEquals(stack, stackClone);

        stackClone.pop();
        assertNotEquals(stack, stackClone);
    }

    @Test
    public void testEquals_Normal() {
        Stack<Double> stack1 = new Stack<Double>();
        stack1.push(1.0);

        Stack<Double> stack2 = new Stack<Double>();
        stack2.push(1.0);

        Stack<Double> stack3 = new Stack<Double>();
        stack3.push(2.0);

        assertTrue(stack1.equals(stack2));
        assertFalse(stack1.equals(stack3));
    }

    @Test
    public void testEquals_DifferentSize() {
        Stack<Double> stack1 = new Stack<Double>();
        stack1.push(1.0);

        Stack<Double> stack2 = new Stack<Double>();

        assertFalse(stack1.equals(stack2));
    }

    @Test
    public void testEquals_NotStack() {
        Stack<Double> stack = new Stack<Double>();

        assertFalse(stack.equals(1.0));
    }

    @Test
    public void testEquals_Same() {
        Stack<Double> stack = new Stack<Double>();

        assertTrue(stack.equals(stack));
    }
}
