// Jaewon Chang, CSE 142,
//Winter 2014, Section EG
// Programming Assignment #1, 14th/January/2014
//
// This program's behavior is printing out the Culmulative Song.

public class Song {
   public static void main(String[] args) {
      firstVerse();
      secondVerse();
      thirdVerse();
      fourthVerse();
 fifthVerse();sticker: anchormansuccess.gif
      sixthVerse();
   }
   
   //This method prints series of lines for the first-verse.
   public static void firstVerse() {
 System.out.println("I once wrote a program that wouldn't
compile");
      lastTwo();
   }
   
   //This method prints lines for the second-verse.
   public static void secondVerse() {
      System.out.println("My program did nothing");
      System.out.println("So I started typing.");
      same3();
   }
   
   //This method prints lines for the third-verse.
   public static void thirdVerse() {
 System.out.println("\"Parse error,\" cried the
compiler");
      System.out.println("Luckily I'm such a code baller.");
      same();
   }
   
   //This method prints lines for the fourth-verse.
   public static void fourthVerse() {
 System.out.println("Now the compiler wanted an
identifier");
 System.out.println("And I thought the situation was getting
dire.");
      same2();
   }
   
   //This method prints lines for the fifth-verse.
   public static void fifthVerse() {
 System.out.println("Java complained it expected an enum");
 System.out.println("Boy, these computers really are
dumb!");
      same1();
   }
   
   //This method prints lines for the fifth-verse.
   public static void sixthVerse() {
 System.out.println("The program was missing a curly bracket on
the first line");
 System.out.println("Hopping that it would be the last error and
would work fine");
      same4();
   }
   
   //This method prints total of six lines.
   public static void same1() {
 System.out.println("I added a public class and called it
Scum,");
      same2();
   }
   
   //This method prints the total of five lines.
   public static void same2() {
 System.out.println("I added a main method with its String[]
args,");
      same();
   }
   //This method prints total of four lines.
   public static void same() {
 System.out.println("I added a backslash to escape the
quotes,");
      same3();
   }
   
   //This method prints total of three lines.
   public static void same3() {
 System.out.println("I added System.out.println(\"I <3
coding\"),");
      lastTwo();
   }
   
   //This method prints total of seven lines.
   public static void same4() {
 System.out.println("I added a curly bracket next to the name of
program");
      same1();
   }
   
   //The Last two sentences that appear on every verse.
   public static void lastTwo() {
 System.out.println("I don't know why it wouldn't
compile,");
      System.out.println("My TA just smiled.");
      System.out.println();
   }
}
