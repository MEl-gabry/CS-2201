// File name: WordCount.java
// Author: Marwan El-Gabry
// userid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #8
// Description: Determine the similarity in word usage between two text files.
// Last Changed: 11/12/2025
//


import java.io.*;
import java.util.*;

/**
 * This class compares two text files and computes their Euclidean
 * distance based on the frequency of words appearing in both texts.
 * It reads in two input files, processes them by counting the
 * frequency of words and ignoring common words, and then calculates
 * the Euclidean distance between the word frequencies in the two
 * texts. It also writes the comparison results to an output file,
 * which includes the distance, scores, and frequency information for
 * each word used in the comparison.
 * <p>
 * The WordCount class contains several methods that
 * perform different operations, such as reading common words from a
 * file, processing input files, calculating word frequencies, and
 * computing the Euclidean distance between the two texts.
 */
public class WordCount {

    /**
     * This field sets a threshold for the minimum percentile
     * appearance of words in the texts that will be considered in the
     * Euclidean distance calculation.  Words with a percentile
     * appearance below this value in either text will be ignored in
     * the distance calculation, ensuring that only words with a
     * significant presence in both texts contribute to the
     * comparison.
     */
    private static final double MINIMUM_APPEARANCE = 0.001;

    /**
     * The maximum stem length of the word.
     */
    private static final int STEM_LENGTH = 6;

    /**
     * The file containing common words to ignore.
     */
    private static final String COMMON_FILE = "texts/common.txt";

    /**
     * The main entry point into the program.
     * <p>
     * @param args The command-line arguments
     * DO NOT CHANGE THIS METHOD IN ANY WAY
     */
    public static void main(String[] args) {
        // The user's response to running the program again.
        String userResponse;

        // Create a Scanner to get user input from the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        do {
            System.out.print("Enter name of the first input file: ");
            String firstInput = "texts/" + keyboard.next();

            System.out.print("Enter name of the second input file: ");
            String secondInput = "texts/" + keyboard.next();

            System.out.print("Enter name of the output file: ");
            String outputFile = "texts/" + keyboard.next();

            // Read the common words to ignore.
            Set<String> commonWords = readCommonWords(COMMON_FILE);

            // Read and process the first file.
            Map<String, Integer> firstMap = processFile(firstInput, commonWords);

            // Read and process the second file.
            Map<String, Integer> secondMap = processFile(secondInput, commonWords);

            // Compute the vector distance of the two texts and
            // store the results into 'outputFile'.
            double dist = compareTexts(firstMap, secondMap, outputFile);

            System.out.println("Vector Distance: " + dist);
            
            System.out.print("Would you like to run the program again (Y|N): ");
            userResponse = keyboard.next();
        } while (userResponse.toLowerCase().charAt(0) == 'y');

    }


    /**
     * readCommonWords
     * Reads the contents of the specified file and returns a Set of common 
     * English-language words. If the input file cannot be opened, prints an
     * error message and then throws a RuntimeException.
     * <p>
     * @param filename The name of the File to read
     * @return A Set of words in filename
     * DO NOT CHANGE THIS METHOD'S HEADER IN ANY WAY
     */
    public static Set<String> readCommonWords(String filename) {
        // Create a HashSet to store the common words.
        Set<String> commonWords = new HashSet<>();

        Scanner infile = openInputFile(filename);

        while (infile.hasNextLine()) {
            commonWords.add(infile.nextLine());
        }

        infile.close();

        // Return the Set containing common words.
        return commonWords;
    }


    /**
     * processFile
     * Processes an input file and returns a Map of words and
     * their frequencies. If the input file cannot be opened, prints an
     * error message and then throws a RuntimeException.
     * <p>
     * @param filename The name of the file to process
     * @param common   The Set of common words to ignore
     * @return A Map of words and their frequencies
     * DO NOT CHANGE THIS METHOD'S HEADER IN ANY WAY
     */
    public static Map<String, Integer> processFile(String filename, Set<String> common) {
        // Create a Map to store the word frequencies.
        // Utilize a TreeMap so that all the words are kept in sorted order.
        Map<String, Integer> wordFrequencies = new TreeMap<>();

        Scanner infile = openInputFile(filename);

        while (infile.hasNext()) {
            String word = infile.next();

            word = word.toLowerCase();
            word = word.replaceAll("[^A-Za-z]", "");

            if (word.length() > STEM_LENGTH) {
                word = word.substring(0, STEM_LENGTH);
            }

            if (!common.contains(word) && !word.isEmpty()) {
                if (wordFrequencies.containsKey(word)) {
                    wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                } else {
                    wordFrequencies.put(word, 1);
                }
            }
        }

        infile.close();

        // Return the word frequencies.
        return wordFrequencies;
    }


    /**
     * compareTexts
     * Compare the count maps of 2 texts and return the Euclidean
     * distance, where each word with a percentile appearance greater
     * than MINIMUM_APPEARANCE counts as a dimension of the vectors.
     * (they still count toward the full sum used to calculate
     * percentile appearance).
     * <p>
     * This method also prints out the results to a file using the
     * following format (start and end tags added for clarity):
     * / -- start example output --/
     *   word1: distance = x.xxxxxE-x (score1 = y.yyyyyyyy, score2 = z.zzzzzzz)
     *   word2: distance = x.xxxxxE-x (score1 = y.yyyyyyyy, score2 = z.zzzzzzz)
     * ...
     *   wordN: distance = x.xxxxxE-x (score1 = y.yyyyyyyy, score2 = z.zzzzzzz)
     *
     * Counted words in document 1 = xxxx
     * Counted words in document 2 = xxxx
     *
     * Vector Distance: dist
     * /-- end example output --/
     * <p>
     * word1-wordN are all words whose comparison is included in the
     * final sum.  distance values are the square of the difference of
     * the percentile scores from the two maps.
     * score1 and score2 values are the scores from the two maps.
     * dist is the final distance that is also returned, it is the
     * square root of the sum of all the individual distances.  
     * To help line things up, you are required to use the printf() statement
     * given in the project specification. 
     * <p>
     * pre: Two maps of texts to be compared and the name of an output file.
     * post: Returns the Euclidean distance of the two files. If the
     * output file cannot be opened, the method prints an error
     * message and throws a RuntimeException.
     * <p>
     * @param first    The first Map of words and their frequencies
     * @param second   The second Map of words and their frequencies
     * @param filename The name of the file to write the results to
     * @return The distance between the two Map objects
     * DO NOT CHANGE THIS METHOD'S HEADER IN ANY WAY
     */
    public static double compareTexts(Map<String, Integer> first,
                                      Map<String, Integer> second,
                                      String filename) {

        LinkedHashMap<String, Integer> firstHash = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> secondHash = new LinkedHashMap<>();

        int firstTotalCount = traverseFileMap((TreeMap<String, Integer>) first,
                firstHash);
        int secondTotalCount = traverseFileMap((TreeMap<String, Integer>) second,
                secondHash);

        double sum = 0;

        Set<Map.Entry<String, Integer>> firstEntries = firstHash.entrySet();

        PrintStream outfile = openOutputFile(filename);

        for (Map.Entry<String, Integer> entry : firstEntries) {
            String word = entry.getKey();
            int count1 = entry.getValue();

            if (secondHash.containsKey(word)) {
                int count2 = secondHash.get(word);

                double score1 = (double) count1 / firstTotalCount;
                double score2 = (double) count2 / secondTotalCount;

                if (score1 > MINIMUM_APPEARANCE && score2 > MINIMUM_APPEARANCE) {
                    double distance = Math.pow(score1 - score2, 2);

                    outfile.printf("%6s: distance = %12.10e (score1 = %10.8f, score2 = %10.8f)\n",
                            word, distance, score1, score2);

                    sum += distance;
                }
            }
        }

        double vectorDistance = Math.sqrt(sum);

        outfile.println();

        outfile.println("Counted words in document 1 = " + firstTotalCount);
        outfile.println("Counted words in document 2 = " + secondTotalCount);

        outfile.println();

        outfile.print("Vector Distance:" + vectorDistance);

        outfile.close();

        return vectorDistance;
    }


    /**
     * openInputFile -- open input file
     * @param filename -- File name
     * @return Scanner object opened on input file
     * @throws RuntimeException
     * pre: a valid filename has been passed in
     * post: file have been opened
     */
    private static Scanner openInputFile (String filename) {
        try {
            File f = new File(filename);
            Scanner infile = new Scanner(f);
            return infile;
        } catch (FileNotFoundException e) {
            System.out.println(filename + " was not found!");
            throw new RuntimeException();
        }
    }


    /**
     * openOutputFile -- open output file
     * @param filename -- File name
     * @return PrintStream object opened on output file
     * @throws RuntimeException
     * pre: a valid filename has been passed in
     * post: file have been opened
     */
    private static PrintStream openOutputFile (String filename) {
        try {
            File f = new File(filename);
            PrintStream outfile = new PrintStream(f);
            return outfile;
        } catch (FileNotFoundException e) {
            System.out.println(filename + " was not found!");
            throw new RuntimeException();
        }
    }


    /**
     * traverseFileMap -- traverse through file map and fill linked hashmap with its data
     * @param fileMap -- TreeMap with words and counts from file
     * @param hashMap -- Empty LinkedHashMap
     * @return The sum of all counts in fileMap
     * pre: a valid fileMap with data from a text file and an empty hashMap has been passed in
     * post: hashMap now ahs contents of fileMap and the sum of all counts in fileMap is returned
     */
    private static int traverseFileMap(TreeMap<String, Integer> fileMap,
                                       LinkedHashMap<String, Integer> hashMap) {
        Set<Map.Entry<String, Integer>> entries = fileMap.entrySet();

        int totalCount = 0;

        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            int count = entry.getValue();

            hashMap.put(word, count);

            totalCount += count;
        }

        return totalCount;
    }
}
