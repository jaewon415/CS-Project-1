// Jaewon Chang, CSE 142,
//Winter 2014, Section EG
// Programming Assignment #5, 11th/February/2014
//

import java.util.*;

public class GuessingGame {
   public static final int RANGE = 6;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      
      introduction();
      
      int gamePlayed = 1;
      int numPlayed = playGame(console, rand);
      int totalGuess = numPlayed;
      int bestGame = numPlayed;
      
      System.out.print("Do you want to play again? ");
      String answer = console.next();
      
 while (answer.startsWith("Y") ||
answer.startsWith("y")) {
         numPlayed = playGame(console, rand);
         totalGuess += numPlayed;
         gamePlayed++;
         
         if (numPlayed < bestGame) {
            bestGame = numPlayed;
         }
         
         System.out.print("Do you want to play again? ");
         answer = console.next();
      }
      results(totalGuess, gamePlayed, bestGame);
   }
   
   //This method prints te brief introduction of the game.
   public static void introduction() {
      System.out.println("This is a guess game");
      System.out.println("It is very fun to play");
      System.out.println("Please enjoy this game.");
   }
   
   //This method is for playing game once.
 //Takes a parameter of Scanner console for user to type and random
for random number.
   public static int playGame(Scanner console, Random rand) {
      int count = 1;
      
      System.out.println();
      int random = rand.nextInt(RANGE) + 1;
 System.out.println("I'm thinking of a number between 1 and
" + RANGE + "...");
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      while (guess != random) {
         if (guess > random) {
 System.out.println("It's Lower.");
 } else if (guess
< random) {
 System.out.println("It's Higher.");
         }
         System.out.print("Your guess? ");
         guess = console.nextInt();
count++;
      }
      if (count == 1) {
 System.out.println("You got it right in " + count + "
guess!");
      } else {
 System.out.println("You got it right in " + count + "
guesses!");
      }
      return count;
   }
   
   //Rounds n to 1 digit after the decimal point.
 //It takes any double value as a paramter to round it into one
decimal.
   public static double round1 (double n) {
      return Math.round(n * 10.0) / 10.0;
   }
   
   /*This method prints the result of the game.
   The parameter gamplayed count how many time game was played.
   The parameter totalGuess counts total guess made in whole game.
 The parameter bestgame decides which game had a less value of
guesses.*/
 public static void results(int totalGuess, int gamePlayed, int
bestGame) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gamePlayed);
      System.out.println("Total guesses = " + totalGuess);
 System.out.println("Guesses/game = " + round1((double)
totalGuess / gamePlayed));
      System.out.println("Best game     = " + bestGame);
   }
}
