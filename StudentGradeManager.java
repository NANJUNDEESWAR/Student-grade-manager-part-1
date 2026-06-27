import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("===================================");

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            students.add(new Student(name, grade));
        }

        // Calculate statistics
        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                highestStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowestStudent = s.name;
            }
        }

        double average = total / students.size();

        // Display report
        System.out.println("\n===================================");
        System.out.println("         SUMMARY REPORT");
        System.out.println("===================================");

        System.out.printf("%-20s %-10s\n", "Student Name", "Grade");
        System.out.println("-----------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s %-10.2f\n", s.name, s.grade);
        }

        System.out.println("-----------------------------------");
        System.out.printf("Average Grade : %.2f\n", average);
        System.out.printf("Highest Grade : %.2f (%s)\n", highest, highestStudent);
        System.out.printf("Lowest Grade  : %.2f (%s)\n", lowest, lowestStudent);

        scanner.close();
    }
}