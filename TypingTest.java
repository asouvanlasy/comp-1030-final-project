/* This class holds every variable and method for the game to function.
 * Andrew Souvanlasy
 * Created on October 22, 2021 @ 4:11 PM
*/

import java.util.Scanner;
import java.time.*;
import java.text.DecimalFormat;

public class TypingTest {

  // Declare variables
  String wordInput;
  float elapsedTimeSecs;
  float totalTime;
  byte points;
  byte wordsCorrect;

  // Create an array of 50 strings
  String[] wordArray = {"sodium", "bring", "tension", "understand", "watch",
                        "password", "earthflax", "chicken", "die", "appointment",
                        "shortage", "flesh", "contrary", "drain", "writer",
                        "cheat", "radiation", "destruction", "ivory", "fence",
                        "virtual", "jury", "woman", "bag", "tropical",
                        "neglect", "appoint", "attack", "light", "photocopy",
                        "plant", "gloom", "execute", "jockey", "dozen",
                        "final", "spy", "farewell", "exceed", "orchestra",
                        "cupboard", "dignity", "expose", "employee", "diagram",
                        "supply", "difference", "lick", "meet", "analyst"};

  Scanner in = new Scanner(System.in); // Create scanner
  DecimalFormat formatter = new DecimalFormat("0.00"); // Set the decimal format


  
  public void gameIntro() { // Method to display opening text
    System.out.println("Welcome to TypingTest!");
    System.out.println("In this game, you will type a series of words as fast as possible, while also spelling each correctly.");
    System.out.println("This includes matching lettercase, so type the word exactly as it appears.");
    System.out.println("When you are ready, type START.");

    while(true) { // This while loop will keep checking if input is "START"
      if (in.nextLine().equals("START")) {
        System.out.println("Starting...");
        break;
      }
      else {
        System.out.println("You typed START incorrectly. Be sure to type in the same lettercase.");
        System.out.println("Try typing START again.");
      }
    }
  }


  
  public void gameMain() {
    while(true) { // While loop enables the game to be replayed
      for (int i = 0; i < wordArray.length; i++) { // Loop runs through wordArray for words to type
        System.out.println("---------------"); // Print this to separate each loop stage
        System.out.println("Word " + (i + 1)); // Print which word they're on, and i + 1 so it doesn't begin at 0 index
        System.out.println(wordArray[i]); // Print index word


  
        // Time keeping
        Instant start = Instant.now(); // Start stopwatch
        wordInput = in.nextLine(); // Keyboard input
        Instant end = Instant.now(); // End stopwatch


  
        // Calculating time
        Duration elapsedTime = Duration.between(start, end); // Calculate stopwatch time
        elapsedTimeSecs = elapsedTime.toMillis(); // Convert elapsedTime to milliseconds and float
        elapsedTimeSecs = elapsedTimeSecs / 1000; // Convert to seconds
        System.out.println(formatter.format(elapsedTimeSecs) + " seconds"); // Print formatted stopwatch time
        totalTime = totalTime + elapsedTimeSecs; // Calculate total stopwatch time. Each iteration will add to the sum
        


        // Spell checking
        if (wordInput.equals(wordArray[i])) { // If word is spelt correctly;
          points++; // Award 1 point
          wordsCorrect++; // Increment (no decrement in else, because only correct words should be tallied)
          System.out.println("+1 points!"); // Print point result
        }
        else { // If word is spelt incorrectly;
          points--; // Remove 1 point
          System.out.println("-1 points!"); // Print point result
        }
      }

      // Calculate point grade
      char grade;
      if (points == 50) {
        grade = 'S';
      }
      if (points >= 45) {
        grade = 'A';
      }
      if (points >= 40) {
        grade = 'B';
      }
      if (points >= 30) {
        grade = 'C';
      }
      if (points >= 20) {
        grade = 'D';
      }
      if (points >= 10) {
        grade = 'E';
      }
      else {
        grade = 'F';
      }

      System.out.println("---------------");
      System.out.println("Total time: " + formatter.format(totalTime) + " seconds"); // Print total stopwatch time in proper format
      System.out.println("Words spelt correctly: " + wordsCorrect); // Print words spelt correctly
      System.out.println("Grade: " + grade); // Print words spelt correctly
      System.out.println("---------------");
      System.out.println("To play again, type RESTART");
      System.out.println("To exit the game, type EXIT");

      // Check 3 cases
      switch (in.nextLine()) {
        case "RESTART": // If RESTART is entered
          System.out.println("Restarting...");
          wordsCorrect = 0;
          break;
        case "EXIT": // If EXIT is entered
          System.out.println("Exiting the game...");
          in.close(); // Close scanner
          System.exit(0); // Close program
        default: // If anything else is entered, make them play again
          System.out.println("If you're this bad at typing, you should play again.");
      }
    }
  }
}