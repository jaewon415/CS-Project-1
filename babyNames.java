/* Jaewon Chang, CSE 142,
Winter 2014, Section EG
   Programming Assignment #6, 25th/February/2014

 This program's behavior is to find ranks and meaning of the baby's
name.
   And graphs the ranks of the particular name in every decade.*/

import java.util.*;
import java.awt.*;
import java.io.*;

public class BabyNames {
   public static final int HEIGHT = 30;
   public static final int YEAR = 1890;
   public static final int NUM_DECADE = 13;
   public static final int WIDTH = 60;
   
 public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
 Scanner input2 = new Scanner(new File("meanings.txt"));
      Scanner console = new Scanner(System.in);
      
      giveIntro();
      System.out.print("Name: ");
      String nameType = console.nextLine();
      String profile = find(input, nameType);
      foundProfile(profile, input2, nameType);
   }
   
   //This method gives brief introduction to the program.
   public static void giveIntro() {
 System.out.println("This program allows you to search through
the");
 System.out.println("data from the Social Security
Administration");
 System.out.println("to see how popular a particular name has
been");
      System.out.println("since " + YEAR + ".");
      System.out.println();
   }
   
 /* This method takes Scanners as a parameter. On the first run it
will take
 Scanner that scans the text with names and On the second run it will
take
 the Scanner that scans the meaning of names. And also it takes String
as
 a parameter, which user has inputed. This method returns the line if
found. */
   public static String find(Scanner type, String nameType) {
      while (type.hasNextLine()) {
         String line = type.nextLine();
         Scanner wordScan = new Scanner(line);
         if (nameType.equalsIgnoreCase(wordScan.next())) { 
            System.out.println(line);
            return line;
         }
      }
      return "";
   }
      
 /* This method takes Graphics and String as a parameter. The Graphics
is for
 the drawing panel and String meaning for the graph to print meaing on
the
      top left on the graph. */
   public static void graphOutLayer(Graphics g, String meaning) {
      for (int i = 0; i <= 1; i++) {
         g.setColor(Color.LIGHT_GRAY);
         g.fillRect(0, i * (500 + HEIGHT), 780, HEIGHT);
         g.setColor(Color.BLACK);
         g.drawLine(0, i * 500 + HEIGHT, 780, i * 500 + HEIGHT);
      }
      for (int i = 0; i < NUM_DECADE; i++) {
 g.drawString("" + (YEAR + (10 * i)), WIDTH * i, 492 + 2 *
HEIGHT);
      }
      g.drawString("" + meaning, 0, 16);
   }
   
 /* This method also takes Graphics and String as a parameter. The
Graphics is for
 the drawing panel and String is for the method to scan for the each
rank so that
 it could print out on the graph and also to get graph coordinate. */ 
   public static void graphWork(Graphics g, String profile) {
      Scanner data = new Scanner(profile);
      String name = data.next();
      String gender = data.next();
      for (int i = 0; i <= NUM_DECADE; i++) {
         if (data.hasNextInt()) {
            if (gender.equalsIgnoreCase("f")) {
               g.setColor(Color.PINK);
            } else {
               g.setColor(Color.BLUE);
            }
            int rank = data.nextInt();
            int yCoord = coordinate(rank);
 g.fillRect(i * WIDTH, yCoord, WIDTH / 2, 500 + HEIGHT - yCoord);
            g.setColor(Color.BLACK);
            g.drawString("" + rank, i * WIDTH, yCoord);
         }
      }
   }
   
 /* This method takes String profile to check for length and do some
work on grap
 and String nameType, which is typed by the user on the main. This
method do 
 something only and only if name is found and its length is bigger
than 0. */ 
 public static void foundProfile(String profile, Scanner input2,
String nameType) {
      if (profile.length() != 0) {
  meaning = find(input2,
nameType);
         DrawingPanel panel = new DrawingPanel(780, 500 + HEIGHT * 2);
         Graphics g = panel.getGraphics();
         graphOutLayer(g, meaning);
         graphWork(g, profile);
      } else {
 System.out.println("\"" + nameType + "\" not
found.");
      }
   }
   
   /* This method will cooperate with the grapWork method
 to draw graph when the value is 0 and to get coordinate for y. */
   public static int coordinate(int rank) {
      if (rank != 0) {
         return HEIGHT + (rank / 2);
      } else {
         return 500 + HEIGHT;
      }
   }
}
