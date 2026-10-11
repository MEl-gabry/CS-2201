// File name: TrieTest.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #9
// Honor Statement:  I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Tests Trie class and the equals method of the TrieNode class
// Last Changed: 11/19/2025

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {
    @Test
    public void testIsWord_Words() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertTrue(trie.isWord("for"));
        assertTrue(trie.isWord("fork"));
        assertTrue(trie.isWord("top"));
        assertTrue(trie.isWord("tops"));
        assertTrue(trie.isWord("topsy"));
        assertTrue(trie.isWord("toss"));
    }

    @Test
    public void testIsWord_Empty() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertFalse(trie.isWord(""));
    }

    @Test
    public void testIsWord_Prefixes() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertFalse(trie.isWord("f"));
        assertFalse(trie.isWord("fo"));
        assertFalse(trie.isWord("to"));
        assertFalse(trie.isWord("tos"));
    }

    @Test
    public void testIsWord_NotIn() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertFalse(trie.isWord("h"));
        assertFalse(trie.isWord("happy"));
        assertFalse(trie.isWord("topgun"));
        assertFalse(trie.isWord("tossing"));
    }

    @Test
    public void testIsWord_EmptyTrie() {
        Trie trie = new Trie();

        assertFalse(trie.isWord(""));
        assertFalse(trie.isWord("h"));
        assertFalse(trie.isWord("happy"));
    }

    @Test
    public void testIsPrefix_In() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertTrue(trie.isPrefix(""));
        assertTrue(trie.isPrefix("f"));
        assertTrue(trie.isPrefix("fo"));
        assertTrue(trie.isPrefix("for"));
        assertTrue(trie.isPrefix("fork"));
        assertTrue(trie.isPrefix("t"));
        assertTrue(trie.isPrefix("to"));
        assertTrue(trie.isPrefix("top"));
        assertTrue(trie.isPrefix("tos"));
        assertTrue(trie.isPrefix("tops"));
        assertTrue(trie.isPrefix("toss"));
        assertTrue(trie.isPrefix("topsy"));
    }

    @Test
    public void testIsPrefix_NotIn() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertFalse(trie.isPrefix("h"));
        assertFalse(trie.isPrefix("happy"));
        assertFalse(trie.isPrefix("fore"));
        assertFalse(trie.isPrefix("topsi"));
        assertFalse(trie.isPrefix("tose"));
        assertFalse(trie.isPrefix("tossing"));
    }

    @Test
    public void testIsPrefix_EmptyTrie() {
        Trie trie = new Trie();

        assertTrue(trie.isPrefix(""));
        assertFalse(trie.isPrefix("h"));
        assertFalse(trie.isPrefix("happy"));
    }

    @Test
    public void testToString_Normal() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertEquals("""
                        for
                        fork
                        top
                        tops
                        topsy
                        toss
                        """,
                trie.toString());
    }

    @Test
    public void testToString_Empty() {
        Trie trie = new Trie();

        assertEquals("", trie.toString());
    }

    @Test
    public void testWordCount_Normal() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertEquals(6, trie.wordCount());
    }

    @Test
    public void testWordCount_Empty() {
        Trie trie = new Trie();

        assertEquals(0, trie.wordCount());
    }

    @Test
    public void testClone_Normal() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        Trie trieClone = trie.clone();

        assertEquals(trie, trieClone);

        trieClone.insert("to");

        assertNotEquals(trie, trieClone);
    }

    @Test
    public void testClone_Empty() {
        Trie trie = new Trie();

        Trie trieClone = trie.clone();

        assertEquals(trie, trieClone);

        trieClone.insert("to");

        assertNotEquals(trie, trieClone);
    }

    @Test
    public void testTrieEquals_Same() throws FileNotFoundException {
        Trie trie1 = new Trie();

        trie1.loadFromFile("src/words.txt");

        Trie trie2 = new Trie();

        trie2.loadFromFile("src/words.txt");

        assertEquals(trie1, trie2);
    }

    @Test
    public void testTrieEquals_Different() throws FileNotFoundException {
        Trie trie1 = new Trie();

        trie1.loadFromFile("src/words.txt");

        Trie trie2 = new Trie();

        trie2.insert("dutch");

        assertNotEquals(trie1, trie2);
    }

    @Test
    public void testTrieEquals_NotTrie() throws FileNotFoundException {
        Trie trie = new Trie();

        trie.loadFromFile("src/words.txt");

        assertFalse(trie.equals("a"));
    }

    @Test
    public void testTrieEquals_Empty() {
        Trie trie1 = new Trie();
        Trie trie2 = new Trie();

        assertTrue(trie1.equals(trie2));
    }

    @Test
    public void testTrieNodeEquals_NotTrieNode() {
        TrieNode trieNode = new TrieNode(' ', false);

        assertFalse(trieNode.equals("a"));
    }

    @Test
    public void testTrieNodeEquals_DifferentCharacter() {
        TrieNode trieNode1 = new TrieNode('a', false);
        TrieNode trieNode2 = new TrieNode('b', false);

        assertFalse(trieNode1.equals(trieNode2));
    }
}
