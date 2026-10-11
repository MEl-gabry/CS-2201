// File name: StringJrTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 8/28/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #0
// Description: This will test the StringJr class

/**
 * The following checklist is an additional (and optional) support that you may want to consult 
 * before/during/after testing.
 * To help us better understand students' testing practices and hence improve our teaching 
 * practices, please check off the items that you consulted with an “x”, for example, [ x ].
 *
 * Each test case should:
 * [ x ] The test case is executable (i.e., it has an @Test annotation and can be run via “Run as
 *     JUnit Test”)
 * [ x ] The test case has at least one assert statement or asserts an exception is thrown
 * [ x ] The test case evaluates/tests only one method/behavior
 * Each test case could:
 * [] The test case is descriptively named and commented
 * [ x ] If there is redundant setup code in multiple test cases, extract it into a common method
 *     (e.g., using @BeforeEach)
 * [] If there are too many assert statements in a single test case (e.g., more than 5), you might
 *     split it up
 * The test suite should
 * [ x ] The test suite has at least one test for each requirement
 * [] The test suite appropriately uses the setup and teardown code (e.g., @BeforeEach, which runs
 *     before each @Test)
 * [] The test suite contains a fault-revealing test for each bug in the code (i.e., a test
 *     that fails)
 * [ x ] For each requirement, the test suite contains unit tests for:
 *      [ x ] Valid inputs
 *      [ x ] Boundary cases
 *      [ x ] Invalid inputs
 *      [ x ] Expected exceptions
 * To improve the test suite, you could:
 * [ x ] To improve the test suite, you could measure code coverage using an appropriate tool, such as
 *     “Run with Coverage” in IntelliJ. Inspect uncovered code and write tests as appropriate.
 */

import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringJrTest {
    private static String[] strings = {"", "a", " \n", " hello", "hello ", "abcd", "ABCD", "HeLLo", "1234", "abcd1234", "/.[]{}()<>*+-=!?^$|",
            "Hello, world!", "∞∫∑Ω°µ€£¥©®", "\uD83D\uDE00\uD83E\uDD23\uD83D\uDE43", "مرحبا", "a".repeat(10000), "civic", "\t\n\r", "a" + "b", "Hello"};
    
    @Test
    @Order(1)
    public void testConstructor_Null() {
        Exception e = assertThrows(NullPointerException.class, () -> new StringJr(null));
        assertEquals("Cannot invoke \"java.lang.String.length()\" because \"original\" is null", e.getMessage());
    }

    @Test
    public void testLength_Empty() {
        StringJr str1 = new StringJr();
        StringJr str2 = new StringJr(strings[0]);

        assertEquals(0, str1.length());
        assertEquals(strings[0].length(), str2.length());
    }

    @Test
    public void testLength_SingleChar() {
        StringJr str = new StringJr(strings[1]);
        assertEquals(strings[1].length(), str.length());
    }

    @Test
    public void testLength_WhitespaceOnly() {
        StringJr str = new StringJr(strings[2]);
        assertEquals(strings[2].length(), str.length());
    }

    @Test
    public void testLength_LeadingWhitespace() {
        StringJr str = new StringJr(strings[3]);
        assertEquals(strings[3].length(), str.length());
    }

    @Test
    public void testLength_TrailingWhitespace() {
        StringJr str = new StringJr(strings[4]);
        assertEquals(strings[4].length(), str.length());
    }

    @Test
    public void testLength_Lowercase() {
        StringJr str = new StringJr(strings[5]);
        assertEquals(strings[5].length(), str.length());
    }

    @Test
    public void testLength_Uppercase() {
        StringJr str = new StringJr(strings[6]);
        assertEquals(strings[6].length(), str.length());
    }

    @Test
    public void testLength_MixedCase() {
        StringJr str = new StringJr(strings[7]);
        assertEquals(strings[7].length(), str.length());
    }

    @Test
    public void testLength_Digits() {
        StringJr str = new StringJr(strings[8]);
        assertEquals(strings[8].length(), str.length());
    }

    @Test
    public void testLength_Alphanumeric() {
        StringJr str = new StringJr(strings[9]);
        assertEquals(strings[9].length(), str.length());
    }

    @Test
    public void testLength_SpecialCharacters() {
        StringJr str = new StringJr(strings[10]);
        assertEquals(strings[10].length(), str.length());
    }

    @Test
    public void testLength_Punctuation() {
        StringJr str = new StringJr(strings[11]);
        assertEquals(strings[11].length(), str.length());
    }

    @Test
    public void testLength_Unicode() {
        StringJr str = new StringJr(strings[12]);
        assertEquals(strings[12].length(), str.length());
    }

    @Test
    public void testLength_Emoji() {
        StringJr str = new StringJr(strings[13]);
        assertEquals(strings[13].length(), str.length());
    }

    @Test
    public void testLength_RightToLeft() {
        StringJr str = new StringJr(strings[14]);
        assertEquals(strings[14].length(), str.length());
    }

    @Test
    public void testLength_LargeLength() {
        StringJr str = new StringJr(strings[15]);
        assertEquals(strings[15].length(), str.length());
    }

    @Test
    public void testLength_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        StringJr str1 = new StringJr(strings[16]);
        StringJr str2 = new StringJr(res.toString());

        assertEquals(strings[16].length(), str1.length());
        assertEquals(strings[16].length(), str2.length());
    }

    @Test
    public void testLength_EscapeSequence() {
        StringJr str = new StringJr(strings[17]);
        assertEquals(strings[17].length(), str.length());
    }

    @Test
    public void testLength_Concatenation() {
        StringJr str = new StringJr(strings[18]);
        assertEquals(strings[18].length(), str.length());
    }

    @Test
    public void testLength_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        assertEquals(strings[19].length(), str1.length());
        assertEquals(strings[19].length(), str2.length());
    }

    @Test
    public void testIsEmpty_Empty() {
        StringJr str1 = new StringJr();
        StringJr str2 = new StringJr(strings[0]);

        assertTrue(str1.isEmpty());
        assertTrue(str2.isEmpty());
    }

    @Test
    public void testIsEmpty_SingleChar() {
        StringJr str = new StringJr(strings[1]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_WhitespaceOnly() {
        StringJr str = new StringJr(strings[2]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_LeadingWhitespace() {
        StringJr str = new StringJr(strings[3]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_TrailingWhitespace() {
        StringJr str = new StringJr(strings[4]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Lowercase() {
        StringJr str = new StringJr(strings[5]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Uppercase() {
        StringJr str = new StringJr(strings[6]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_MixedCase() {
        StringJr str = new StringJr(strings[7]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Digits() {
        StringJr str = new StringJr(strings[8]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Alphanumeric() {
        StringJr str = new StringJr(strings[9]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_SpecialCharacters() {
        StringJr str = new StringJr(strings[10]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Punctuation() {
        StringJr str = new StringJr(strings[11]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Unicode() {
        StringJr str = new StringJr(strings[12]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Emoji() {
        StringJr str = new StringJr(strings[13]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_RightToLeft() {
        StringJr str = new StringJr(strings[14]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_LargeLength() {
        StringJr str = new StringJr(strings[15]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        StringJr str1 = new StringJr(strings[16]);
        StringJr str2 = new StringJr(res.toString());

        assertFalse(str1.isEmpty());
        assertFalse(str2.isEmpty());
    }

    @Test
    public void testIsEmpty_EscapeSequence() {
        StringJr str = new StringJr(strings[17]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Concatenation() {
        StringJr str = new StringJr(strings[18]);
        assertFalse(str.isEmpty());
    }

    @Test
    public void testIsEmpty_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        assertFalse(str1.isEmpty());
        assertFalse(str2.isEmpty());
    }

    @Test
    public void testCharAt_Empty() {
        StringJr str1 = new StringJr();
        StringJr str2 = new StringJr(strings[0]);

        Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> str1.charAt(0));
        assertEquals("Index out of range: 0", e1.getMessage());

        Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> str2.charAt(strings[0].length()));
        assertEquals("Index out of range: 0", e2.getMessage());
    }

    public void checkCharAt(String s) {
        StringJr str = new StringJr(s);

        assertEquals(s.charAt(0), str.charAt(0));
        assertEquals(s.charAt(s.length() / 2), str.charAt(s.length() / 2));
        assertEquals(s.charAt(s.length() - 1), str.charAt(s.length() - 1));
    }

    @Test
    public void testCharAt_SingleChar() {
        checkCharAt(strings[1]);
    }

    @Test
    public void testCharAt_WhitespaceOnly() {
        checkCharAt(strings[2]);
    }

    @Test
    public void testCharAt_LeadingWhitespace() {
        checkCharAt(strings[3]);
    }

    @Test
    public void testCharAt_TrailingWhitespace() {
        checkCharAt(strings[4]);
    }

    @Test
    public void testCharAt_Lowercase() {
        checkCharAt(strings[5]);
    }

    @Test
    public void testCharAt_Uppercase() {
        checkCharAt(strings[6]);
    }

    @Test
    public void testCharAt_MixedCase() {
        checkCharAt(strings[7]);
    }

    @Test
    public void testCharAt_Digits() {
        checkCharAt(strings[8]);
    }

    @Test
    public void testCharAt_Alphanumeric() {
        checkCharAt(strings[9]);
    }

    @Test
    public void testCharAt_SpecialCharacters() {
        checkCharAt(strings[10]);
    }

    @Test
    public void testCharAt_Punctuation() {
        checkCharAt(strings[11]);
    }

    @Test
    public void testCharAt_Unicode() {
        checkCharAt(strings[12]);
    }

    @Test
    public void testCharAt_Emoji() {
        checkCharAt(strings[13]);
    }

    @Test
    public void testCharAt_RightToLeft() {
        checkCharAt(strings[14]);
    }

    @Test
    public void testCharAt_LargeLength() {
        checkCharAt(strings[15]);
    }

    @Test
    public void testCharAt_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkCharAt(strings[16]);
        checkCharAt(res.toString());
    }

    @Test
    public void testCharAt_EscapeSequence() {
        checkCharAt(strings[17]);
    }

    @Test
    public void testCharAt_Concatenation() {
        checkCharAt(strings[18]);
    }

    @Test
    public void testCharAt_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkCharAt(str1);
        checkCharAt(str2);
    }

    public void checkOutOfBounds(StringJr str) {
        Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> str.charAt(Integer.MAX_VALUE));
        Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> str.charAt(Integer.MIN_VALUE));
        assertEquals("Index out of range: " + Integer.MAX_VALUE, e1.getMessage());
        assertEquals("Index out of range: " + Integer.MIN_VALUE, e2.getMessage());
    }

    @Test
    public void testCharAt_EmptyExtremeValues() {
        checkOutOfBounds(new StringJr());
        checkOutOfBounds(new StringJr(strings[0]));
    }

    @Test
    public void testCharAt_SingleCharOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[1]));
    }

    @Test
    public void testCharAt_WhitespaceOnlyOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[2]));
    }

    @Test
    public void testCharAt_LeadingWhitespaceOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[3]));
    }

    @Test
    public void testCharAt_TrailingWhitespaceOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[4]));
    }

    @Test
    public void testCharAt_LowercaseOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[5]));
    }

    @Test
    public void testCharAt_UppercaseOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[6]));
    }

    @Test
    public void testCharAt_MixedCaseOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[7]));
    }

    @Test
    public void testCharAt_DigitsOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[8]));
    }

    @Test
    public void testCharAt_AlphanumericOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[9]));
    }

    @Test
    public void testCharAt_SpecialCharactersOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[10]));
    }

    @Test
    public void testCharAt_PunctuationOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[11]));
    }

    @Test
    public void testCharAt_UnicodeOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[12]));
    }

    @Test
    public void testCharAt_EmojiOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[13]));
    }

    @Test
    public void testCharAt_RightToLeftOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[14]));
    }

    @Test
    public void testCharAt_LargeLengthAtOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[15]));
    }

    @Test
    public void testCharAt_PalindromeOutOfBounds() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkOutOfBounds(new StringJr(strings[16]));
        checkOutOfBounds(new StringJr(res.toString()));
    }

    @Test
    public void testCharAt_EscapeSequenceOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[17]));
    }

    @Test
    public void testCharAt_ConcatenationOutOfBounds() {
        checkOutOfBounds(new StringJr(strings[18]));
    }

    @Test
    public void testCharAt_HeapOutOfBounds() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkOutOfBounds(new StringJr(str1));
        checkOutOfBounds(new StringJr(str2));
    }

    public void compareStrings(StringJr strJr, String word) {
        String str = strJr.toString();
        assertEquals(word, str);
    }

    public void checkToString() {
        StringJr strJr = new StringJr();
        compareStrings(strJr, "");
    }

    public void checkToString(String word) {
        StringJr strJr = new StringJr(word);
        compareStrings(strJr, word);
    }

    @Test
    public void testToString_Empty() {
        checkToString();
        checkToString("");
    }

    @Test
    public void testToString_SingleChar() {
        checkToString(strings[1]);
    }

    @Test
    public void testToString_WhitespaceOnly() {
        checkToString(strings[2]);
    }

    @Test
    public void testToString_LeadingWhitespace() {
        checkToString(strings[3]);
    }

    @Test
    public void testToString_TrailingWhitespace() {
        checkToString(strings[4]);
    }

    @Test
    public void testToString_Lowercase() {
        checkToString(strings[5]);
    }

    @Test
    public void testToString_Uppercase() {
        checkToString(strings[6]);
    }

    @Test
    public void testToString_MixedCase() {
        checkToString(strings[7]);
    }

    @Test
    public void testToString_Digits() {
        checkToString(strings[8]);
    }

    @Test
    public void testToString_Alphanumeric() {
        checkToString(strings[9]);
    }

    @Test
    public void testToString_SpecialCharacters() {
        checkToString(strings[10]);
    }

    @Test
    public void testToString_Punctuation() {
        checkToString(strings[11]);
    }

    @Test
    public void testToString_Unicode() {
        checkToString(strings[12]);
    }

    @Test
    public void testToString_Emoji() {
        checkToString(strings[13]);
    }

    @Test
    public void testToString_RightToLeft() {
        checkToString(strings[14]);
    }

    @Test
    public void testToString_LargeLength() {
        checkToString(strings[15]);
    }

    @Test
    public void testToString_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkToString(strings[16]);
        checkToString(res.toString());
    }

    @Test
    public void testToString_EscapeSequence() {
        checkToString(strings[17]);
    }

    @Test
    public void testToString_Concatenation() {
        checkToString(strings[18]);
    }

    @Test
    public void testToString_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkToString(str1);
        checkToString(str2);
    }

    public void checkCaseEquals(StringJr strJr, String word, String string) {
        String lower = string.toLowerCase();
        String upper = string.toUpperCase();


        if (word.equals(lower)) {
            assertTrue(strJr.equals(new StringJr(lower)));
        } else {
            assertFalse(strJr.equals(new StringJr(lower)));
        }

        if (word.equals(upper)) {
            assertTrue(strJr.equals(new StringJr(upper)));
        } else {
            assertFalse(strJr.equals(new StringJr(upper)));
        }
    }

    public void evalEquals(StringJr strJr, String word, int stringsIndex) {
        assertFalse(strJr.equals(word));
        assertTrue(strJr.equals(strJr));
        assertTrue(strJr.equals(new StringJr(word)));
        assertFalse(strJr.equals(null));
        checkCaseEquals(strJr, word, word);

        for (int i = 0; i < strings.length; i++) {
            if (i != stringsIndex) {
                String string = strings[i];
                assertFalse(strJr.equals(string));
                assertFalse(strJr.equals(new StringJr(string)));
                checkCaseEquals(strJr, word, string);
            }
        }
    }

    public void checkEquals() {
        StringJr strJr = new StringJr();
        evalEquals(strJr, "", 0);
    }

    public void checkEquals(String word, int stringsIndex) {
        StringJr strJr = new StringJr(word);
        evalEquals(strJr, word, stringsIndex);
    }

    @Test
    public void testEquals_Empty() {
        checkEquals();
        checkEquals("", 0);
    }

    @Test
    public void testEquals_SingleChar() {
        checkEquals(strings[1], 1);
    }

    @Test
    public void testEquals_WhitespaceOnly() {
        checkEquals(strings[2], 2);
    }

    @Test
    public void testEquals_LeadingWhitespace() {
        checkEquals(strings[3], 3);
    }

    @Test
    public void testEquals_TrailingWhitespace() {
        checkEquals(strings[4], 4);
    }

    @Test
    public void testEquals_Lowercase() {
        checkEquals(strings[5], 5);
    }

    @Test
    public void testEquals_Uppercase() {
        checkEquals(strings[6], 6);
    }

    @Test
    public void testEquals_MixedCase() {
        checkEquals(strings[7], 7);
    }

    @Test
    public void testEquals_Digits() {
        checkEquals(strings[8], 8);
    }

    @Test
    public void testEquals_Alphanumeric() {
        checkEquals(strings[9], 9);
    }

    @Test
    public void testEquals_SpecialCharacters() {
        checkEquals(strings[10], 10);
    }

    @Test
    public void testEquals_Punctuation() {
        checkEquals(strings[11], 11);
    }

    @Test
    public void testEquals_Unicode() {
        checkEquals(strings[12], 12);
    }

    @Test
    public void testEquals_Emoji() {
        checkEquals(strings[13], 13);
    }

    @Test
    public void testEquals_RightToLeft() {
        checkEquals(strings[14], 14);
    }

    @Test
    public void testEquals_LargeLength() {
        checkEquals(strings[15], 15);
    }

    @Test
    public void testEquals_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkEquals(strings[16], 16);
        checkEquals(res.toString(), 16);
    }

    @Test
    public void testEquals_EscapeSequence() {
        checkEquals(strings[17], 17);
    }

    @Test
    public void testEquals_Concatenation() {
        checkEquals(strings[18], 18);
    }

    @Test
    public void testEquals_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkEquals(str1, 19);
        checkEquals(str2, 19);
    }

    public void checkCaseEqualsIgnoreCase(StringJr strJr, String word, String string) {
        String lower = string.toLowerCase();
        String upper = string.toUpperCase();


        if (word.equalsIgnoreCase(lower)) {
            assertTrue(strJr.equalsIgnoreCase(new StringJr(lower)));
        } else {
            assertFalse(strJr.equalsIgnoreCase(new StringJr(lower)));
        }

        if (word.equalsIgnoreCase(upper)) {
            assertTrue(strJr.equalsIgnoreCase(new StringJr(upper)));
        } else {
            assertFalse(strJr.equalsIgnoreCase(new StringJr(upper)));
        }
    }

    public void evalEqualsIgnoreCase(StringJr strJr, String word, int stringsIndex) {
        assertTrue(strJr.equalsIgnoreCase(strJr));
        assertTrue(strJr.equalsIgnoreCase(new StringJr(word)));
        assertFalse(strJr.equalsIgnoreCase(null));
        checkCaseEqualsIgnoreCase(strJr, word, word);

        for (int i = 0; i < strings.length; i++) {
            if (i != stringsIndex) {
                String string = strings[i];
                if (word.equalsIgnoreCase(string)) {
                    assertTrue(strJr.equalsIgnoreCase(new StringJr(string)));
                } else {
                    assertFalse(strJr.equalsIgnoreCase(new StringJr(string)));
                }
                checkCaseEqualsIgnoreCase(strJr, word, string);
            }
        }
    }

    public void checkEqualsIgnoreCase() {
        StringJr strJr = new StringJr();
        evalEqualsIgnoreCase(strJr, "", 0);
    }

    public void checkEqualsIgnoreCase(String word, int stringsIndex) {
        StringJr strJr = new StringJr(word);
        evalEqualsIgnoreCase(strJr, word, stringsIndex);
    }

    @Test
    public void testEqualsIgnoreCase_Empty() {
        checkEqualsIgnoreCase();
        checkEqualsIgnoreCase("", 0);
    }

    @Test
    public void testEqualsIgnoreCase_SingleChar() {
        checkEqualsIgnoreCase(strings[1], 1);
    }

    @Test
    public void testEqualsIgnoreCase_WhitespaceOnly() {
        checkEqualsIgnoreCase(strings[2], 2);
    }

    @Test
    public void testEqualsIgnoreCase_LeadingWhitespace() {
        checkEqualsIgnoreCase(strings[3], 3);
    }

    @Test
    public void testEqualsIgnoreCase_TrailingWhitespace() {
        checkEqualsIgnoreCase(strings[4], 4);
    }

    @Test
    public void testEqualsIgnoreCase_Lowercase() {
        checkEqualsIgnoreCase(strings[5], 5);
    }

    @Test
    public void testEqualsIgnoreCase_Uppercase() {
        checkEqualsIgnoreCase(strings[6], 6);
    }

    @Test
    public void testEqualsIgnoreCase_MixedCase() {
        checkEqualsIgnoreCase(strings[7], 7);
    }

    @Test
    public void testEqualsIgnoreCase_Digits() {
        checkEqualsIgnoreCase(strings[8], 8);
    }

    @Test
    public void testEqualsIgnoreCase_Alphanumeric() {
        checkEqualsIgnoreCase(strings[9], 9);
    }

    @Test
    public void testEqualsIgnoreCase_SpecialCharacters() {
        checkEqualsIgnoreCase(strings[10], 10);
    }

    @Test
    public void testEqualsIgnoreCase_Punctuation() {
        checkEqualsIgnoreCase(strings[11], 11);
    }

    @Test
    public void testEqualsIgnoreCase_Unicode() {
        checkEqualsIgnoreCase(strings[12], 12);
    }

    @Test
    public void testEqualsIgnoreCase_Emoji() {
        checkEqualsIgnoreCase(strings[13], 13);
    }

    @Test
    public void testEqualsIgnoreCase_RightToLeft() {
        checkEqualsIgnoreCase(strings[14], 14);
    }

    @Test
    public void testEqualsIgnoreCase_LargeLength() {
        checkEqualsIgnoreCase(strings[15], 15);
    }

    @Test
    public void testEqualsIgnoreCase_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkEqualsIgnoreCase(strings[16], 16);
        checkEqualsIgnoreCase(res.toString(), 16);
    }

    @Test
    public void testEqualsIgnoreCase_EscapeSequence() {
        checkEqualsIgnoreCase(strings[17], 17);
    }

    @Test
    public void testEqualsIgnoreCase_Concatenation() {
        checkEqualsIgnoreCase(strings[18], 18);
    }

    @Test
    public void testEqualsIgnoreCase_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkEqualsIgnoreCase(str1, 19);
        checkEqualsIgnoreCase(str2, 19);
    }

    public void evalIndexOf(StringJr strJr, String word) {
        assertEquals(-1, strJr.indexOf('z'));

        for (char c : word.toCharArray()) {
            assertEquals(word.indexOf(c), strJr.indexOf(c));
        }
    }

    public void checkIndexOf(String word) {
        StringJr strJr = new StringJr(word);
        evalIndexOf(strJr, word);
    }

    public void checkIndexOf() {
        StringJr strJr = new StringJr();
        evalIndexOf(strJr, "");
    }
    
    @Test
    public void testIndexOf_Empty() {
        checkIndexOf();
        checkIndexOf("");
    }

    @Test
    public void testIndexOf_SingleChar() {
        checkIndexOf(strings[1]);
    }

    @Test
    public void testIndexOf_WhitespaceOnly() {
        checkIndexOf(strings[2]);
    }

    @Test
    public void testIndexOf_LeadingWhitespace() {
        checkIndexOf(strings[3]);
    }

    @Test
    public void testIndexOf_TrailingWhitespace() {
        checkIndexOf(strings[4]);
    }

    @Test
    public void testIndexOf_Lowercase() {
        checkIndexOf(strings[5]);
    }

    @Test
    public void testIndexOf_Uppercase() {
        checkIndexOf(strings[6]);
    }

    @Test
    public void testIndexOf_MixedCase() {
        checkIndexOf(strings[7]);
    }

    @Test
    public void testIndexOf_Digits() {
        checkIndexOf(strings[8]);
    }

    @Test
    public void testIndexOf_Alphanumeric() {
        checkIndexOf(strings[9]);
    }

    @Test
    public void testIndexOf_SpecialCharacters() {
        checkIndexOf(strings[10]);
    }

    @Test
    public void testIndexOf_Punctuation() {
        checkIndexOf(strings[11]);
    }

    @Test
    public void testIndexOf_Unicode() {
        checkIndexOf(strings[12]);
    }

    @Test
    public void testIndexOf_Emoji() {
        checkIndexOf(strings[13]);
    }

    @Test
    public void testIndexOf_RightToLeft() {
        checkIndexOf(strings[14]);
    }

    @Test
    public void testIndexOf_LargeLength() {
        checkIndexOf(strings[15]);
    }

    @Test
    public void testIndexOf_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkIndexOf(strings[16]);
        checkIndexOf(res.toString());
    }

    @Test
    public void testIndexOf_EscapeSequence() {
        checkIndexOf(strings[17]);
    }

    @Test
    public void testIndexOf_Concatenation() {
        checkIndexOf(strings[18]);
    }

    @Test
    public void testIndexOf_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkIndexOf(str1);
        checkIndexOf(str2);
    }

    public void evalLastIndexOf(StringJr strJr, String word) {
        assertEquals(-1, strJr.lastIndexOf('z'));

        for (char c : word.toCharArray()) {
            assertEquals(word.lastIndexOf(c), strJr.lastIndexOf(c));
        }
    }

    public void checkLastIndexOf(String word) {
        StringJr strJr = new StringJr(word);
        evalLastIndexOf(strJr, word);
    }

    public void checkLastIndexOf() {
        StringJr strJr = new StringJr();
        evalLastIndexOf(strJr, "");
    }

    @Test
    public void testLastIndexOfEmpty() {
        checkLastIndexOf();
        checkLastIndexOf("");
    }

    @Test
    public void testLastIndexOfSingleChar() {
        checkLastIndexOf(strings[1]);
    }

    @Test
    public void testLastIndexOfWhitespaceOnly() {
        checkLastIndexOf(strings[2]);
    }

    @Test
    public void testLastIndexOfLeadingWhitespace() {
        checkLastIndexOf(strings[3]);
    }

    @Test
    public void testLastIndexOfTrailingWhitespace() {
        checkLastIndexOf(strings[4]);
    }

    @Test
    public void testLastIndexOfLowercase() {
        checkLastIndexOf(strings[5]);
    }

    @Test
    public void testLastIndexOfUppercase() {
        checkLastIndexOf(strings[6]);
    }

    @Test
    public void testLastIndexOfMixedCase() {
        checkLastIndexOf(strings[7]);
    }

    @Test
    public void testLastIndexOfDigits() {
        checkLastIndexOf(strings[8]);
    }

    @Test
    public void testLastIndexOfAlphanumeric() {
        checkLastIndexOf(strings[9]);
    }

    @Test
    public void testLastIndexOfSpecialCharacters() {
        checkLastIndexOf(strings[10]);
    }

    @Test
    public void testLastIndexOfPunctuation() {
        checkLastIndexOf(strings[11]);
    }

    @Test
    public void testLastIndexOfUnicode() {
        checkLastIndexOf(strings[12]);
    }

    @Test
    public void testLastIndexOfEmoji() {
        checkLastIndexOf(strings[13]);
    }

    @Test
    public void testLastIndexOfRightToLeft() {
        checkLastIndexOf(strings[14]);
    }

    @Test
    public void testLastIndexOfLargeLength() {
        checkLastIndexOf(strings[15]);
    }

    @Test
    public void testLastIndexOfPalindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkLastIndexOf(strings[16]);
        checkLastIndexOf(res.toString());
    }

    @Test
    public void testLastIndexOfEscapeSequence() {
        checkLastIndexOf(strings[17]);
    }

    @Test
    public void testLastIndexOfConcatenation() {
        checkLastIndexOf(strings[18]);
    }

    @Test
    public void testLastIndexOfHeap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkLastIndexOf(str1);
        checkLastIndexOf(str2);
    }

    public void evalSubstring(StringJr strJr, String word) {
        assertEquals(new StringJr(word), strJr.substring(0, word.length()));
        assertEquals(new StringJr(word), strJr.substring(0));
        assertEquals(new StringJr(word.substring(word.length() / 2)), strJr.substring(word.length() / 2, word.length()));
        assertEquals(new StringJr(word.substring(word.length() / 2)), strJr.substring(word.length() / 2));

        if (!word.isEmpty()) {
            assertEquals(new StringJr(word.substring(word.length() - 1)), strJr.substring(word.length() - 1, word.length()));
            assertEquals(new StringJr(word.substring(word.length() - 1)), strJr.substring(word.length() - 1));
        }

        assertEquals(new StringJr(word.substring(0, word.length() / 2)), strJr.substring(0, word.length() / 2));
        assertEquals(new StringJr(word.substring(word.length() / 2)), strJr.substring(word.length() / 2));
        
        Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> strJr.substring(Integer.MIN_VALUE));
        assertEquals("bad index", e1.getMessage());

        Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> strJr.substring(Integer.MAX_VALUE));
        assertEquals("bad index", e2.getMessage());

        Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> strJr.substring(0, Integer.MAX_VALUE));
        assertEquals("bad index", e3.getMessage());

        if (word.length() != 1) {
            Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> strJr.substring(word.length() - 1, 0));
            assertEquals("bad index", e4.getMessage());
        }

        Exception e5 = assertThrows(IndexOutOfBoundsException.class, () -> strJr.substring(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertEquals("bad index", e5.getMessage());
    }
    
    public void checkSubstring(String word) {
        StringJr strJr = new StringJr(word);
        evalSubstring(strJr, word);
    }

    public void checkSubstring() {
        StringJr strJr = new StringJr();
        evalSubstring(strJr, "");
    }

    @Test
    public void testSubstring_Empty() {
        checkSubstring();
        checkSubstring("");
    }

    @Test
    public void testSubstring_SingleChar() {
        checkSubstring(strings[1]);
    }

    @Test
    public void testSubstring_WhitespaceOnly() {
        checkSubstring(strings[2]);
    }

    @Test
    public void testSubstring_LeadingWhitespace() {
        checkSubstring(strings[3]);
    }

    @Test
    public void testSubstring_TrailingWhitespace() {
        checkSubstring(strings[4]);
    }

    @Test
    public void testSubstring_Lowercase() {
        checkSubstring(strings[5]);
    }

    @Test
    public void testSubstring_Uppercase() {
        checkSubstring(strings[6]);
    }

    @Test
    public void testSubstring_MixedCase() {
        checkSubstring(strings[7]);
    }

    @Test
    public void testSubstring_Digits() {
        checkSubstring(strings[8]);
    }

    @Test
    public void testSubstring_Alphanumeric() {
        checkSubstring(strings[9]);
    }

    @Test
    public void testSubstring_SpecialCharacters() {
        checkSubstring(strings[10]);
    }

    @Test
    public void testSubstring_Punctuation() {
        checkSubstring(strings[11]);
    }

    @Test
    public void testSubstring_Unicode() {
        checkSubstring(strings[12]);
    }

    @Test
    public void testSubstring_Emoji() {
        checkSubstring(strings[13]);
    }

    @Test
    public void testSubstring_RightToLeft() {
        checkSubstring(strings[14]);
    }

    @Test
    public void testSubstring_LargeLength() {
        checkSubstring(strings[15]);
    }

    @Test
    public void testSubstring_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkSubstring(strings[16]);
        checkSubstring(res.toString());
    }

    @Test
    public void testSubstring_EscapeSequence() {
        checkSubstring(strings[17]);
    }

    @Test
    public void testSubstring_Concatenation() {
        checkSubstring(strings[18]);
    }

    @Test
    public void testSubstring_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkSubstring(str1);
        checkSubstring(str2);
    }

    public void evalToLowerCase(StringJr strJr, String word) {
        assertEquals(new StringJr(word.toLowerCase()), strJr.toLowerCase());
    }

    public void checkToLowerCase(String word) {
        StringJr strJr = new StringJr(word);
        evalToLowerCase(strJr, word);
    }

    public void checkToLowerCase() {
        StringJr strJr = new StringJr();
        evalToLowerCase(strJr, "");
    }

    @Test
    public void testToLowerCase_Empty() {
        checkToLowerCase();
        checkToLowerCase(strings[0]);
    }

    @Test
    public void testToLowerCase_SingleChar() {
        checkToLowerCase(strings[1]);
    }

    @Test
    public void testToLowerCase_WhitespaceOnly() {
        checkToLowerCase(strings[2]);
    }

    @Test
    public void testToLowerCase_LeadingWhitespace() {
        checkToLowerCase(strings[3]);
    }

    @Test
    public void testToLowerCase_TrailingWhitespace() {
        checkToLowerCase(strings[4]);
    }

    @Test
    public void testToLowerCase_Lowercase() {
        checkToLowerCase(strings[5]);
    }

    @Test
    public void testToLowerCase_Uppercase() {
        checkToLowerCase(strings[6]);
    }

    @Test
    public void testToLowerCase_MixedCase() {
        checkToLowerCase(strings[7]);
    }

    @Test
    public void testToLowerCase_Digits() {
        checkToLowerCase(strings[8]);
    }

    @Test
    public void testToLowerCase_Alphanumeric() {
        checkToLowerCase(strings[9]);
    }

    @Test
    public void testToLowerCase_SpecialCharacters() {
        checkToLowerCase(strings[10]);
    }

    @Test
    public void testToLowerCase_Punctuation() {
        checkToLowerCase(strings[11]);
    }

    @Test
    public void testToLowerCase_Unicode() {
        checkToLowerCase(strings[12]);
    }

    @Test
    public void testToLowerCase_Emoji() {
        checkToLowerCase(strings[13]);
    }

    @Test
    public void testToLowerCase_RightToLeft() {
        checkToLowerCase(strings[14]);
    }

    @Test
    public void testToLowerCase_LargeLength() {
        checkToLowerCase(strings[15]);
    }

    @Test
    public void testToLowerCase_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkToLowerCase(strings[16]);
        checkToLowerCase(res.toString());
    }

    @Test
    public void testToLowerCase_EscapeSequence() {
        checkToLowerCase(strings[17]);
    }

    @Test
    public void testToLowerCase_Concatenation() {
        checkToLowerCase(strings[18]);
    }

    @Test
    public void testToLowerCase_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkToLowerCase(str1);
        checkToLowerCase(str2);
    }

    public void evalToUpperCase(StringJr strJr, String word) {
        assertEquals(new StringJr(word.toUpperCase()), strJr.toUpperCase());
    }

    public void checkToUpperCase(String word) {
        StringJr strJr = new StringJr(word);
        evalToUpperCase(strJr, word);
    }

    public void checkToUpperCase() {
        StringJr strJr = new StringJr();
        evalToUpperCase(strJr, "");
    }

    @Test
    public void testToUpperCase_Empty() {
        checkToUpperCase();
        checkToUpperCase("");
    }

    @Test
    public void testToUpperCase_SingleChar() {
        checkToUpperCase(strings[1]);
    }

    @Test
    public void testToUpperCase_WhitespaceOnly() {
        checkToUpperCase(strings[2]);
    }

    @Test
    public void testToUpperCase_LeadingWhitespace() {
        checkToUpperCase(strings[3]);
    }

    @Test
    public void testToUpperCase_TrailingWhitespace() {
        checkToUpperCase(strings[4]);
    }

    @Test
    public void testToUpperCase_Lowercase() {
        checkToUpperCase(strings[5]);
    }

    @Test
    public void testToUpperCase_Uppercase() {
        checkToUpperCase(strings[6]);
    }

    @Test
    public void testToUpperCase_MixedCase() {
        checkToUpperCase(strings[7]);
    }

    @Test
    public void testToUpperCase_Digits() {
        checkToUpperCase(strings[8]);
    }

    @Test
    public void testToUpperCase_Alphanumeric() {
        checkToUpperCase(strings[9]);
    }

    @Test
    public void testToUpperCase_SpecialCharacters() {
        checkToUpperCase(strings[10]);
    }

    @Test
    public void testToUpperCase_Punctuation() {
        checkToUpperCase(strings[11]);
    }

    @Test
    public void testToUpperCase_Unicode() {
        checkToUpperCase(strings[12]);
    }

    @Test
    public void testToUpperCase_Emoji() {
        checkToUpperCase(strings[13]);
    }

    @Test
    public void testToUpperCase_RightToLeft() {
        checkToUpperCase(strings[14]);
    }

    @Test
    public void testToUpperCase_LargeLength() {
        checkToUpperCase(strings[15]);
    }

    @Test
    public void testToUpperCase_Palindrome() {
        StringBuilder res = new StringBuilder();
        res.append(strings[16]);
        res.reverse();

        checkToUpperCase(strings[16]);
        checkToUpperCase(res.toString());
    }

    @Test
    public void testToUpperCase_EscapeSequence() {
        checkToUpperCase(strings[17]);
    }

    @Test
    public void testToUpperCase_Concatenation() {
        checkToUpperCase(strings[18]);
    }

    @Test
    public void testToUpperCase_Heap() {
        String str1 = new String(strings[19]);
        String str2 = str1.intern();

        checkToUpperCase(str1);
        checkToUpperCase(str2);
    }
}
