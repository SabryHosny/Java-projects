package studentdatabaseapp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Student student1 = new Student();
        // student1.enroll();

        // // The student should be able to view their balance and pay the tuition
        // // # view their balance:
        // student1.viewTuition();
        // // # pay the tuition:
        // student1.payTuition();

        // // To see the status of the student, we should see their
        // // name, ID, courses enrolled, and balance
        // student1.showStatus();

        // Ask the user how many new students will be added to the database
        int studentsNumber = 0;
        while (true) {
            System.out.println("Enter the number of students to enroll: ");
            Scanner in = new Scanner(System.in);
            try {
                studentsNumber = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter a valid Value !!!");
            }
        }

        Student[] students = new Student[studentsNumber];
        for (int i = 0; i < students.length; i++) {
            System.out.println("### REGISTER NEW STUDENT ###");
            Student newStudent = new Student();
            students[i] = newStudent;
            newStudent.enroll();
            newStudent.payTuition();
        }

        System.out.println("################ STUDENTS ADDED #####################");
        for (int i = 0; i < students.length; i++) {
            students[i].showStatus();
        }
    }

}
