// File name: StringJrDemo.java
// Description: This simple program lets us play with the StringJr class. [Not graded]

public class StringJrDemo {

    public static void main(String[] args) {
        // Creating instances of StringJr
        StringJr str1 = new StringJr("Hello");
        StringJr str2 = new StringJr("World");

        // Calling StringJr methods   
        System.out.println("str1 is " + str1);
        System.out.println("str2 is " + str2);
        				
        System.out.println(str1 + " length: " + str1.length());
        System.out.println(str2 + " length: " + str2.length());

        System.out.println(str1 + " is empty: " + str1.isEmpty());
        System.out.println(str2 + " is empty: " + str2.isEmpty());

        System.out.println("Character at index 1 in " + str1 + ": " + str1.charAt(1));

        System.out.println("Index of 'o' in " + str2 + ": " + str2.indexOf('o'));

        System.out.println("Last index of 'l' in " + str1 + ": " + str1.lastIndexOf('l'));

        System.out.println("Substring of " + str1 + " from index 1: " + str1.substring(1));
        
        System.out.println("Substring of " + str1 + " from index 1 to 4: " + str1.substring(1, 4));
        
        System.out.println(str1 + " is equal to " + str2 + ": " + str1.equals(str2));

        System.out.println(str1 + " is equal to " + str2 + " (ignore case): " + str1.equalsIgnoreCase(str2));
        
        StringJr str3 = new StringJr("hello");
        System.out.println(str1 + " is equal to " + str3 + ": " + str1.equals(str3));
        System.out.println(str1 + " is equal to " + str3 + " (ignore case): " + str1.equalsIgnoreCase(str3));

        System.out.println(str1 + " converted to lowercase is: " + str1.toLowerCase());
        System.out.println(str1 + " converted to uppercase is: " + str1.toUpperCase());
    }
}