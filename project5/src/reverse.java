// Name: Marwan El-Gabry
// Email: marwan.w.el-gabry@vanderbilt.edu
// VUnetid: elgabrmw
// Class: CS2201
// Date: 10/19/2025
// Honor statement: I attest that I have neither given nor received unauthorized aid concerning
//              this homework. I further acknowledge that the instructors are the copyright
//              owners of this HW.
// Description: Reverse a sound data file by reading in all the data samples,
// pushing them onto stacks, and then creating a new sound data
// file while popping values off the stacks.

import java.io.*;
import java.util.Scanner;


public class reverse {

    public static void main(String[] args) throws FileNotFoundException {

        // open input & output data files
        Scanner keyboard = new Scanner(System.in);
        Scanner infile = openInputFile(keyboard);
        PrintStream outfile = openOutputFile(keyboard);

        System.out.println("Reading the input file...");

        // read in the data on the first two lines of the file
        String firstLine, secondLine;

        firstLine = infile.nextLine();   // read in the first line
        secondLine = infile.nextLine();  // read in the second line

        DblStack inputTimeStack = new DblStack();
        DblStack soundStack = new DblStack();

        int i = 0;
        while(infile.hasNextDouble()) {
            double inDouble = infile.nextDouble();

            if (i % 2 == 0) {
                inputTimeStack.push(inDouble);
            } else {
                soundStack.push(inDouble);
            }
            i++;
        }


        System.out.println("There were " + i / 2 + " samples in the file.");
        System.out.println("Creating output file... wait for Done message.");


        DblStack outputTimeStack = new DblStack();

        while(!inputTimeStack.isEmpty()) {
            outputTimeStack.push(inputTimeStack.top());
            inputTimeStack.pop();
        }


        //
        // Now we are ready to output the data values to output file.
        // But first, we need to output the header lines
        //
        outfile.println(firstLine);
        outfile.println(secondLine);

        while (!outputTimeStack.isEmpty()) {
            outfile.printf("  %14.8g\t%10.6g\n", outputTimeStack.top(), soundStack.top());

            outputTimeStack.pop();
            soundStack.pop();
        }

        // close the files
        infile.close();
        outfile.close();

        System.out.println("Done");
    }


    /**
     * openInputFile -- open input file
     * @param keyboard -- Scanner object to read in file name
     * @return Scanner object opened on input file
     * @throws FileNotFoundException
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
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
     * openOutputFile -- open output file
     * @param keyboard -- Scanner object to read in file name
     * @return PrintStream object opened on output file
     * @throws FileNotFoundException
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
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