import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class GradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Handle invalid input
        if (n <= 0) {
            System.out.println("No students entered!");
            sc.close();
            return;
        }

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        double total = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            int marks;
            while (true) {
                System.out.print("Enter Marks (0-100): ");
                marks = sc.nextInt();
                sc.nextLine();

                if (marks >= 0 && marks <= 100) {
                    break;
                }
                System.out.println("Invalid marks! Enter between 0 and 100.");
            }

            Student student = new Student(name, marks);
            students.add(student);

            total += marks;
            highest = Math.max(highest, marks);
            lowest = Math.min(lowest, marks);
        }

        System.out.println("\n===== STUDENT REPORT =====");

        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getMarks());
        }

        double average = total / n;

        System.out.printf("\nAverage Marks : %.2f%n", average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);

        sc.close();
    }
}