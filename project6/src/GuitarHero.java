// File name: GuitarHero.java
// Author: Marwan El-Gabry
// userid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #6
// Description: Converts GuitarString txt file to dat file
// Last Changed: 10/27/2025
//

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;


public class GuitarHero {

    public static final double CONCERT_A = 440.0;
    public static final int NUM_STRINGS = 37;
    public static final double STEP = (double)1/((double)GuitarString.SAMPLE_RATE);
    public static final int END_OF_SONG = -1;


    public static void main(String[] args) throws FileNotFoundException {

        // create the array of guitar strings (3 octaves)
        GuitarString[] strings = new GuitarString[NUM_STRINGS];
        createStrings(strings);

        //open data file
        Scanner keyboard = new Scanner(System.in);
        Scanner infile = openInputFile(keyboard);
        PrintStream outfile = openOutputFile(keyboard);

        //prime the output file
        String firstLine  = "; Sample Rate " + GuitarString.SAMPLE_RATE;
        String secondLine = "; Channels 1";
        outfile.println(firstLine);
        outfile.println(secondLine);

        System.out.println("Reading the input file and generating a .dat file for sox");

        double timeStamp = infile.nextDouble();

        checkChronological(0, timeStamp);

        int stringToPlay = infile.nextInt();

        checkInStringRange(stringToPlay);

        for (double time = 0; time < 44100 && infile.hasNextLine() && stringToPlay != -1;
             time += (double) 1 /44100) {
            if (time < timeStamp) {
                double soundValue = sampleAndTic(strings);
                outfile.printf("  %14.8g\t%10.6g\n", time, soundValue);
            } else {
                checkInStringRange(stringToPlay);

                strings[stringToPlay].pluck();
                double tempTimeStamp = infile.nextDouble();

                checkChronological(timeStamp, tempTimeStamp);

                timeStamp = tempTimeStamp;
                stringToPlay = infile.nextInt();

                System.out.print(".");
            }
        }


        // close the files
        infile.close();
        outfile.close();

        System.out.println("Done.");
    }


    /**
     * checkInStringRange
     * Check if index is range of the number of strings
     * pre: An int index is passed in
     * post: Throws RunTimeException if string index < -1 or >= NUM_STRINGS
     */
    private static void checkInStringRange(int index) {
        if (index < -1 || index >= NUM_STRINGS) {
            throw new RuntimeException("Invalid string.");
        }
    }


    /**
     * checkChronological
     * Check if a pair of time indices are in chronological order
     * pre: An double prev representing the previous timestamp is passed in and a double cur
     * representing the current timestamp is passed in
     * post: Throws RunTimeException if cur < prev
     */
    private static void checkChronological(double prev, double cur) {
        if (cur < prev) {
            throw new RuntimeException("Time stamps not chronological.");
        }
    }


    /**
     * sampleAndTic
     * Samples and tics every string
     * pre: An array of GuitarStrings strings is passed in
     * post: Every string in the array is sampled and ticked. The sum of the samples is returned.
     */
    private static double sampleAndTic(GuitarString[] strings) {
        double soundValue = 0;
        for (GuitarString string : strings) {
            soundValue += string.sample();
            string.tic();
        }

        return soundValue;
    }


    /**
     * createStrings -- create the guitar string objects
     * post: array of GuitarString objects have been created and initialized
     * @param strings
     */
    private static void createStrings(GuitarString[] strings) {
        for (int i = 0; i < strings.length; i++) {
            double factor = Math.pow(2.0, (i - 24) / 12.0);
            strings[i] = new GuitarString(CONCERT_A * factor);
        }
    }


    /**
     * openInputFile
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     * @param keyboard -- opened Scanner object
     * @return Scanner object opened on input file
     * @throws FileNotFoundException
     */
    private static Scanner openInputFile (Scanner keyboard) throws FileNotFoundException {

        // open input data file
        String inFileName;
        System.out.print("Enter the name of the input file: ");
        inFileName = keyboard.nextLine();
        File f = new File(inFileName);
        while (!f.canRead()) {
            System.out.println("File not found. Try again.");
            System.out.print("Enter the name of the input file: ");
            inFileName = keyboard.nextLine();
            f = new File(inFileName);
        }
        Scanner infile = new Scanner(f);
        return infile;
    }


    /**
     * openOutputFile
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     * @param keyboard -- opened Scanner object
     * @return PrintStream object opened on output file
     * @throws FileNotFoundException
     */
    private static PrintStream openOutputFile (Scanner keyboard) throws FileNotFoundException {

        // open output data file
        String outFileName;
        System.out.print("Enter the name of the output file: ");
        outFileName = keyboard.nextLine();
        File f2 = new File(outFileName);
        PrintStream outfile = new PrintStream(f2);
        return outfile;
    }

}
