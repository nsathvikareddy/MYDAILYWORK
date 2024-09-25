import java.util.Scanner; 
import java.util.Random; 
public class NumberGuessingGame { 
public static void main(String[] args) { 
  Scanner scanner = new Scanner(System.in); 
  Random random = new Random();
  boolean playAgain = true; 
  int roundNumber = 1; 
  while (playAgain) { 
    int numberToGuess = random.nextInt(100) + 1; 
    // Generates a random number between 1 and 100 
    int attempts = 0; 
    int maxAttempts = 10; 
    boolean hasGuessedCorrectly = false; 
    System.out.println("Round " + roundNumber); 
    System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?"); 
    System.out.println("You have " + maxAttempts + " attempts to guess the number."); 
    while (attempts < maxAttempts && !hasGuessedCorrectly) { 
      System.out.print("Enter your guess: "); 
      int userGuess = scanner.nextInt(); 
      attempts++; 
      if (userGuess == numberToGuess) { 
        hasGuessedCorrectly = true; 
        System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts."); 
      } 
      else if (userGuess < numberToGuess) { 
        System.out.println("Your guess is too low. Try again."); 
      } 
      else { 
        System.out.println("Your guess is too high. Try again."); 
      } 
    } 
    if (!hasGuessedCorrectly) { 
      System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + "."); 
    } 
    System.out.print("Do you want to play again? (yes/no): "); 
    String userResponse = scanner.next(); 
    if (userResponse.equalsIgnoreCase("no")) { 
      playAgain = false; 
    } 
    roundNumber++; 
  } 
  System.out.println("Thank you for playing!"); 
  scanner.close(); 
} 
}
