import java.util.Scanner; 
import java.util.Timer; 
import java.util.TimerTask; 
public class QuizApp { 
  static String[] questions = { "What is the capital of France?", "Which element has the chemical symbol 'O'?", "What is the largest planet in our solar system?" }; 
  static String[][] options = { {"1) Paris", "2) Rome", "3) Berlin", "4) Madrid"}, {"1) Oxygen", "2) Osmium", "3) Oxide", "4) Ozone"}, {"1) Earth", "2) Jupiter", "3) Mars", "4) Venus"} }; 
  static int[] correctAnswers = {1, 1, 2}; 
  // Indexes of correct answers 
  static int userAnswer = -1; 
  // User's choice 
  static int score = 0; 
  // Total score 
  static boolean timeUp = false; 
  public static void main(String[] args) { 
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Welcome to the Quiz!");
    for (int i = 0; i < questions.length; i++) { 
      timeUp = false; 
      System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]); 
      for (String option : options[i]) { 
        System.out.println(option); 
      } 
      // Start the timer for 10 seconds per question 
      Timer timer = new Timer(); 
      timer.schedule(new TimerTask() { 
        @Override public void run() { 
          timeUp = true; System.out.println("\nTime's up!"); 
          if (userAnswer == -1) { 
            userAnswer = 0; 
            // User didn't answer, treat as wrong answer 
          } 
        } 
      }, 10000); 
      // 10 seconds 
      // Get user's answer 
      userAnswer = -1; 
      while (userAnswer == -1 && !timeUp) { 
        System.out.print("Enter your answer (1-4): "); 
        if (scanner.hasNextInt()) { 
          int input = scanner.nextInt(); 
          if (input >= 1 && input <= 4) { 
            userAnswer = input; 
          } 
          else { 
            System.out.println("Invalid choice, try again."); 
          } 
        } 
        else { 
          System.out.println("Invalid input, enter a number between 1 and 4."); 
          scanner.next(); 
          // Clear invalid input 
        } 
      } 
      // Cancel the timer once the user answers 
      timer.cancel(); 
      // Check the answer 
      if (userAnswer == correctAnswers[i]) { 
        System.out.println("Correct!"); score++; 
      } 
      else { 
        System.out.println("Wrong! The correct answer is: " + options[i][correctAnswers[i] - 1]); 
      } 
    } 
    // Display final score 
    System.out.println("\nQuiz Finished!"); 
    System.out.println("Your final score is: " + score + " out of " + questions.length); 
    scanner.close(); 
  } 
}
