package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String name;
    private int gradeLevel;
    private String gradeLevels[] = { "Freshmen", "Sophmore", "Junior", "Senior" };
    private float balance;
    private float tuitionBalance;
    private String allCourses[] = { "History 101", "Mathematics 101", "English 101", "Chemistry 101",
            "Computer Science 101" };
    private ArrayList<String> enrolledCourses = new ArrayList<String>();

    private static float courseCost = 600;
    private static int id = 1000;

    /* =============================== LOGIC ==================================== */
    // Constractor
    public Student() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter student Name: ");
        this.name = in.nextLine();
        System.out.println("Student Name: " + this.name);

        System.out.println("Enter student Grad Level:");
        for (int i = 0; i < gradeLevels.length; i++) {
            System.out.println(i + "] " + gradeLevels[i]);
        }

        this.gradeLevel = in.nextInt();
        System.out.println("Student Grade Level: " + this.gradeLevel + " => " + gradeLevels[this.gradeLevel]);

        // generate an id for this student
        this.studentId = this.gradeLevel + "" + (Student.id + 1);
        System.out.println("Student ID: " + this.studentId);
    }

    // Enroll in courses
    public void enroll() {
        while (true) {

            System.out.println("Select Course To Enroll: ");
            for (int i = 0; i < allCourses.length; i++) {
                System.out.println(i + "] " + allCourses[i]);
            }
            System.out.println("q] to quite");

            Scanner in = new Scanner(System.in);
            String newEnroll = in.nextLine();
            if (newEnroll.equals("q")) {
                break;
            }
            try {
                int index = Integer.parseInt(newEnroll);
                if (!enrolledCourses.contains(allCourses[index])) {
                    this.enrolledCourses.add(allCourses[index]);
                    this.tuitionBalance += courseCost;
                }
            } catch (Exception e) {
                System.out.println("Please Enter A Valid Value!!!");
            }
        }
    }

    // view enrolled courses
    public void getEnrolledCourses() {
        System.out.println("Courses Enrolled: ");
        for (String course : enrolledCourses) {
            System.out.println("* " + course);
        }
    }

    // View Tuition
    public void viewTuition() {
        System.out.println("Your Tution is: " + this.tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        viewTuition();
        System.out.println("Enter Your Payment $: ");
        Scanner in = new Scanner(System.in);
        float payment = in.nextFloat();
        this.tuitionBalance -= payment;
        System.out.println("Thanks for your payment: " + payment + " $");
        viewTuition();
    }

    // See Status:
    public void showStatus() {
        System.out.println("========= STUDENT STATUS ========");
        System.out.println("Name: " + this.name.toLowerCase());
        System.out.println("ID: " + this.studentId);
        this.getEnrolledCourses();
        System.out.println("Tuition Balance: " + this.tuitionBalance);

    }

}
