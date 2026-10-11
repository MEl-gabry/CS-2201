// File name: DNATest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 9/5/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework. I further acknowledge that the instructors are the copyright
//                  owners of this HW.
// Assignment Number: #1
// Description: This tests the DNA_Strand class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the DNA_Strand class
 */
public class DNATest {

    @Test
    public void testConstructor_Null() {
        Exception e = assertThrows(NullPointerException.class, () -> new DNA_Strand(null));
        assertEquals("Cannot invoke \"java.lang.String.length()\" because \"ipStr\" " +
                "is null", e.getMessage());
    }

    @Test
    public void testToString_Empty() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("");
        assertEquals("", dna1.toString());
        assertEquals("", dna2.toString());
    }

    @Test
    public void testToString_Normal() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals("ATTGCCGTT", dna.toString());
    }

    @Test
    public void testToString_DifferentChars() {
        DNA_Strand dna = new DNA_Strand("a12we");
        assertEquals("a12we", dna.toString());
    }

    @Test
    public void testSize_Empty() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("");
        assertEquals(0, dna1.size());
        assertEquals(0, dna2.size());
    }

    @Test
    public void testSize_Normal() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals(9, dna.size());
    }

    @Test
    public void testGet_Normal() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals('A', dna.get(0));
    }

    @Test
    public void testGet_OutOfBounds() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("ATTGCCGTT");

        Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> dna1.get(0));
        assertEquals("bad index", e1.getMessage());

        Exception e2 = assertThrows(IndexOutOfBoundsException.class,
                () -> dna2.get(Integer.MAX_VALUE));
        assertEquals("bad index", e2.getMessage());

        Exception e3 = assertThrows(IndexOutOfBoundsException.class,
                () -> dna2.get(Integer.MIN_VALUE));
        assertEquals("bad index", e3.getMessage());
    }

    @Test
    public void testSet_Normal() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        dna.set(0, 'T');
        assertEquals('T', dna.get(0));
    }

    @Test
    public void testSet_OutOfBounds() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("ATTGCCGTT");

        Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> dna1.set(0, 'A'));
        assertEquals("bad index", e1.getMessage());

        Exception e2 = assertThrows(IndexOutOfBoundsException.class,
                () -> dna2.set(Integer.MAX_VALUE, 'A'));
        assertEquals("bad index", e2.getMessage());

        Exception e3 = assertThrows(IndexOutOfBoundsException.class,
                () -> dna2.set(Integer.MIN_VALUE, 'A'));
        assertEquals("bad index", e3.getMessage());
    }

    @Test
    public void testEquals_Normal() {
        DNA_Strand dna1 = new DNA_Strand("ATTGCCGTT");
        DNA_Strand dna2 = new DNA_Strand("ATTGCCGTT");
        DNA_Strand dna3 = new DNA_Strand("ATTGACGTT");

        assertTrue(dna1.equals(dna2));
        assertFalse(dna1.equals(dna3));
    }

    @Test
    public void testEquals_DifferentSize() {
        DNA_Strand dna1 = new DNA_Strand("ATTGCCGTT");
        DNA_Strand dna2 = new DNA_Strand("ATTGCCGT");

        assertFalse(dna1.equals(dna2));
    }

    @Test
    public void testEquals_NotStrand() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");

        assertFalse(dna.equals("ATTGCCGTT"));
    }

    @Test
    public void testSearch_Empty() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("");
        assertEquals(-1, dna1.search(""));
        assertEquals(-1, dna2.search(""));
        assertEquals(-1, dna1.search("a"));
        assertEquals(-1, dna2.search("a"));
    }

    @Test
    public void testSearch_OneChar() {
        DNA_Strand dna = new DNA_Strand("A");
        assertEquals(0, dna.search("A"));
        assertEquals(-1, dna.search(""));
    }

    @Test
    public void testSearch_Longer() {
        DNA_Strand dna = new DNA_Strand("A");
        assertEquals(-1, dna.search("AB"));
    }

    @Test
    public void testSearch_InvalidIndex() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals(-1, dna.search(Integer.MAX_VALUE, "ATT"));
        assertEquals(-1, dna.search(Integer.MIN_VALUE, "ATT"));
    }

    @Test
    public void testSearch_Mid() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals(3, dna.search("GCC"));
    }

    @Test
    public void testSearch_End() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTP");
        assertEquals(6, dna.search("GTP"));
        assertEquals(8, dna.search("P"));
    }

    @Test
    public void testSearch_Beg() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals(0, dna.search("ATT"));
        assertEquals(0, dna.search("A"));
    }

    @Test
    public void testSearch_InPattern() {
        DNA_Strand dna = new DNA_Strand("BBBG");
        assertEquals(1, dna.search("BBG"));
    }

    @Test
    public void testSearch_EndStart() {
        DNA_Strand dna = new DNA_Strand("BGBGC");
        assertEquals(2, dna.search("BGC"));
    }

    @Test
    public void testSearch_Multiple() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");
        assertEquals(1, dna.search("TT"));
        assertEquals(7, dna.search(2, "TT"));
        assertEquals(-1, dna.search(1, "AT"));
    }

    @Test
    public void testCountEnzyme_Repeated() {
        DNA_Strand dna = new DNA_Strand("CCCCC");
        assertEquals(5, dna.countEnzyme('C'));
    }

    @Test
    public void testCountEnzyme_Split() {
        DNA_Strand dna = new DNA_Strand("CCABDGGCC");
        assertEquals(4, dna.countEnzyme('C'));
    }

    @Test
    public void testCountEnzyme_NotIn() {
        DNA_Strand dna = new DNA_Strand("CCACC");
        assertEquals(0, dna.countEnzyme('G'));
    }

    @Test
    public void testCountEnzyme_OneChar() {
        DNA_Strand dna = new DNA_Strand("C");
        assertEquals(1, dna.countEnzyme('C'));
    }

    @Test
    public void testCountEnzyme_Empty() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("");
        assertEquals(0, dna1.countEnzyme('C'));
        assertEquals(0, dna2.countEnzyme('C'));
    }

    @Test
    public void testCleave_Normal() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        assertEquals(5, dna.cleave(0, "TTG"));
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleave_NotLengthThree() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        assertEquals(4, dna.cleave(0, "TT"));
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleave_Multiple() {
        DNA_Strand dna1 = new DNA_Strand("ACTTGATTGGGTTG");
        DNA_Strand dna2 = new DNA_Strand("ACTTGATTGGGTTG");
        assertEquals(5, dna1.cleave(0, "TTG"));
        assertEquals("ACTTGGGTTG", dna1.toString());
        assertEquals(10, dna1.size());
        assertEquals(9, dna2.cleave(4, "TTG"));
        assertEquals("ACTTGATTG", dna2.toString());
        assertEquals(9, dna2.size());
    }

    @Test
    public void testCleave_MultiplePairs() {
        DNA_Strand dna1 = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");
        DNA_Strand dna2 = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");
        assertEquals(5, dna1.cleave(0, "TTG"));
        assertEquals("ACTTGGGTTGCTTGCC", dna1.toString());
        assertEquals(16, dna1.size());
        assertEquals(14, dna2.cleave(8, "TTG"));
        assertEquals("ACTTGATTGGGTTGCC", dna2.toString());
        assertEquals(16, dna2.size());
    }

    @Test
    public void testCleave_One() {
        DNA_Strand dna = new DNA_Strand("ACTTGACC");
        assertEquals(-1, dna.cleave(0, "TTG"));
        assertEquals("ACTTGACC", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testCleave_None() {
        DNA_Strand dna = new DNA_Strand("ACTTACC");
        assertEquals(-1, dna.cleave(0, "TTG"));
        assertEquals("ACTTACC", dna.toString());
        assertEquals(7, dna.size());
    }

    @Test
    public void testCleave_Empty() {
        DNA_Strand dna = new DNA_Strand("");
        assertEquals(-1, dna.cleave(0, ""));
        assertEquals("", dna.toString());
        assertEquals(0, dna.size());
    }

    @Test
    public void testCleave_NoPos() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleave("TTG");
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleaveAll_Normal() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleaveAll("TTG");
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleaveAll_NotLengthThree() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleaveAll( "TT");
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleaveAll_Multiple() {
        DNA_Strand dna = new DNA_Strand("ACTTGATTGGGTTG");
        dna.cleaveAll( "TTG");
        assertEquals("ACTTGGGTTG", dna.toString());
        assertEquals(10, dna.size());
    }

    @Test
    public void testCleaveAll_MultiplePairs() {
        DNA_Strand dna = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");
        dna.cleaveAll("TTG");
        assertEquals("ACTTGGGTTGCC", dna.toString());
        assertEquals(12, dna.size());
    }

    @Test
    public void testCleaveAll_One() {
        DNA_Strand dna = new DNA_Strand("ACTTGACC");
        dna.cleaveAll("TTG");
        assertEquals("ACTTGACC", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testCleaveAll_None() {
        DNA_Strand dna = new DNA_Strand("ACTTACC");
        dna.cleaveAll("TTG");
        assertEquals("ACTTACC", dna.toString());
        assertEquals(7, dna.size());
    }

    @Test
    public void testCleaveAll_Empty() {
        DNA_Strand dna = new DNA_Strand("");
        dna.cleaveAll( "");
        assertEquals("", dna.toString());
        assertEquals(0, dna.size());
    }
}
