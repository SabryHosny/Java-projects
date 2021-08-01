package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<BankAccount> accountsList = new LinkedList<>();

        // BankAccount SvAc1 = new SavingsAccount("Ahmed Mohamed", "123456789", 2500);
        // BankAccount ChAc2 = new CheckingAccount("Ali Wael", "569812374", 1500);

        // SvAc1.showInfo();
        // ChAc2.showInfo();

        // // SvAc1.deposit(1000);
        // // SvAc1.withdraw(500);
        // // SvAc1.transfer(500, "ABOOOD");

        // SvAc1.compound();

        // Read csv file and then create the new account based on that data
        String file = System.getProperty("user.dir") + "\\src\\bankaccountapp\\files\\022 NewBankAccounts.csv";
        // OR:
        // String file = ".\\src\\bankaccountapp\\files\\022 NewBankAccounts.csv";
        List<String[]> accountHolders = utilities.CSV.readCSV(file);

        for (String[] record : accountHolders) {
            // System.out.println(record[0] + " | " + record[1] + " | " + record[2] + " | "
            // + record[3]);
            String name = record[0];
            String SSN = record[1];
            String accountType = record[2];
            double initDeposite = Double.parseDouble(record[3]);

            if (accountType.equals("Savings")) {
                System.out.println("Open A Savings Account");
                BankAccount newAccount = new SavingsAccount(name, SSN, initDeposite);
                accountsList.add(newAccount);

            } else if (accountType.equals("Checking")) {
                System.out.println("Open A Checking Account");
                BankAccount newAccount = new CheckingAccount(name, SSN, initDeposite);
                accountsList.add(newAccount);

            } else {
                System.out.println("Error: Couldn't Reading Account Type!");
            }
        }

        for (BankAccount account : accountsList) {
            account.showInfo();
        }
    }
}
