// Jaewon Chang, CSE 142,
//Winter 2014, Section EG
// Programming Assignment #4, 4th/February/2014
//
// This program's behavior calculating GPA with scores earned.

import java.util.*;

public class Gradanator {
 public static final int MAX_EXAMSCOR = 100;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      introduction();
      double midScore = getExamScore(console, "Midterm:");
      double finScore = getExamScore(console, "Final:");
      double homeScore = getHomeScore(console);
      overAll(midScore, finScore, homeScore);
   }
   
 //This method gives brief information about what this program would
do.
   public static void introduction() {
 System.out.println("This program reads exam/homework
scores");
 System.out.println("and reports your overall course
grade.");
      System.out.println();
   }
   
   //This method calculates the score earned in the exams.
   //The parameter Scanner console is for the user to type.
   //The parameter String word decides whether it is midterm or final.
 //It returns examResult in this method for overAll method could use
it.
   public static double getExamScore(Scanner console, String word) {
      System.out.println(word);
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Score earned? ");
      int score = console.nextInt();
 System.out.print("Were scores shifted (1=yes, 2=no)? ");
      int answer = console.nextInt();
      
      int shift = 0;
      if (answer == 1) {
         System.out.print("Shift amount? ");
         shift = console.nextInt();
      }
      
      int examTotal = Math.min(shift + score, MAX_EXAMSCORE);
 
System.out.println("Total points = " + examTotal + " /
" + MAX_EXAMSCORE);
      double examResult = totalExamScore(examTotal, weight);
 System.out.printf("Weighted score = %.1f / " + weight +
"\n", examResult);
      System.out.println();
      return examResult;
   }
   
   //This method calculates weighed score for the exam.
 //Parameter examTotal is total point in exam and weight is user
input.
   //It returns the weighed point of the exam.
   public static double totalExamScore(int examTotal, int weight) {
      return (double) examTotal * weight / MAX_EXAMSCORE;
   }
   
   //This method calculates the points earned for the homework.
   //It takes Scanner console as a parameter to allow User to type.
   //It returns homeResult so that overAll method could use it.
   public static double getHomeScore(Scanner console) {
      int homeScore = 0;
 int maxScore = 20; //This is 20 because max section point is added.
      System.out.println("Homework:");
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Number of assignments? ");
      int count = console.nextInt();
      
      for (int i = 1; i <= count; i++) {
 System.out.print("Assignment " + i + " score and max?
");
         int numScore = console.nextInt();
         int numMax = console.nextInt();
         homeScore += numScore;
         maxScore += numMax;
      }
      
 System.out.print("How many sections did you attend? ");
      int section = console.nextInt();
      int sectionScore = Math.min(section * 3, 20);
      int maxHomePoint = Math.min(homeScore + sectionScore, maxScore);
      double homeResult = homePoint(maxHomePoint, weight, maxScore);
 System.out.println("Section points = " + sectionScore +
" / " + 20);
System.out.println("Total
points = " + maxHomePoint + " / " + maxScore);
 System.out.printf("Weighted score = %.1f / " + weight +
"\n", homeResult);
      System.out.println();
      return homeResult;
   }
   
   //This method calculates weighed score for the homework
   //It takes parameters of maxHomePoint, weight, maxScore.
 //The weight is user's input and maxHomePoint is total point earned
is homework.
 //The maxScore is for maximum total point of homework and it returns
weighed homework point.
 public static double homePoint(int maxHomePoint, int weight, int
maxScore) {
      return (double) maxHomePoint * weight / maxScore;
   }
   
   //This method outputs minimum gpa and the comments on the gpa.
   //It takes parameter of midScore, finScore, and homeScore.
 //The midScore, finScore, homScore is weighed point of midterm final
homework respectively.
 public static void overAll(double midScore, double finScore, double
homeScore) {
      double gpa = 0.0;
 //At the case when sum of weight exceed 100 might lead to percent
above 100.
      double percent = Math.min(midScore + finScore + homeScore, 100);
 String comment = "Please stop playing games, if you want to
succeed.";
 System.out.printf("Overall percentage = %.1f \n", percent);
      if (percent >= 85.0) {
         gpa = 3.0;
         comment = "Your are awesome and keep it up.";
      } else if (percent >= 75.0) {
         gpa = 2.0;
         comment = "You can do much better next time.";
      } else if (percent >= 60.0) {
         gpa = 0.7;
         comment = "Go to IPL or tutoring session.";
      }
 System.out.println("Your grade will be at least: " + gpa);
      System.out.println(comment);
   }
}
