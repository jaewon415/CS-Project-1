// Jaewon Chang, CSE 142,
// Winter 2014, Section EG
// Programming Assignment #2 Part B, 21st/January/2014
//
// This program's behavior is printing out the Space Needle.

public class SpaceNeedle {
   public static final int SUB_SIZE = 4;
   public static void main(String[] args) {
      drawLine();
      drawTop();
      drawBottom();
      drawLine();
      drawMiddle();
      drawTop();
   }
   
   //This method prints the mountatin shaped roof of the diagram.
   public static void drawTop() {
      for (int line = 1; line <= SUB_SIZE; line++) {
 for (int space = 1; space <= 3 * SUB_SIZE - 3 * line; space++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         for (int dots = 1; dots <= 3 * line - 3; dots++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int dots = 1; dots <= 3 * line - 3; dots++) {
            System.out.print(":");
         }
         System.out.println("\\__");
      }
      drawQuotes();
   }
   
   //This method prints a line of quotes.
   public static void drawQuotes() {
      System.out.print("|");
      for (int slash = 1; slash <= 6 * SUB_SIZE; slash++) {
         System.out.print("\"");
      }
      System.out.println("|");;
   }
   
   //This method prints thin vertical lines.
   public static void drawLine() {
      for (int line = 1; line <= SUB_SIZE; line++) {
         for (int space = 1; space <= 3 * SUB_SIZE; space++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
   //This method prints thick and long part of the diagram.
   public static void drawMiddle() {
      for (int line = 1; line <= SUB_SIZE * SUB_SIZE; line++) {
 for(int space = 1;
space <= 2 * SUB_SIZE + 1; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
 for(int mod = 1;
mod <= SUB_SIZE - 2; mod++) {
            System.out.print("%");
         }
         System.out.print("||");
 for(int mod = 1; mod <= SUB_SIZE -
2; mod++) {
            System.out.print("%");
         }
         System.out.println("|");
      }
   }
   
   //This method prints inverted mountain shaped roof of the diagram.
   public static void drawBottom() {
      for (int line = 1; line <= SUB_SIZE; line++) {
         for (int space = 1; space <= 2 * line - 2; space++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
 for (int slashes = 1; slashes <= 3 * SUB_SIZE - 2 * line + 1;
slashes++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
}
