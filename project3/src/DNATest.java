// File name: DNATest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 9/28/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework. I further acknowledge that the instructors are the copyright
//                  owners of this HW.
// Assignment Number: #3
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
        assertEquals('T', dna.get(1));
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
        dna.set(3, 'T');
        assertEquals('T', dna.get(3));
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
    public void testEquals_Same() {
        DNA_Strand dna = new DNA_Strand("ATTGCCGTT");

        assertTrue(dna.equals(dna));
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
    public void testCountEnzymeString_Repeated() {
        DNA_Strand dna = new DNA_Strand("AAAAAAAAAAA");
        assertEquals(3, dna.countEnzyme("AAA"));
    }

    @Test
    public void testCountEnzymeString_Split() {
        DNA_Strand dna = new DNA_Strand("CCABDGGCC");
        assertEquals(2, dna.countEnzyme("CC"));
    }

    @Test
    public void testCountEnzymeString_NotIn() {
        DNA_Strand dna = new DNA_Strand("CCACC");
        assertEquals(0, dna.countEnzyme("AA"));
    }

    @Test
    public void testCountEnzymeString_OneChar() {
        DNA_Strand dna = new DNA_Strand("C");
        assertEquals(1, dna.countEnzyme("C"));
    }

    @Test
    public void testCountEnzymeString_Empty() {
        DNA_Strand dna1 = new DNA_Strand();
        DNA_Strand dna2 = new DNA_Strand("");
        assertEquals(0, dna1.countEnzyme("C"));
        assertEquals(0, dna2.countEnzyme("C"));
    }

    @Test
    public void testCleave_Normal() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleave(0, "TTG");
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleave_NotLengthThree() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleave(0, "TT");
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleave_Multiple() {
        DNA_Strand dna1 = new DNA_Strand("ACTTGATTGGGTTG");
        DNA_Strand dna2 = new DNA_Strand("ACTTGATTGGGTTG");
        dna1.cleave(0, "TTG");
        assertEquals("ACTTGGGTTG", dna1.toString());
        assertEquals(10, dna1.size());
        dna2.cleave(4, "TTG");
        assertEquals("ACTTGATTG", dna2.toString());
        assertEquals(9, dna2.size());
    }

    @Test
    public void testCleave_MultiplePairs() {
        DNA_Strand dna1 = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");
        DNA_Strand dna2 = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");
        dna1.cleave(0, "TTG");
        assertEquals("ACTTGGGTTGCTTGCC", dna1.toString());
        assertEquals(16, dna1.size());
        dna2.cleave(8, "TTG");
        assertEquals("ACTTGATTGGGTTGCC", dna2.toString());
        assertEquals(16, dna2.size());
    }

    @Test
    public void testCleave_One() {
        DNA_Strand dna = new DNA_Strand("ACTTGACC");
        dna.cleave(0, "TTG");
        assertEquals("ACTTGACC", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testCleave_None() {
        DNA_Strand dna = new DNA_Strand("ACTTACC");
        dna.cleave(0, "TTG");
        assertEquals("ACTTACC", dna.toString());
        assertEquals(7, dna.size());
    }

    @Test
    public void testCleave_Empty() {
        DNA_Strand dna1 = new DNA_Strand("");
        DNA_Strand dna2 = new DNA_Strand("AAA");

        dna1.cleave(0, "");
        assertEquals("", dna1.toString());
        assertEquals(0, dna1.size());

        dna2.cleave(0, "");
        assertEquals("AAA", dna2.toString());
        assertEquals(3, dna2.size());
    }

    @Test
    public void testCleave_NoPos() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleave("TTG");
        assertEquals("ACTTGA", dna.toString());
        assertEquals(6, dna.size());
    }

    @Test
    public void testCleave_NotFoundEdge() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        dna.cleave("TTGAC");
        assertEquals("ACTTGACCTTGA", dna.toString());
        assertEquals(12, dna.size());
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

    @Test
    public void testClone_Normal() {
        DNA_Strand dna = new DNA_Strand("ACTTGACCTTGA");
        DNA_Strand dnaClone = dna.clone();
        assertEquals(dna, dnaClone);
        dnaClone.cleave(0, "TTG");
        assertNotEquals(dna, dnaClone);
    }

    @Test
    public void testAppend_NormalString() {
        DNA_Strand dna = new DNA_Strand("ACTTGA");

        dna.append("ACCTG");

        assertEquals("ACTTGAACCTG", dna.toString());
        assertEquals(11, dna.size());
    }

    @Test
    public void testAppend_NormalStrand() {
        DNA_Strand dna = new DNA_Strand("ACTTGA");
        DNA_Strand appendStrand = new DNA_Strand("ACCTG");

        dna.append(appendStrand);

        assertEquals("ACTTGAACCTG", dna.toString());
        assertEquals(11, dna.size());
    }

    @Test
    public void testAppend_Empty() {
        DNA_Strand dna = new DNA_Strand();

        dna.append("AAA");

        assertEquals("AAA", dna.toString());
        assertEquals(3, dna.size());
    }

    @Test
    public void testSplice_EndSameSize() {
        DNA_Strand dna = new DNA_Strand("AGTTGAG");
        dna.splice(0, "AG", "CCCCC");
        assertEquals("AGCCCCC", dna.toString());
        assertEquals(7, dna.size());
    }

    @Test
    public void testSplice_SameSize() {
        DNA_Strand dna = new DNA_Strand("AGTTGAGA");
        dna.splice(0, "AG", "CCCCC");
        assertEquals("AGCCCCCA", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testSplice_SingleChar() {
        DNA_Strand dna = new DNA_Strand("AGTTGA");
        dna.splice(0, "G", "CCCCC");
        assertEquals("AGCCCCCA", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testSplice_Smaller() {
        DNA_Strand dna = new DNA_Strand("ACTTGATTGGGTTG");
        dna.splice(0, "TTG", "C");
        assertEquals("ACTTGCGGTTG", dna.toString());
        assertEquals(11, dna.size());
    }

    @Test
    public void testSplice_Larger() {
        DNA_Strand dna = new DNA_Strand("ACTTGATTGGGTTG");
        dna.splice(0, "TTG", "CCCCCC");
        assertEquals("ACTTGCCCCCCGGTTG", dna.toString());
        assertEquals(16, dna.size());
    }

    @Test
    public void testSplice_Multiple() {
        DNA_Strand dna1 = new DNA_Strand("ACTTGATTGGGTTG");
        DNA_Strand dna2 = new DNA_Strand("ACTTGATTGGGTTG");
        dna1.splice(0, "TTG", "CCC");
        assertEquals("ACTTGCCCGGTTG", dna1.toString());
        assertEquals(13, dna1.size());
        dna2.splice(4, "TTG", "CCC");
        assertEquals("ACTTGATTGCCC", dna2.toString());
        assertEquals(12, dna2.size());
    }

    @Test
    public void testSplice_MultiplePairs() {
        DNA_Strand dna1 = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");
        DNA_Strand dna2 = new DNA_Strand("ACTTGATTGGGTTGCTTGCC");

        dna1.splice(0, "TTG", "CCCCC");
        assertEquals("ACTTGCCCCCGGTTGCTTGCC", dna1.toString());
        assertEquals(21, dna1.size());

        dna2.splice(8, "TTG", "CCCCC");
        assertEquals("ACTTGATTGGGTTGCCCCCCC", dna2.toString());
        assertEquals(21, dna2.size());
    }

    @Test
    public void testSplice_One() {
        DNA_Strand dna = new DNA_Strand("ACTTGACC");
        dna.splice(0, "TTG", "CCC");
        assertEquals("ACTTGACC", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testSplice_None() {
        DNA_Strand dna = new DNA_Strand("ACTTACC");
        dna.splice(0, "TTG", "CCC");
        assertEquals("ACTTACC", dna.toString());
        assertEquals(7, dna.size());
    }

    @Test
    public void testSplice_Empty() {
        DNA_Strand dna = new DNA_Strand();
        dna.splice(0, "", "C");
        assertEquals("", dna.toString());
        assertEquals(0, dna.size());

        dna.append("ATGASDFB");
        dna.splice(0, "A", "BCDE");
        assertEquals("ABCDESDFB", dna.toString());
        assertEquals(9, dna.size());
    }

    @Test
    public void testSplice_NoPos() {
        DNA_Strand dna = new DNA_Strand("AGTTGA");
        dna.splice("G", "CCCCC");
        assertEquals("AGCCCCCA", dna.toString());
        assertEquals(8, dna.size());
    }

    @Test
    public void testSplice_Edge() {
        DNA_Strand dna = new DNA_Strand("AGTTGA");
        dna.splice("TTGA", "CCCCC");
        assertEquals("AGTTGA", dna.toString());
        assertEquals(6, dna.size());
    }
}
