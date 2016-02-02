/* Jaewon Chang, CSE 142,
Winter 2014, Section EG
   Programming Assignment #7, 4th/March/2014

   This program's behavior is to read file with named sequences
   of Nucleotides and provide the information about the Nucleotides.
   Informations such as percent mass of nucleotides in the sequence or
   whether the sequence contains protein inside or not.  */

import java.util.*;
import java.io.*;

public class DNA {
   public static final int MINIMUM = 5;
 public static final double PERCENT = 30.0;
   public static final int UNIQUE = 4;
 public static final int PERCONDON = 3;
 public static final double[] MASS = {135.128, 111.103, 151.128,
125.107, 100.000};
   
 public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      
      giveIntro();
      System.out.print("Input file name? ");
      String inputName = console.nextLine();
      System.out.print("Output file name? ");
      String outputName = console.nextLine();   
      Scanner input = new Scanner(new File(inputName));
      PrintStream out = new PrintStream(new File(outputName));
      getResult(input, out);
   }
   
   //This method gives brief introduction of this program.
   public static void giveIntro() {
 System.out.println("This program reports information about
DNA");
 System.out.println("nucleotide sequences that may encode
proteins.");
   }
   
   /* This method takes String as a parameter to count each character.
 This method returns the array with numbers of each nucleotides in
each box.*/
   public static int[] getGene(String nucleotides) {
      int[] countElement = new int[UNIQUE + 1];
      for (int i = 0; i < nucleotides.length(); i++) {
         int index = "ACGT-".indexOf(nucleotides.charAt(i));
         countElement[index]++;
      }
      return countElement;
   }
   
 /* The parameter countElement to calculate the total Mass in the
sequence.
      And return those totalmass in of the sequence of nucleotides. */
   public static double totalSum(int[] countElement) {
      double totalMass = 0;
      for (int i = 0; i < countElement.length; i++) {
         totalMass += countElement[i] * MASS[i];
      }
      return totalMass;
   }
   
 /* This method takes String nucleotides as a parameter and forms
condon.
      returns the stored condon in a form of string array. */
   public static String[] getCondon(String nucleotides) {
      nucleotides = nucleotides.replace("-", "");
 String[] condonList = new String[nucleotides.length() / PERCONDON];
      for (int i = 0; i < nucleotides.length(); i += PERCONDON) {
         String condonName = nucleotides.substring(i, i + PERCONDON);
         condonList[i / PERCONDON] = condonName;
      }
      return condonList;
   }
   
   /* This method condonList and array of masspercent as a paramter.
      returns string in a form of yes or no.*/
 public static String answerType(String[] condonList, double[]
massPercent) {
      String answer = "NO";
 String[] protein = {"TGA", "TAA",
"TAG"};
 if (condonList[0].equals("ATG") &&
condonList.length >= MINIMUM) {
 if (massPercent[1] + massPercent[2] >= PERCENT) { // 1 equals C
and 2 equals G 
            for (int i = 0; i < protein.length; i++) { 
 if (condonList[condonList.length - 1].equals(protein[i])) {
                  answer = "YES";
               }
            }
         }
      }
      return answer;
   }

 /* This method takes two arrays as the parameters. This method to
calculate
 percent of each nucleotides in the sequence. And returns the double
array. */
 public static double[] getPercent(int[] countNucleo, double
totalMass) {
      double[] massPercent = new double[UNIQUE];
      for (int i = 0; i < massPercent.length; i++) {
         massPercent[i] = Math.round((countNucleo[i] * MASS[i] * 100
                                     / totalMass) * 10.0) / 10.0;
      }
      return massPercent;
   }

 /* This method takes Scanner input and PrintStream as parameter. This
method 
      gives the result of the nucleotide sequences in output file. */
public static void getResult(Scanner input,
PrintStream out) {
      while (input.hasNextLine()) {
         out.println("Region Name: " + input.nextLine());
         String nucleotides = input.nextLine().toUpperCase();
         out.println("Nucleotides: " + nucleotides);        
         int[] countElement = getGene(nucleotides);        
         int[] countNucleo = Arrays.copyOf(countElement, UNIQUE);
 out.println("Nuc. Counts: " +
Arrays.toString(countNucleo)); 
         double totalMass = totalSum(countElement);
         double[] massPercent = getPercent(countNucleo, totalMass);
 out.println("Total Mass%: " + Arrays.toString(massPercent)
 + " of " + Math.round(totalMass * 10.0) / 10.0);
         String[] condonList = getCondon(nucleotides);
 out.println("Codons List: " + Arrays.toString(condonList));
 out.println("Is Protein?: " + answerType(condonList,
massPercent));
         out.println();
      }
   }
}
