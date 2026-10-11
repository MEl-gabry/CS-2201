// File name: GuitarStringTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #6
// Honor Statement:  I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Tests GuitarString class
// Last Changed: 10/27/2025

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuitarStringTest {
    @Test
    public void testConstructor_Normal() {
        double testFreq = 44100;
        GuitarString myString = new GuitarString(testFreq);
        assertEquals(testFreq, myString.getFrequency(), 0.0001);
        assertEquals(0, myString.getTime());
        assertEquals(0, myString.sample());
    }

    @Test
    public void testConstructor_NonPositiveFrequency() {
        double testFreq = 0;
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> new GuitarString(testFreq));
        assertEquals("Frequency must be positive.", e.getMessage());
    }

    @Test
    public void testPluck_Normal() {
        double testFreq = 44100;
        GuitarString myString = new GuitarString(testFreq);
        myString.pluck();
        assertTrue(-0.5 <= myString.sample() && myString.sample() <= 0.5);
    }

    @Test
    public void testTic_One() {
        double testFreq = 44100;
        GuitarString myString = new GuitarString(testFreq);

        myString.pluck();

        Exception e = assertThrows(RuntimeException.class, () -> myString.tic());
        assertEquals("DblQueue is empty", e.getMessage());
    }

    @Test
    public void testTic_Normal() {
        double testFreq = 22050;
        GuitarString myString = new GuitarString(testFreq);

        myString.pluck();

        double frontVal = myString.sample();

        myString.tic();

        double nextVal = myString.sample();

        myString.tic();

        assertEquals(GuitarString.DECAY_FACTOR
                * ((frontVal + nextVal) / 2), myString.sample());
        assertEquals(2, myString.getTime());
    }

    @Test
    public void testTic_Many() {
        double testFreq = 22050;
        GuitarString myString = new GuitarString(testFreq);
        myString.pluck();

        for (int i = 0; i < 10000; i++) {
            myString.tic();
        }

        assertEquals(0, myString.sample(), 0.00001);
        assertEquals(10000, myString.getTime());
    }

    @Test
    public void testClone_Normal() {
        double testFreq = 22050;
        GuitarString myString = new GuitarString(testFreq);

        myString.pluck();

        GuitarString myStringClone = myString.clone();

        assertEquals(myString, myStringClone);

        for (int i = 0; i < 100; i++) {
            myStringClone.tic();
        }

        assertNotEquals(myString.sample(), myStringClone.sample());
    }

    @Test
    public void testEquals_Same() {
        double testFreq = 22050;
        GuitarString myString1 = new GuitarString(testFreq);
        GuitarString myString2 = new GuitarString(testFreq);

        myString1.pluck();
        myString2.pluck();

        myString1.tic();
        myString2.tic();

        assertEquals(myString1, myString2);
    }

    @Test
    public void testEquals_DifferentFrequency() {
        GuitarString myString1 = new GuitarString(22050);
        GuitarString myString2 = new GuitarString(1000);

        myString1.pluck();
        myString2.pluck();

        myString1.tic();
        myString2.tic();

        assertNotEquals(myString1, myString2);
    }

    @Test
    public void testEquals_DifferentTime() {
        double testFreq = 22050;
        GuitarString myString1 = new GuitarString(testFreq);
        GuitarString myString2 = new GuitarString(testFreq);

        myString1.pluck();
        myString2.pluck();

        myString1.tic();

        assertNotEquals(myString1, myString2);
    }

    @Test
    public void testEquals_NotGuitar() {
        double testFreq = 22050;
        GuitarString myString = new GuitarString(testFreq);
        assertFalse(myString.equals(1.0));
    }
}
