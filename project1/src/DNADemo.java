// This is a class that contains a main() program for you to experiment with the DNA_Strand class

public class DNADemo {
    public static void main(String[] args) {

        DNA_Strand myStrand = new DNA_Strand("abcd");
        System.out.println(myStrand);

        // test some basic functions of the DNA_Strand class

        DNA_Strand dna_1 = new DNA_Strand(), dna_2=new DNA_Strand();

        if (dna_1.size() != 0)
            System.out.println(  "Test 1 FAIL"  );

        if (!dna_1.equals(dna_2))
            System.out.println(  "Test 2 FAIL"  );

        if (!dna_2.equals(dna_1))
            System.out.println(  "Test 3 FAIL"  );


        // create a non-empty DNA
        DNA_Strand dna = new DNA_Strand("ABCCTG");

        //toString should return the contents as a string
        if(dna.toString().compareTo("ABCCTG")!=0)
            System.out.println("Test 4 FAIL");

        String ipStr = "ABCCTG";
        DNA_Strand dna1 = new DNA_Strand(ipStr);
        if(!dna.equals(dna1))
            System.out.println("Test 5 FAIL");
        if(dna.size()!=6)
            System.out.println("Test 6 FAIL");

        dna1.set(4, 'T');
        if(dna1.get(4)!='T')
            System.out.println("Test 7 FAIL");

        System.out.println(  "Done testing"  );

    }
}