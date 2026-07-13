import java.util.ArrayList;
import java.util.Scanner;
 
public class StudentManagementSystem {
 
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
 
        int choice;
 
        do {
            showMenu();
            choice = readInt("Enter your choice: ");
 
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 0:
                    System.out.println("Thank you for using the Student Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
 
        } while (choice != 0);
    }
 
    private static void showMenu() {
        System.out.println("\n--- Student Management System:  ---");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("0. Exit");
    }
 
    // Add a new student, but first check the ID is not already used
    private static void addStudent() {
 
        int id = readInt("Enter student ID: ");
 
        if (findStudentById(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }
 
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        int age = readInt("Enter student age: ");
        System.out.print("Enter course: ");
        String course = sc.nextLine();
 
        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully.");
    }
 
    private static void viewStudents() {
 
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
 
        System.out.println("\nStudent Records");
 
        for (Student student : students) {
            student.displayDetails();
        }
    }
 
    private static void searchStudent() {
 
        int id = readInt("Enter student ID to search: ");
        Student student = findStudentById(id);
 
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.displayDetails();
        }
    }
 
    private static void updateStudent() {
 
        int id = readInt("Enter student ID to update: ");
        Student student = findStudentById(id);
 
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
 
        System.out.print("Enter new name: ");
        student.setName(sc.nextLine());
        student.setAge(readInt("Enter new age: "));
        System.out.print("Enter new course: ");
        student.setCourse(sc.nextLine());
 
        System.out.println("Student updated successfully.");
    }
 
    private static void deleteStudent() {
 
        int id = readInt("Enter student ID to delete: ");
        Student student = findStudentById(id);
 
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        }
    }
 
    //  loop that goes through the list to find a matching ID
    private static Student findStudentById(int id) {
 
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }
 
    // Keeps asking until the user enters a proper whole number
    private static int readInt(String message) {
 
        int value = -1;
        boolean valid = false;
 
        while (!valid) {
            System.out.print(message);
            try {
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return value;
    }
}
