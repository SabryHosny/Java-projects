package emailapp;

import java.lang.reflect.Array;
import java.util.Scanner;
// import jdk.internal.org.objectweb.asm.Label;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String company = "EScompany.com";

    private String email;
    private String password;
    private int passwordLength = 10;

    private int mailboxCapacity = 500;
    private String alternateEmail;

    /* ====================================== */
    // Constructor
    public Email(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
        System.out.println("Email Created: " + this.firstName + this.lastName);

        setDepartment();

        this.password = randomPassword(passwordLength);
        System.out.println("Your password is: " + this.password);

        this.email = this.firstName.toLowerCase() + "." + this.lastName + "@" + this.department + "." + this.company;
    }

    // Ask for the department --------------------------------
    private String[] departments = { "", "Sales", "Development", "Accounting" };

    private void setDepartment() {
        while (true) {
            System.out.println(
                    "Please enter the department:\n 1] for Sales\n 2] for Development\n 3] for Accounting\n 0] for None");
            Scanner in = new Scanner(System.in);

            try {
                int userInput = in.nextInt();
                this.department = departments[userInput];
                break;
            } catch (Exception e) {

                System.out.println("ERROR: please enter a valid integer number!");
                continue;
            }

        }

    }

    // Generate random Pass ---------------------------
    private String randomPassword(int passwordLength) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+=-";
        char[] passwordGenerated = new char[passwordLength];
        for (int i = 0; i < passwordLength; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            passwordGenerated[i] = passwordSet.charAt(rand);
        }

        return new String(passwordGenerated);

    }

    // Set the mailbox Capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String showInfo() {
        return "EMAIL INFORMATION:\n  Display Name: " + this.firstName + " " + this.lastName + "\n  Campany Email: "
                + this.email + "\n  Mailbox Capacity: " + this.mailboxCapacity + " MB";
    }
}
