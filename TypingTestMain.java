/* This class holds the main method to run the game.
 * Andrew Souvanlasy
 * Created on October 22, 2021 @ 8:16 PM
 */

public class TypingTestMain {
  public static void main(String[] args) { // Main method
    TypingTest tt = new TypingTest(); // Create new instance

    tt.gameIntro(); // Call the intro

    tt.gameMain(); // Call the main game
  }
}