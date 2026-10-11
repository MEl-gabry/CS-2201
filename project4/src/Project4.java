// File name: Project4.java
// Author: Marwan El-Gabry
// VUnetid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Date: 10/12/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//                  this homework.
//                  I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #4
// Description: writing recursive functions
// Last Changed:

// Recursive programming lab

// NOTE: your implementation of these functions must be recursive.
// NO LOOPS ARE ALLOWED, except where permitted by the header comments.
// Please read the project spec for other restrictions.

// NOTE: the functions in this file are not listed in any particular order.
// In particular, they are not listed easiest to hardest. You are not
// required to implement them in the order given, so jump around and do
// the easy ones, or the ones that make sense to you, first.

// NOTE: if for some reason you fail to complete a function listed here,
// please just leave the declaration with the provided dummy code. That will
// ensure our grading script will at least compile with your submission.

// NOTE: you should remove the TODO comment once you have implemented a function.
// Failure to do so will result in a style penalty.

public class Project4 {

    /**
     * Task: determine if target is in the set
     * Pre: set is an array of 'size' integers, size is non-negative
     * Post: true is returned if target is in the set, else false;
     *   the set is unchanged
     * Additional requirement: do not make new arrays
     */
    public static boolean member(int target, int[] set, int size) {
        if (size == 0) {
            return false;
        } else if (target == set[size - 1]) {
            return true;
        }

        return member(target, set, size - 1);
    }


    /**
     * Task: determine if a string is a palindrome
     * Pre: str is a string object
     * Post: returns true if str is a palindrome, otherwise returns false
     *       The test is case-insensitive [look up Character.toUpperCase() and
     *       Character.toLowerCase()]. You do not need to worry about
     *       trimming blanks from the ends of the string.
     * Note: the empty string is a palindrome
     */
    public static boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        } else if (str.length() == 1) {
            return true;
        } else if (Character.toUpperCase(str.charAt(0)) != Character.toUpperCase(str.charAt(str.length() - 1))) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }


    /**
     * Task: compute the sum of the first n harmonic terms
     * Pre: n is a positive integer
     * Post: the sum of the first n harmonic terms is returned.
     *  The harmonic series is 1 + (1/2) + (1/3) + (1/4) + ...
     */
    public static double harmonicSum(int n) {
        if (n == 1) {
            return 1;
        }

        return harmonicSum(n - 1) + ((double) 1 /n);
    }


    /**
     *  Task: Given a string, compute recursively a new string where all the adjacent
     *    chars are now separated by a "*".
     *  Pre: str is a string (it may be empty).
     *  Post: a correctly starred string is returned.
     *  Examples:
     *    addStar("hello") --> "h*e*l*l*o"
     *    addStar("abc") --> "a*b*c"
     *    addStar("ab") --> "a*b"
     */
    public static String addStar(String str) {
        if (str.length() == 0) {
            return str;
        } else if (str.length() == 1) {
            return str;
        }

        return str.charAt(0) + "*" + addStar(str.substring(1));
    }


    /**
     * Task: replace all occurrences of 'target' in the first 'size' elements of an 
     *       array 'numbers' with 'replacement'
     * Pre: 'numbers' is an array of at least 'size' integers, size is non-negative
     * Post: all occurrences of 'target' in 'numbers' have been replaced
     *       with 'replacement'; the number of replacements performed is
     *       returned to the caller.
     */
    public static int replace(int target, int replacement, int[] numbers, int size) {
        if (size == 0) {
            return 0;
        } else if (numbers[size - 1] == target) {
            numbers[size - 1] = replacement;
            return 1 + replace(target, replacement, numbers, size - 1);
        }

        return replace(target, replacement, numbers, size - 1);
    }


    /**
     *  Task: compute the average/mean of the first 'size' elements of an array of integers
     *  Pre: 'numbers' is an array of at least 'size' integers, size is non-negative
     *  Post: return the average/mean of the numbers in the array
     *  Note: the average of an empty array is zero. Compute this via
     *     direct recursion -- do not call sumArray().
     */
    public static double computeAverage(int[] numbers, int size) {
        if (size == 0) {
            return 0;
        }

        return (numbers[size - 1] + ((size - 1) * computeAverage(numbers, size - 1))) / size;
    }


    /**
     *  Task: compute the Greatest Common Divisor (GCD) of two non-negative
     *        integers using Euclid's formula:
     *
     *  Euclid's method for computing the greatest common divisor (GCD) of two
     *  non-negative integers a and b is as follows. Divide a by b to obtain the
     *  integer quotient q and remainder r, so that a = bq+r (if b = 0,
     *  then GCD(a, b) = a). Then GCD(a, b) = GCD(b, r). Replace a with b and
     *  b with r and repeat the procedure. Because the remainders are decreasing,
     *  eventually a remainder of 0 will result. The last nonzero remainder is
     *  the greatest common divisor of a and b.
     *
     *  Pre: the parameters x & y are non-negative
     *  Post: the GCD of x & y is returned
     */
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y , x % y);
    }


    /**
     *  Task: produce a string of num "Hello World"'s, where all the "Hello"'s precede
     *    all the "World"'s. For example:
     *    When num is 1, return "Hello World"
     *    When num is 3, return "Hello Hello Hello World World World"
     *    Note: there is only a single space between any two words, and there is
     *    no space at the beginning or end of the string
     *  Pre: num is a non-negative integer
     *  Post: the desired string is returned
     */
    public static String helloWorldRepeat(int num) {
        if (num == 0) {
            return "";
        } else if (num == 1) {
            return "Hello World";
        }

        return "Hello " + helloWorldRepeat(num - 1) + " World";
    }


    /**
     *  Task: produce the binary representation of a decimal number
     *    A decimal number is converted to binary by repeated
     *    division by 2. For each division, keep track of the quotient
     *    and remainder. The remainder becomes the low-order bit (rightmost
     *    bit) of the binary representation. The higher-order bits are
     *    determined by repeating the processes with the quotient.
     *    The process stops when num is either zero or one.
     *  Pre: num is a non-negative integer
     *  Post: the binary representation of num is produced and returned
     *    as a string.
     *  To convert an integer to a string you can use Integer.toString().
     */
    public static String convert2Binary(int num) {
        if (num == 0) {
            return "0";
        } else if (num == 1) {
            return "1";
        }

        return convert2Binary(num / 2) + num % 2;
    }


    /**
     *  Task: Print a pseudo hourglass pattern on the screen
     *  Pre: num is a positive integer
     *  Post: the desired pattern is displayed on the console (System.out)
     *  You may use iteration to print a line of *'s, but
     *  must use recursion to complete the pattern.
     *  Example: a call to printPattern(4) should produce the 7 line
     *  pattern below (excluding the lines of dashes):
     *  Each & every line you print should end with a newline character.
-------------------------
****
***
**
*
**
***
****
-------------------------
     */
    public static void printPattern(int num) {
        if (num == 1) {
            System.out.println("*");
            return;
        }

        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();

        printPattern(num - 1);

        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }


    /**
     *  Task: reverse a sentence
     *  Pre: 'sentence' is a string where words are separated by a single space ' ' character. The
     *    sentence has been trimmed, so there are no excess spaces at either end.
     *  Post: return a string that contains the words of the sentence in reverse order, still
     *    separated by a single space.
     *  Example: if the sentence is "I love to program.", return the string "program. to love I".
     *  Note: you may use the indexOf() or lastIndexOf() methods of the String class to find
     *    the first or last space character in the string (even though these methods use iteration).
     */
    public static String reverseSentence(String sentence) {
        int firstSpace = sentence.indexOf(" ");
        int lastSpace = sentence.lastIndexOf(" ");


        if (firstSpace == -1) {
            return sentence;
        } else if (firstSpace == lastSpace) {
            return sentence.substring(lastSpace + 1) + " "
                    + sentence.substring(0, firstSpace);
        }

        return sentence.substring(lastSpace + 1) + " "
                + reverseSentence(sentence.substring(firstSpace + 1, lastSpace)) + " "
                + sentence.substring(0, firstSpace);
    }


    /**
     *  Task: initialize all elements of the array between indices lb and ub to the
     *    given value, including the elements at lb & ub
     *  Note: lb = lower bound, ub = upper bound
     *  Pre: lb and ub are valid indices into the array a
     *  Post: the array elements in the segment a[lb...ub] have been initialized to value
     *  Additional requirement: This function must be done by dividing the array segment
     *    in half and performing recursive calls on each half (as opposed to just shrinking
     *    the array bound by one each time)
     */
    public static void arrayInitialize(int[] a, int value, int lb, int ub) {
        if (lb > ub) {
            return;
        }

        int mid = (lb + ub) / 2;

        a[mid] = value;

        arrayInitialize(a, value, lb, mid - 1);
        arrayInitialize(a, value, mid + 1, ub);
    }


    /**
     *  Task: Compute the Binomial Coefficient using Pascal's Triangle.
     *  The Binomial Coefficient B(n, r) is the coefficient of the term x^r in the binomial
     *  expansion of (1 + x)^n. For example, B(4,2) = 6 because (1+x)^4 = 1 + 4x + 6x^2 + 4x^3 + x^4
     *  The Binomial Coefficient can be computed using the Pascal Triangle formula:
     *     B(n, r) = 1                          if r = 0 or r = n
     *     B(n, r) = B(n-1, r-1) + B(n-1, r)    otherwise
     *  Pre: r & n are non-negative, and r<=n
     */
    public static int binomialCoeff(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        return binomialCoeff(n - 1, r - 1) + binomialCoeff(n - 1, r);
    }


    /**
     *  Task: Given the mapping a = "1", b = "2", ... z = "26", and an encoded message, count the
     *    number of ways it can be decoded.
     *  Pre: msg is string with a decodable message (it may be empty)
     *  Post: number of ways the message can be decoded is returned
     *  Example: the message "111" would give 3, since it could be decoded as "aaa", "ka", and "ak".
     *  You can assume that the messages are decodable. For example, "001" is not allowed.
     *  You may use iteration to enumerate all 26 possibilities for the next letter, but must use
     *  recursion to solve the problem. The function Integer.toString(int) will return a string
     *  representation of the int parameter.
     *  Note: an empty msg can only be decoded one way (it generates an empty string)
     */
    public static int numDecodes(String msg) {
        if (msg.length() == 0) {
            return 1;
        } else if (msg.length() == 1) {
            return 1;
        }

        int ways = 0;

        if (msg.charAt(0) - '0' <= 2 && msg.charAt(1) - '0' <= 6) {
            ways += numDecodes(msg.substring(2));
        }

        if (msg.charAt(1) - '0' != 0) {
            ways += numDecodes(msg.substring(1));
        }

        return ways;
    }


    /**
     *  Task: Given a string and a non-empty substring sub, compute recursively the number
     *    of times that sub appears in the string, without the sub strings overlapping.
     *  Pre: sub is a non-empty string
     *  Post: the count of non-overlapping occurrences of sub in str is returned
     *  Examples:
     *    countSubs("catcowcat", "cat") --> 2
     *    countSubs("catcowcat", "cow") --> 1
     *    countSubs("catcowcat", "dog") --> 0
     */
    public static int countSubs(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        } else if (str.substring(0, sub.length()).equals(sub)) {
            return 1 + countSubs(str.substring(sub.length()), sub);
        }

        return countSubs(str.substring(1), sub);
    }

    
    /**
     *  Task: Given a string, compute recursively a new string where all the lowercase 'x' chars
     *    have been moved to the end of the string.
     *  Pre: str is a string (possibly empty)
     *  Post: return a new string where all lowercase 'x' chars have been moved to the end
     *  Examples:
     *    moveXs("xxre") --> "rexx"
     *    moveXs("xxhixx") --> "hixxxx"
     *    moveXs("xhixhix") --> "hihixxx"
     */
    public static String moveXs(String str) {
        if (str.length() == 0) {
            return "";
        } else if (str.charAt(0) == 'x') {
            return moveXs(str.substring(1)) + str.charAt(0);
        }

        return str.charAt(0) + moveXs(str.substring(1));
    }


    /**
     *  Newton's method for approximating square roots.
     *  The next iteration is the average of the previous iteration and the
     *  ratio of the number in question to the previous iteration.
     *  In other words:
     *      x_i = ( x_(i-1) + number/x_(i-1) ) / 2
     *  if i is 0 the approximation is simply half the number.
     *  Pre: number & iterations are non-negative integers
     *  Post: return an approximation of sqrt(number)
     *  Note: number & iterations are integers, but the return value is double
     */
    public static double newton(int number, int iterations) {
        if (iterations == 0) {
            return (double) number / 2;
        }

        return (newton(number, iterations - 1)
                + (number / newton(number, iterations - 1))) / 2;
    }


    /**
     *  Task: There exists a staircase with N steps, and you can climb up either 1 or 2 steps
     *    at a time. Given N, return the number of unique ways you can climb the staircase.
     *    The order of the steps matters.
     *  Pre: n>0
     *  Post: The number of ways to climb the staircase is returned
     *  Example: If N is 4, then there are 5 unique ways:
     *       1, 1, 1, 1
     *       2, 1, 1
     *       1, 2, 1
     *       1, 1, 2
     *       2, 2
     */
    public static int uniqueSteps(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return uniqueSteps(n - 1) + uniqueSteps(n - 2);
    }


    /**
     *  Given an int array of size elements, determine if there are k elements that add up to sum.
     *  The array holds integers, both positive and negative and zero.
     *  It is not possible to add zero elements (that's when k==0) to any sum, not even zero.
     *  It is not possible to add any elements from an empty array.
     */
    public static boolean K_element_sum(int k, int sum, int[] arr, int size) {
        if (sum == 0 && k == 0) {
            return true;
        } else if (k == 0) {
            return false;
        } else if (size == 0) {
            return false;
        }

        return K_element_sum(k, sum, arr, size - 1)
                || K_element_sum(k - 1, sum - arr[size - 1], arr, size - 1);
    }


    /**
     *  Task: determine if each number in the array (except for the first element)
     *        is the square of the number before it
     *  Pre:  anArray is an array of at least 'size' integers, size is non-negative
     *  Post: true is returned if each number (except for the first element) is
     *        the square of the number before it, returns false otherwise. Also
     *        returns false if there are less than two elements in the array
     */
    public static boolean relatedSquares(int[] anArray, int size) {
        if (size == 0) {
            return false;
        } else if (anArray.length < 2) {
            return false;
        } else if (size == 1) {
            return true;
        }

        return (anArray[size - 1] == Math.pow(anArray[size - 2], 2))
                && relatedSquares(anArray, size - 1);
    }


    /**
     *  Definition of a Node for linked list problems
     *  DO NOT CHANGE THE DEFINITION OF THIS NODE
     */
    public static class Node {
        public int value;
        public Node next;
    }


    /**
     *  Task: Count the number of nodes with a nonzero value in a linked list
     *  Pre: head points to the first node of the list, or it is null if the list is empty
     *  Post: the number of nodes with a nonzero value in the linked list is returned, and
     *   the linked list is unchanged.
     */
    public static int numOfTerms(Node head) {
        if (head == null) {
            return 0;
        } else if (head.value == 0) {
            return numOfTerms(head.next);
        }

        return 1 + numOfTerms(head.next);
    }


    /**
     *  Task: Remove leading zeroes from a BigNum represented by a linked list.
     *  Pre: tmp refers to the first node of a list, or is null if the list is empty
     *  Post: returns a reference to the node that is the head of the altered list where
     *    all nodes at the end of the list which have a zero have been removed
     *  Note 1: as discussed in lecture, a BigNum stores the digits of the number in reverse
     *          order, with the ones digit at the front of the list. We are deleting
     *          leading zeroes, so they will appear at the end of the list
     */
    public static Node normalizeBigNum(Node tmp) {
        if (tmp == null) {
            return null;
        } else if (tmp.value != 0) {
            tmp.next = normalizeBigNum(tmp.next);
        } else if (normalizeBigNum(tmp.next) == null) {
            return null;
        }

        return tmp;
    }


    /**
     *  Task: Return a string of the contents of the linked list in forward order and then
     *     the same values in reverse order.
     *  Pre: tmp points to the first node of the list, or it is null if
     *   the list is empty
     *  Post: returns a string of the values of all nodes in the linked list in forward
     *   order, and then the same values in reverse order, with a single space after each
     *   and every value. The linked list is unchanged.
     *  Ex: if the list contains 1 2 3, we will return "1 2 3 3 2 1 "
     */
    public static String echo2(Node tmp) {
        if (tmp == null) {
            return "";
        }

        return tmp.value + " " + echo2(tmp.next) + tmp.value + " ";
    }


    /**
     *  Task: Find out whether a linked list 'subList' is contained within another
     *    linked list 'superList'
     *  Pre: superList and subList are head pointers to non-empty linked lists
     *  Post: Return true or false depending on whether subList is contained in superList
     *  A list is contained in another list if all the data elements appear in the
     *  same relative order. For example...
     *  If superList was 2->13->5->6->10->21 and subList was 13->5->10 then contains would be true.
     *  If superList was 2->13->5->6->10->21 and subList was 5->13->10 then contains would be false.
     *  If superList was 2->13->5->6->10 and subList was 13->7->10 then contains would return false.
     */
    public static boolean contains(Node superList, Node subList) {
        if (subList == null) {
            return true;
        } else if (superList == null) {
            return false;
        } else if (superList.value == subList.value) {
            return contains(superList.next, subList.next) || contains(superList.next, subList);
        }

        return contains(superList.next, subList);
    }



////////////////////////////////////////////
// CHALLENGE PROBLEM
//
// This problem is optional, and is for those who find recursive
// programming fun and interesting. This problem will not count
// against you if you do not attempt it or if you get it wrong.
// It also does not earn any extra credit if you get it right.
// It's just here for the challenge.
// If you do not attempt this challenge problem, just leave it here as is.
//
////////////////////////////////////////////

    /**
     *  Task: Reverse the nodes in a linked list.
     *  Pre: tmp points to the first node of the list, or it is null if the list is empty.
     *  Post: the list has been reversed and a reference to the new first node is returned.
     *  This must be accomplished without allocating any new nodes or deleting existing nodes.
     *  In fact, you should only change the 'next' field of each node.
     *  You must accomplish this task only with recursion and without any code to walk the list.
     */
    public static Node reverseList(Node tmp) {
        return new Node();  // TODO replace this with your solution
    }


}
