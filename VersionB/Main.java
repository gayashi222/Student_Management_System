import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static StudentService studentService = new StudentService();

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
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid menu option.");
            }

        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n--- Student Management System: Version B ---");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search student");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("0. Exit");
    }

    private static void addStudent() {

        int id = readInt("Student ID: ");
        String name = readText("Student name: ");
        int age = readInt("Student age: ");
        String course = readText("Course: ");

        if (!ValidationUtil.isValidName(name) || !ValidationUtil.isValidAge(age) || !ValidationUtil.isValidCourse(course)) {
            System.out.println("Invalid student details. Age must be between 15 and 100.");
            return;
        }

        Student student = new Student(id, name, age, course);

        if (studentService.addStudent(student)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student ID already exists.");
        }
    }

    private static void viewStudents() {

        if (studentService.getAllStudents().isEmpty()) {
            System.out.println("No students are available.");
            return;
        }

        for (int i = 0; i < studentService.getAllStudents().size(); i++) {
            studentService.getAllStudents().get(i).printDetails();
        }
    }

    private static void searchStudent() {

        int id = readInt("Student ID: ");
        Student student = studentService.findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.printDetails();
        }
    }

    private static void updateStudent() {

        int id = readInt("Student ID to update: ");
        String name = readText("New name: ");
        int age = readInt("New age: ");
        String course = readText("New course: ");

        if (!ValidationUtil.isValidName(name) || !ValidationUtil.isValidAge(age) || !ValidationUtil.isValidCourse(course)) {
            System.out.println("Invalid details.");
            return;
        }

        if (studentService.updateStudent(id, name, age, course)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {

        int id = readInt("Student ID to delete: ");

        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static int readInt(String message) {

        int value = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(message);
            try {
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
        return value;
    }

    private static String readText(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }
}
