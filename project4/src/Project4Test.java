// File name: Project4Test.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 10/12/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #4
// Description: testing recursive functions
// Last Changed:

// Testing the recursive programming lab

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Project4Test {

    // Here are some initial JUnit tests of the functions you are to implement.
    // You should add tests of your own to fully test the functions. The provided
    // tests do not constitute thorough/complete testing.


    @Test
    public void testMember_Normal() {
        int[] tmp = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        assertTrue(Project4.member(55, tmp, 10));
    }

    @Test
    public void testMember_Empty() {
        int[] tmp = {};
        assertFalse(Project4.member(55, tmp, 0));
    }

    @Test
    public void testMember_NotIn() {
        int[] tmp = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        assertFalse(Project4.member(74, tmp, 10));
    }

    @Test
    public void testIsPalindrome_Normal() {
        assertTrue(Project4.isPalindrome("abcdeedcba"));
    }

    @Test
    public void testIsPalindrome_DifferentCase() {
        assertTrue(Project4.isPalindrome("abcdeedcbA"));
    }

    @Test
    public void testIsPalindrome_NotPalindrome() {
        assertFalse(Project4.isPalindrome("ab"));
    }

    @Test
    public void testIsPalindrome_Empty() {
        assertTrue(Project4.isPalindrome(""));
    }

    @Test
    public void testHarmonicSum_Normal() {
        assertEquals(1.0, Project4.harmonicSum(1), 0.000000001);
        assertEquals((double)55835135/(double)15519504, Project4.harmonicSum(20), 0.000000001);
    }

    @Test
    public void testAddStar_Normal() {
        assertEquals("a*b*c", Project4.addStar("abc"));
    }

    @Test
    public void testAddStar_Empty() {
        assertEquals("", Project4.addStar(""));
    }

    @Test
    public void testReplace_SameSize() {
        int[] tmp = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        int[] result1 = {12, 13, 21, 30, 3, 55, 1000, 5, 201, 789};
        assertEquals(1, Project4.replace(2, 3, tmp, 10));
        assertArrayEquals(result1, tmp);
    }

    @Test
    public void testReplace_DifferentSize() {
        int[] tmp = {2, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        int[] result1 = {3, 13, 21, 30, 3, 55, 1000, 5, 201, 789};
        assertEquals(2, Project4.replace(2, 3, tmp, 8));
        assertArrayEquals(result1, tmp);
    }

    @Test
    public void testReplace_NoOccurrences() {
        int[] tmp = {12, 13, 21, 30, 3, 55, 1000, 5, 201, 789};
        int[] result1 = {12, 13, 21, 30, 3, 55, 1000, 5, 201, 789};
        assertEquals(0, Project4.replace(2, 3, tmp, 10));
        assertArrayEquals(result1, tmp);
    }

    @Test
    public void testReplace_Empty() {
        int[] tmp = {};
        int[] result1 = {};
        assertEquals(0, Project4.replace(2, 3, tmp, 0));
        assertArrayEquals(result1, tmp);
    }

    @Test
    public void testComputeAverage_SameSize() {
        int[] tmp = {12, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        assertEquals(212.8, Project4.computeAverage(tmp, 10), 0.000000001);
    }

    @Test
    public void testComputeAverage_DifferentSize() {
        int[] tmp = {2, 13, 21, 30, 2, 55, 1000, 5, 201, 789};
        assertEquals(16.5, Project4.computeAverage(tmp, 4), 0.000000001);
    }

    @Test
    public void testComputeAverage_Empty() {
        int[] tmp = {};
        assertEquals(0, Project4.computeAverage(tmp, 0), 0.000000001);
    }

    @Test
    public void testGCD_Smaller() {
        assertEquals(6, Project4.gcd(24,30));
    }

    @Test
    public void testGCD_Larger() {
        assertEquals(6, Project4.gcd(30, 24));
    }

    @Test
    public void testGCD_OneZero() {
        assertEquals(24, Project4.gcd(0, 24));
    }

    @Test
    public void testGCD_TwoZeroes() {
        assertEquals(0, Project4.gcd(0, 0));
    }

    @Test
    public void testHelloWorldRepeat_Normal() {
        assertEquals("Hello Hello Hello World World World", Project4.helloWorldRepeat(3));
    }

    @Test
    public void testHelloWorldRepeat_One() {
        assertEquals("Hello World", Project4.helloWorldRepeat(1));
    }

    @Test
    public void testHelloWorldRepeat_Zero() {
        assertEquals("", Project4.helloWorldRepeat(0));
    }


    @Test
    public void testConvert2Binary_Odd() {
        assertEquals("11001", Project4.convert2Binary(25));
    }

    @Test
    public void testConvert2Binary_Even() {
        assertEquals("11000", Project4.convert2Binary(24));
    }

    @Test
    public void testConvert2Binary_Zero() {
        assertEquals("0", Project4.convert2Binary(0));
    }

    @Test
    public void testPrintPattern_Normal() {
        System.out.println("A four star hourglass pattern: ");
        Project4.printPattern(4);
        System.out.println();
    }

    @Test
    public void testPrintPattern_One() {
        System.out.println("A one star hourglass pattern: ");
        Project4.printPattern(1);
        System.out.println();
    }

    @Test
    public void testReverseSentence_Even() {
        String sentence = "I love to program.";
        assertEquals("program. to love I", Project4.reverseSentence(sentence));
    }

    @Test
    public void testReverseSentence_Odd() {
        String sentence = "I always love to program.";
        assertEquals("program. to love always I", Project4.reverseSentence(sentence));
    }

    @Test
    public void testReverseSentence_One() {
        String sentence = "a";
        assertEquals("a", Project4.reverseSentence(sentence));
    }

    @Test
    public void testArrayInitialize_Normal() {
        int[] testI = new int[100]; // all initialized to zero
        Project4.arrayInitialize(testI, 5, 20, 80);
        for (int k=0; k<20; k++) {
            assertEquals(0, testI[k]);
        }
        for (int k=20; k<=80; k++) {
            assertEquals(5, testI[k]);
        }
        for (int k=81; k<100; k++) {
            assertEquals(0, testI[k]);
        }
    }

    @Test
    public void testArrayInitialize_Greater() {
        int[] testI = new int[100]; // all initialized to zero
        Project4.arrayInitialize(testI, 5, 80, 20);
        for (int k=0; k<100; k++) {
            assertEquals(0, testI[k]);
        }
    }

    @Test
    public void testBinomialCoeff_Normal() {
        assertEquals(6, Project4.binomialCoeff(4,2));
    }

    @Test
    public void testBinomialCoeff_Equal() {
        assertEquals(1, Project4.binomialCoeff(4,4));
    }

    @Test
    public void testBinomialCoeff_Zero() {
        assertEquals(1, Project4.binomialCoeff(4,0));
    }

    @Test
    public void testNumDecodes_Normal() {
        assertEquals(3, Project4.numDecodes("111")); //aaa,ak,ka
        assertEquals(5, Project4.numDecodes("1221")); //abba,abu,ava,lba,lu
    }

    @Test
    public void testNumDecodes_Twenty() {
        assertEquals(1, Project4.numDecodes("201")); //ta
    }

    @Test
    public void testNumDecodes_TwentySeven() {
        assertEquals(1, Project4.numDecodes("27")); //ta
    }

    @Test
    public void testNumDecodes_ThirtyOne() {
        assertEquals(1, Project4.numDecodes("31")); //ta
    }

    @Test
    public void testNumDecodes_One() {
        assertEquals(1, Project4.numDecodes("1")); //t
    }

    @Test
    public void testNumDecodes_Empty() {
        assertEquals(1, Project4.numDecodes("")); //t
    }

    @Test
    public void testCountSubs_Normal() {
        assertEquals(2, Project4.countSubs("catcowcat","cat"));
    }

    @Test
    public void testCountSubs_Overlap() {
        assertEquals(1, Project4.countSubs("cacac","cac"));
    }

    @Test
    public void testCountSubs_OneOff() {
        assertEquals(2, Project4.countSubs("ccatcowcat","cat"));
    }

    @Test
    public void testCountSubs_NoIn() {
        assertEquals(0, Project4.countSubs("cacowca","cat"));
    }

    @Test
    public void testCountSubs_Empty() {
        assertEquals(0, Project4.countSubs("","cat"));
    }

    @Test
    public void testMoveXs_Normal() {
        assertEquals("rexx", Project4.moveXs("xxre"));
    }

    @Test
    public void testMoveXs_NoXs() {
        assertEquals("abcd", Project4.moveXs("abcd"));
    }

    @Test
    public void testMoveXs_Empty() {
        assertEquals("", Project4.moveXs(""));
    }

    @Test
    public void testNewton_Normal() {
        // test that Newton's approximate is within 0.00001 of actual
        assertEquals(Math.sqrt(33333), Project4.newton(33333, 10), 0.00001);
    }

    @Test
    public void testNewton_Zero() {
        // test that Newton's approximate is within 0.00001 of actual
        assertEquals((double) 33333 / 2, Project4.newton(33333, 0), 0.00001);
    }

    @Test
    public void testUniqueSteps_Normal() {
        assertEquals(5, Project4.uniqueSteps(4));
        assertEquals(2, Project4.uniqueSteps(2));
        assertEquals(10946, Project4.uniqueSteps(20));
    }

    @Test
    public void testUniqueSteps_One() {
        assertEquals(1, Project4.uniqueSteps(1));
    }

    @Test
    public void testK_element_sum_Normal() {
        int[] tmp222 = {789, 201, -5, 1000, 55, 2, -30, -21, 13, 12};
        assertTrue(Project4.K_element_sum(1,13, tmp222,10));
        assertFalse(Project4.K_element_sum(3,979, tmp222,10));
    }

    @Test
    public void testK_element_sum_Zero() {
        int[] tmp222 = {789, 201, -5, 1000, 55, 2, -30, -21, 13, 12};
        assertTrue(Project4.K_element_sum(0,0, tmp222,10));
        assertFalse(Project4.K_element_sum(0,979, tmp222,10));
        assertFalse(Project4.K_element_sum(1,0, tmp222,10));
    }

    @Test
    public void testK_element_sum_Empty() {
        int[] tmp222 = {};
        assertFalse(Project4.K_element_sum(1,13, tmp222,0));
    }

    @Test
    public void testRelatedSquares_Normal() {
        int[] arr1 = {3, 9, 81, 6561};
        assertTrue(Project4.relatedSquares(arr1, 4));
    }

    @Test
    public void testRelatedSquares_False() {
        int[] arr1 = {4, 9, 81, 6561};
        assertFalse(Project4.relatedSquares(arr1, 4));
    }

    @Test
    public void testRelatedSquares_One() {
        int[] arr1 = {1};
        assertFalse(Project4.relatedSquares(arr1, 1));
    }

    @Test
    public void testRelatedSquares_Empty() {
        int[] arr1 = {};
        assertFalse(Project4.relatedSquares(arr1, 0));
    }

    ////////////  TWO HELPFUL METHODS FOR TESTING LINKED LISTS ///////////////

    // print a space-separated list of numbers from a linked-list
    public static void printList(Project4.Node head)
    {

        System.out.print("contents of list: ");
        for (Project4.Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.value + " ");
        }
        System.out.println("Done");

    }

    // return a space-separated list of numbers from a linked-list
    public static String list2String(Project4.Node head)
    {
        String result="";
        for (Project4.Node cur = head; cur != null; cur = cur.next) {
            result += cur.value + " ";
        }
        return result;
    }


    @Test
    public void testNumOfTerms_Nomral() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        int cnt = 0;
        for (int k=0; k<20; k++)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k%3)==0) ? 0 : k%10;
            if (tmpPtr.value != 0) cnt++;
            tmpPtr.next = head;
            head = tmpPtr;
        }
        assertEquals(cnt, Project4.numOfTerms(head));
    }

    @Test
    public void testNumOfTerms_Null() {
        assertEquals(0, Project4.numOfTerms(null));
    }

    @Test
    public void testNormalizeBigNum_AllLeading() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        for (int k=1; k<5; k++)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = k;
            tmpPtr.next = head;
            head = tmpPtr;
        }

        // add some zeros at the end
        for (tmpPtr = head; tmpPtr.next!=null; tmpPtr=tmpPtr.next)
        {} // nothing to do
        for (int i=0; i<6; i++) {   //tmpPtr refers to the last node
            tmpPtr.next = new Project4.Node();
            tmpPtr = tmpPtr.next;
            tmpPtr.value = 0;
            tmpPtr.next = null;
        }

        assertEquals("4 3 2 1 0 0 0 0 0 0 ", list2String(head));
        head = Project4.normalizeBigNum(head);
        assertEquals("4 3 2 1 ", list2String(head));
    }

    @Test
    public void testNormalizeBigNum_NotAllLeading() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        for (int k=1; k<5; k++)
        {
            tmpPtr = new Project4.Node();

            if (k == 2) {
                tmpPtr.value = 0;
            } else {
                tmpPtr.value = k;
            }

            tmpPtr.next = head;
            head = tmpPtr;
        }

        // add some zeros at the end
        for (tmpPtr = head; tmpPtr.next!=null; tmpPtr=tmpPtr.next)
        {} // nothing to do
        for (int i=0; i<6; i++) {   //tmpPtr refers to the last node
            tmpPtr.next = new Project4.Node();
            tmpPtr = tmpPtr.next;
            tmpPtr.value = 0;
            tmpPtr.next = null;
        }

        assertEquals("4 3 0 1 0 0 0 0 0 0 ", list2String(head));
        head = Project4.normalizeBigNum(head);
        assertEquals("4 3 0 1 ", list2String(head));
    }

    @Test
    public void testNormalizeBigNum_OneZero() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;

        tmpPtr = new Project4.Node();
        tmpPtr.value = 0;
        tmpPtr.next = null;
        head = tmpPtr;

        assertEquals("0 ", list2String(head));
        head = Project4.normalizeBigNum(head);
        assertNull(head);
        assertEquals("", list2String(head));
    }

    @Test
    public void testNormalizeBigNum_Empty() {
        assertNull(Project4.normalizeBigNum(null));
    }

    @Test
    public void testEcho2_Normal() {
        // create a linked list
        Project4.Node head = null;
        Project4.Node tmpPtr;
        for (int k=0; k<5; k++)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = k;
            tmpPtr.next = head;
            head = tmpPtr;
        }
        assertEquals("4 3 2 1 0 0 1 2 3 4 ", Project4.echo2(head));
    }

    @Test
    public void testEcho2_Null() {
        assertEquals("", Project4.echo2(null));
    }

    @Test
    public void testEcho2_SingleNode() {
        Project4.Node head = new Project4.Node();
        head.value = 1;
        head.next = null;

        assertEquals("1 1 ", Project4.echo2(head));
    }

    @Test
    public void testContains_Normal() {
        // create a linked list
        Project4.Node superList = null;
        Project4.Node tmpPtr;

        for (int k=0; k<20; k++)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k%4)==0) ? 0 : k;
            tmpPtr.next = superList;
            superList = tmpPtr;
        }

        Project4.Node subList = null;
        for (int k=7; k<20; k=k+2)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = (((k-1)%4)==0) ? 0 : k;
            tmpPtr.next = subList;
            subList = tmpPtr;
        }

        assertTrue(Project4.contains(superList,subList));
    }

    @Test
    public void testContains_NotIn() {
        // create a linked list
        Project4.Node superList = null;
        Project4.Node tmpPtr;

        for (int k=0; k<20; k++)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = ((k%4)==0) ? 0 : k;
            tmpPtr.next = superList;
            superList = tmpPtr;
        }

        Project4.Node subList = null;
        for (int k=7; k<20; k=k+2)
        {
            tmpPtr = new Project4.Node();
            tmpPtr.value = 5;
            tmpPtr.next = subList;
            subList = tmpPtr;
        }

        assertFalse(Project4.contains(superList,subList));
    }

    @Test
    public void testChallenge() {
        Project4.Node head = null;
        // give the list new data
        for (int k = 0; k<20; k++)
        {
            Project4.Node tmpPtr = new Project4.Node();
            tmpPtr.value = ((k % 2) == 0) ? -k : k;
            tmpPtr.next = head;
            head = tmpPtr;
        }

        assertEquals("19 -18 17 -16 15 -14 13 -12 11 -10 9 -8 7 -6 5 -4 3 -2 1 0 ", list2String(head));
        head=Project4.reverseList(head);
        assertEquals("0 1 -2 3 -4 5 -6 7 -8 9 -10 11 -12 13 -14 15 -16 17 -18 19 ", list2String(head));

    }

}