import java.util.Scanner; 
public class SimpleGradeCalculator { 
  public static void main(String[] args) { 
    Scanner scanner = new Scanner(System.in); 
    // Input number of subjects 
    System.out.print("Enter the number of subjects: "); 
    int numSubjects = scanner.nextInt(); 
    if (numSubjects <= 0) { 
      System.out.println("The number of subjects must be a positive integer."); 
      return; 
    } 
    double totalMarks = 0.0; 
    // Input marks for each subject 
    for (int i = 0; i < numSubjects; i++) { 
      System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): "); 
      double marks = scanner.nextDouble(); 
      if (marks < 0 || marks > 100) { 
        System.out.println("Marks should be between 0 and 100. Please enter again."); 
        i--; 
        // Repeat the current iteration continue; 
      } 
      totalMarks += marks; } 
    // Calculate average percentage 
    double averagePercentage = totalMarks / numSubjects; 
    // Determine grade 
    String grade; 
    if (averagePercentage >= 90) { 
      grade = "A"; 
    } 
    else if (averagePercentage >= 80) { 
      grade = "B"; 
    } 
    else if (averagePercentage >= 70) {
      grade = "C";
    } 
    else if (averagePercentage >= 60) { 
      grade = "D"; 
    } 
    else { 
      grade = "F"; 
    } 
    // Display results 
    System.out.printf("Total Marks: %.2f\n", totalMarks); 
    System.out.printf("Average Percentage: %.2f%%\n", averagePercentage); 
    System.out.println("Grade: " + grade); 
    scanner.close(); 
  } 
}
