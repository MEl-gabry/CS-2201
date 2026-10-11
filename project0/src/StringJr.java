/**
 * The {@code StringJr} class represents character strings.
 * StringJr objects are constant; their values cannot be changed after they
 * are created. The class {@code StringJr} includes methods for examining
 * individual characters of the sequence, for comparing strings, for searching
 * strings, for extracting substrings, and other standard string operations.
 * <p> Unless otherwise noted, passing a {@code null} argument to a constructor
 * or method in this class will cause a {@link NullPointerException} to be
 * thrown.
 *
 * @author  Jerry Roth
 */


public class StringJr {

	private int mySize; // size of the string

	private char[] myChars; // array of characters of the string

	// constructors

	/**
	 * public StringJr()
	 * <br>
	 * Initializes a newly created StringJr object so that it represents an empty
	 * character sequence. Note that use of this constructor is unnecessary since
	 * Strings are immutable.
	 */
	public StringJr() { // default ctor
		this("");
	}

	/**
	 * public StringJr(String original)
	 * <br>
	 * Initializes a newly created StringJr object so that it represents the same
	 * sequence of characters as the argument; in other words, the newly created
	 * string is a copy of the argument string. This constructor will allow us to
	 * convert a String object into a StringJr object.
	 *
	 * @param original - A String
	 */
	public StringJr(String original) { // alt ctor
		mySize = original.length();
		myChars = new char[mySize];
		
		for (int i = 0; i < mySize; i++) {
			myChars[i] = original.charAt(i);
		}
	}

	/**
	 * public int length()
	 * <br>
	 * Returns the length of this string. The length is equal to the number of
	 * characters in the string.
	 * 
	 * @return the length
	 */
	public int length() {
		return mySize;
	}

	/**
	 * public boolean isEmpty()
	 * <br>
	 * Returns true if, and only if, length() is 0.
	 *
	 * @return true if length() is 0, otherwise false
	 */
	public boolean isEmpty() {
		return mySize == 0;
	}

	/**
	 * public char charAt(int index)
	 * <br>
	 * Returns the char value at the specified index. An index ranges from 0 to
	 * length() - 1. The first char value of the sequence is at index 0, the next at
	 * index 1, and so on, as for array indexing.
	 * 
	 * @param index - the index of the char value.
	 * @return the char value at the specified index of this string. The first char
	 *         value is at index 0. Throws: IndexOutOfBoundsException - if the index
	 *         argument is negative or not less than the length of this string.
	 */
	public char charAt(int index) {
		if (index < 0 || index >= mySize) {
			throw new IndexOutOfBoundsException(index);
		}
		
		return myChars[index];
	}

	/**
	 * public String toString()
	 * <br>
	 * Return a String object equivalent of this StringJr object. This allows us to
	 * convert a StringJr object into a String object.
	 * 
	 * @return a String
	 */
	public String toString() {
		return new String(myChars);
	}

	/**
	 * public boolean equals(Object anObject)
	 * <br>
	 * Compares this string to the specified object. The result is true if and only
	 * if the argument is not null and is a StringJr object that represents the same
	 * sequence of characters as this object. Otherwise, the result is false.
	 * <br>
	 * Overrides: equals in class Object
	 * 
	 * @param - The object to compare this String against
	 * @return true if the given object represents a String equivalent to this
	 *         string, false otherwise
	 */
	public boolean equals(Object anObject) {
		if (!(anObject instanceof StringJr)) {
			return false;
		}
		
		StringJr otherStr = (StringJr) anObject;
		
		if (mySize != otherStr.mySize) {
			return false;
		}
		
		for (int i = 0; i < mySize; i++) {
			if (myChars[i] != otherStr.myChars[i]) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * public boolean equalsIgnoreCase(StringJr otherStr)
	 * <br>
	 * Compares this StringJr to another StringJr, ignoring case considerations. Two
	 * strings are considered equal ignoring case if they are of the same length and
	 * corresponding characters in the two strings are equal ignoring case.
	 * <br>
	 * Two characters c1 and c2 are considered the same ignoring case if the
	 * following is true: Applying the method Character.toUpperCase(char) to each
	 * character produces the same result
	 *
	 * @param otherStr - The StringJr to compare this StringJr against
	 * @return true if the argument is not null and it represents an equivalent
	 *         StringJr ignoring case; false otherwise
	 */
	public boolean equalsIgnoreCase(StringJr otherStr) {
		if (otherStr == null) {
			return false;
		}
		
		if (mySize != otherStr.mySize) {
			return false;
		}
		
		for (int i = 0; i < mySize; i++) {
			if (Character.toUpperCase(myChars[i]) != Character.toUpperCase(otherStr.myChars[i])) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * public int indexOf(char ch)
	 * <br>
	 * Returns the index within this string of the first occurrence of the specified
	 * character. If a character with value ch occurs in the character sequence
	 * represented by this StringJr object, then the index of the first such
	 * occurrence is returned. For values of ch in the range from 0 to 0xFFFF
	 * (inclusive), this is the smallest value k such that: this.charAt(k) == ch is
	 * true. If no such character occurs in this string, then -1 is returned.
	 *
	 * @param ch - a character
	 * @return the index of the first occurrence of the character in the character
	 *         sequence represented by this object, or -1 if the character does not
	 *         occur.
	 */
	public int indexOf(char ch) {
		for (int i = 0; i < mySize; i++) {
			if (myChars[i] == ch) {
				return i; // found ch
			}
		}
		
		return -1; // the character ch was not found
	}

    /**
     * public int lastIndexOf(char ch)
     *  <br>
     * Returns the index within this string of the last occurrence of the specified 
     * character. If a character with value ch occurs in the character sequence
     * represented by this StringJr object, then the index of the last such
     * occurrence is returned. For values of ch in the range from 0 to 0xFFFF 
     * (inclusive), this is the largest value k such that: this.charAt(k) == ch is
     * true. If no such character occurs in this string, then -1 is returned.
     *
     * @param ch - a character
     * @return the index of the last occurrence of the character in the character
     *         sequence represented by this object, or -1 if the character does not
     *         occur.
     */
    public int lastIndexOf(char ch) {
        for (int i = mySize-1; i >= 0; i--) {
            if (myChars[i] == ch) {
                return i; // found ch
            }
        }

        return -1; // the character ch was not found
    }

    /**
	 * public StringJr substring(int beginIndex)
	 * <br>
	 * Returns a string that is a substring of this string. The substring begins
	 * with the character at the specified index and extends to the end of this
	 * string.
	 * 
	 * @param beginIndex - the beginning index, inclusive.
	 * @return the specified substring. Throws: IndexOutOfBoundsException - if
	 *         beginIndex is negative or larger than the length of this StringJr
	 *         object.
	 */
	public StringJr substring(int beginIndex) {
		return substring(beginIndex, mySize);
	}

	/**
	 * public StringJr substring(int beginIndex, int endIndex)
	 * <br>
	 * Returns a string that is a substring of this string. The substring begins at
	 * the specified beginIndex and extends to the character at index endIndex - 1.
	 * Thus the length of the substring is endIndex-beginIndex.
	 * 
	 * @param beginIndex - the beginning index, inclusive.
	 * @param endIndex   - the ending index, exclusive.
	 * @return the specified substring. Throws: IndexOutOfBoundsException - if the
	 *         beginIndex is negative, or endIndex is larger than the length of this
	 *         StringJr object, or beginIndex is larger than endIndex.
	 */
	public StringJr substring(int beginIndex, int endIndex) {
		if (beginIndex < 0 || endIndex > mySize || beginIndex > endIndex) {
			throw new IndexOutOfBoundsException("bad index");
		}
		
		StringJr returnStr = new StringJr();
		returnStr.mySize = endIndex - beginIndex;
		returnStr.myChars = new char[returnStr.mySize];
		
		for (int i = 0; i < returnStr.mySize; i++) {
			returnStr.myChars[i] = myChars[beginIndex + i];
		}
		
		return returnStr;
	}

	/**
	 * public StringJr toLowerCase()
	 * <br>
	 * Converts all of the characters in this String to lower case
	 * 
	 * @return the StringJr, converted to lowercase.
	 */
	public StringJr toLowerCase() {
		StringJr returnStr = new StringJr();
		returnStr.mySize = mySize;
		returnStr.myChars = new char[mySize];
		
		for (int i = 0; i < mySize; i++) {
			returnStr.myChars[i] = Character.toLowerCase(myChars[i]);
		}
		
		return returnStr;
	}

	/**
	 * public StringJr toUpperCase()
	 * <br>
	 * Converts all of the characters in this String to upper case
	 * 
	 * @return the StringJr, converted to uppercase.
	 */
	public StringJr toUpperCase() {
		StringJr returnStr = new StringJr();
		returnStr.mySize = mySize;
		returnStr.myChars = new char[mySize];
		
		for (int i = 0; i < mySize; i++) {
			returnStr.myChars[i] = Character.toUpperCase(myChars[i]);
		}
		
		return returnStr;
	}

}