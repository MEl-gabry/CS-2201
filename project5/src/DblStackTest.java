// File name: DblStackTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 10/19/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #5
// Description: Tests the DblStack class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DblStackTest {
    @Test
    public void testIsEmpty_Empty() {
        DblStack stack = new DblStack();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush_Normal() {
        DblStack stack = new DblStack();
        stack.push(1.0);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    public void testPop_Empty() {
        DblStack stack = new DblStack();
        Exception e = assertThrows(RuntimeException.class, () -> stack.pop());
        assertEquals("DblStack is empty", e.getMessage());
    }

    @Test
    public void testPop_Normal() {
        DblStack stack = new DblStack();
        stack.push(1.0);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testTop_Empty() {
        DblStack stack = new DblStack();
        Exception e = assertThrows(RuntimeException.class, () -> stack.top());
        assertEquals("DblStack is empty", e.getMessage());
    }

    @Test
    public void testTop_Normal() {
        DblStack stack = new DblStack();
        stack.push(1.0);
        assertEquals(1.0, stack.top());
    }

    @Test
    public void testSize_Empty() {
        DblStack stack = new DblStack();
        assertEquals(0, stack.size());
    }

    @Test
    public void testClone_Empty() {
        DblStack stack = new DblStack();
        DblStack stackClone = stack.clone();
        assertEquals(stack, stackClone);
    }

    @Test
    public void testClone_Normal() {
        DblStack stack = new DblStack();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        stack.push(5.0);


        DblStack stackClone = stack.clone();

        assertEquals(stack, stackClone);

        stackClone.pop();
        assertNotEquals(stack, stackClone);
    }

    @Test
    public void testEquals_Normal() {
        DblStack stack1 = new DblStack();
        stack1.push(1.0);

        DblStack stack2 = new DblStack();
        stack2.push(1.0);

        DblStack stack3 = new DblStack();
        stack3.push(2.0);

        assertTrue(stack1.equals(stack2));
        assertFalse(stack1.equals(stack3));
    }

    @Test
    public void testEquals_DifferentSize() {
        DblStack stack1 = new DblStack();
        stack1.push(1.0);

        DblStack stack2 = new DblStack();

        assertFalse(stack1.equals(stack2));
    }

    @Test
    public void testEquals_NotStack() {
        DblStack stack = new DblStack();

        assertFalse(stack.equals(1.0));
    }

    @Test
    public void testEquals_Same() {
        DblStack stack = new DblStack();

        assertTrue(stack.equals(stack));
    }
}
