
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String department;
    double mark;

    Student(int rollNo, String name, String department, double mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.mark = mark;
    }

    void display() {
        System.out.println("Roll No    : " + rollNo);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Mark       : " + mark);
        System.out.println("----------------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        // Check for duplicate roll number
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("Roll number already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Mark: ");
        double mark = sc.nextDouble();

        students.add(new Student(rollNo, name, department, mark));
        System.out.println("Student added successfully!");
    }

    // View Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n----- Student Details -----");

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    static void searchStudent() {
        System.out.print("Enter Roll Number to Search: ");
        int rollNo = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("\nStudent Found!");
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Student
    static void updateStudent() {
        System.out.print("Enter Roll Number to Update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Department: ");
                s.department = sc.nextLine();

                System.out.print("Enter New Mark: ");
                s.mark = sc.nextDouble();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter Roll Number to Delete: ");
        int rollNo = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNo == rollNo) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Main Method
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

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

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
