package StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import static util.InputUtil.scanner;

public class StudentApp {
    private static List<Student> students = new ArrayList<>();
    private static StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Sort Students by ID");
            System.out.println("6. Sort Students by Name");
            System.out.println("7. Sort Students by Age");
            System.out.println("8. Sort Students by Grade");
            System.out.println("9. Display All Students");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    searchStudentByName();
                    break;
                case 5:
                    sortStudentsById();
                    break;
                case 6:
                    sortStudentsByName();
                    break;
                case 7:
                    sortStudentsByAge();
                    break;
                case 8:
                    sortStudentsByGrade();
                    break;
                case 9:
                    displayStudents();
                    break;
                case 10:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student studentToRemove = studentManager.searchById(id);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    private static void searchStudentById() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentManager.searchById(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void searchStudentByName() {
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine();

        Student student = studentManager.searchByName(name);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void sortStudentsById() {
        students.sort(Comparator.comparingInt(Student::getId));
        System.out.println("Students sorted by ID.");
    }

    private static void sortStudentsByName() {
        students = studentManager.mergeSortByName(students);
        System.out.println("Students sorted by Name.");
    }

    private static void sortStudentsByAge() {
        studentManager.bubbleSortByAge();
        System.out.println("Students sorted by Age.");
    }

    private static void sortStudentsByGrade() {
        studentManager.selectionSortByGrade();
        System.out.println("Students sorted by Grade.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}