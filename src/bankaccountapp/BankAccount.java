package bankaccountapp;

public abstract class BankAccount implements IBaseRate {

    // List of common props for Savings & Checking accounts
    private String name;
    private String SSN; // social security number
    private double balance;

    private static int uniqueIndex = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor
    public BankAccount(String name, String SSN, double initDeposite) {
        this.name = name;
        this.SSN = SSN;
        this.balance = initDeposite;

        // set accountNumber
        uniqueIndex++;
        this.accountNumber = setAccounNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccounNumber() {
        String last2digits_SSN = this.SSN.substring(SSN.length() - 2, SSN.length());
        int rand3digits = (int) (Math.random() * Math.pow(10, 3));

        return last2digits_SSN + uniqueIndex + rand3digits;
    }

    // Show info
    public void showInfo() {
        System.out.println("\n============================== ACCCOUNT INFO ===============================");
        System.out.println("NAME: " + name + "  SSN: " + this.SSN + "  Balance: $" + this.balance + "  ACOUNT NUM: "
                + accountNumber);
        System.out.println("----------------------------------------------------------------------------");
    }

    // Common Methods - Transactions
    public void deposit(double amount) {
        System.out.println(".....Depositing: $" + amount);
        this.balance += amount;
        System.out.println("Completed successfully!");
        showBalance();
    }

    public void withdraw(double amount) {
        System.out.println("......Withdrawing: $" + amount);
        this.balance -= amount;
        System.out.println("Completed successfully!");
        showBalance();
    }

    public void transfer(double amount, String toWhere) {
        System.out.println("......Transfering: $" + amount + " to " + toWhere);
        this.balance -= amount;
        System.out.println("Completed successfully!");
        showBalance();
    }

    public void showBalance() {
        System.out.println("Your Balance Now is: $" + balance);
    }

    // accrued interest الفائدة المستحقة
    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        showBalance();
    }

}
