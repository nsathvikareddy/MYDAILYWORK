import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 
// Course class 
class Course { 
  private String courseCode; 
  private String title; 
  private String description; 
  private int capacity; 
  private List<Student> enrolledStudents; 
  private String schedule; 
  public Course(String courseCode, String title, String description, int capacity, String schedule) { 
    this.courseCode = courseCode; 
    this.title = title; 
    this.description = description; 
    this.capacity = capacity; 
    this.enrolledStudents = new ArrayList<>(); 
    this.schedule = schedule; 
  } 
  public String getCourseCode() { 
    return courseCode; 
  } 
  public String getTitle() { 
    return title; 
  } 
  public String getDescription() { 
    return description; 
  } 
  public int getCapacity() { 
    return capacity; 
  } 
  public String getSchedule() { 
    return schedule; 
  } 
  public List<Student> getEnrolledStudents() { 
    return enrolledStudents; 
  } 
  public boolean registerStudent(Student student) { 
    if (enrolledStudents.size() < capacity) { 
      enrolledStudents.add(student); 
      return true; 
    } 
    else { 
      System.out.println("Course is full."); 
      return false; 
    } 
  } 
  public void removeStudent(Student student) { 
    enrolledStudents.remove(student); 
  } 
  public int getAvailableSlots() { 
    return capacity - enrolledStudents.size(); 
  } 
  @Override public String toString() { 
    return "Course Code: " + courseCode + ", Title: " + title + ", Description: " + description + ", Capacity: " + capacity + ", Available Slots: " + getAvailableSlots() + ", Schedule: " + schedule; 
  } 
} 
// Student class 
class Student { 
  private String studentID; 
  private String name; 
  private List<Course> registeredCourses; 
  public Student(String studentID, String name) { 
    this.studentID = studentID; 
    this.name = name; 
    this.registeredCourses = new ArrayList<>(); 
  } 
  public String getStudentID() { 
    return studentID; 
  } 
  public String getName() { 
    return name; 
  } 
  public List<Course> getRegisteredCourses() { 
    return registeredCourses; 
  } 
  public void registerForCourse(Course course) { 
    if (course.registerStudent(this)) {
      registeredCourses.add(course);
      System.out.println("Successfully registered for " + course.getTitle()); 
    } 
    else { 
      System.out.println("Failed to register for " + course.getTitle()); 
    } 
  } 
  public void dropCourse(Course course) { 
    if (registeredCourses.contains(course)) { 
      course.removeStudent(this); 
      registeredCourses.remove(course); 
      System.out.println("Successfully dropped " + course.getTitle()); 
    } 
    else { 
      System.out.println("Not registered in " + course.getTitle()); 
    } 
  } 
  @Override public String toString() { 
    return "Student ID: " + studentID + ", Name: " + name; 
  } 
} 
// Main class 
public class CourseRegistrationSystem { 
  public static void main(String[] args) { 
    Scanner scanner = new Scanner(System.in); 
    // Create courses 
    Course course1 = new Course("CS101", "Introduction to Computer Science", "Basics of CS", 30, "Mon-Wed-Fri 9:00AM"); 
    Course course2 = new Course("CS102", "Data Structures", "Study of Data Structures", 20, "Tue-Thu 11:00AM"); 
    // Create students 
    Student student1 = new Student("S001", "Alice"); 
    Student student2 = new Student("S002", "Bob"); 
    while (true) { 
      System.out.println("\n--- Course Registration System ---"); 
      System.out.println("1. List Available Courses"); 
      System.out.println("2. Register for a Course"); 
      System.out.println("3. Drop a Course"); 
      System.out.println("4. Exit"); 
      System.out.print("Select an option: "); 
      int option = scanner.nextInt(); 
      scanner.nextLine(); 
      // Consume newline 
      switch (option) { 
        case 1: 
          // List courses 
          System.out.println(course1); 
          System.out.println(course2); 
          break; 
        case 2: 
          // Register for a course 
          System.out.println("Enter student ID: "); 
          String studentID = scanner.nextLine(); 
          Student currentStudent = studentID.equals("S001") ? student1 : student2; 
          System.out.println("Enter course code to register: "); 
          String courseCode = scanner.nextLine(); 
          Course courseToRegister = courseCode.equals("CS101") ? course1 : course2; 
          currentStudent.registerForCourse(courseToRegister); 
          break; 
        case 3: 
          // Drop a course 
          System.out.println("Enter student ID: "); 
          studentID = scanner.nextLine(); 
          currentStudent = studentID.equals("S001") ? student1 : student2; 
          System.out.println("Enter course code to drop: ");
          courseCode = scanner.nextLine(); 
          Course courseToDrop = courseCode.equals("CS101") ? course1 : course2; 
          currentStudent.dropCourse(courseToDrop); 
          break; 
        case 4: 
          // Exit 
          System.out.println("Exiting..."); 
          System.exit(0); 
          break; 
        default: 
          System.out.println("Invalid option."); 
      } 
    } 
  } 
}
