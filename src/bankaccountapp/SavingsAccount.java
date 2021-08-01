package bankaccountapp;

public class SavingsAccount extends BankAccount {

    // props specific to Saving Account
    private int safetyDepositBox_ID;
    private int safetyDepositBox_Key;

    // constructor
    public SavingsAccount(String name, String SSN, double initDeposite) {
        super(name, SSN, initDeposite);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBoxID();
        setSafetyDepositBoxKey();
    }

    // Overriding Show info
    public void showInfo() {
        super.showInfo();
        System.out.println("ACOUNT TYPE: " + "Saving" + "  Safety DepositBox ID: " + safetyDepositBox_ID
                + "  Safety DepositBox Key: " + safetyDepositBox_Key + "  Rate: % " + rate);
    }

    private void setSafetyDepositBoxID() {
        this.safetyDepositBox_ID = (int) (Math.random() * Math.pow(10, 3));
    }

    private void setSafetyDepositBoxKey() {
        this.safetyDepositBox_Key = (int) (Math.random() * Math.pow(10, 4));
    }

    // Set Base Rate
    public void setRate() {
        this.rate = getBaseRate() - .25;
    }

}
