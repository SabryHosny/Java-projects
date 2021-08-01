package bankaccountapp;

public class CheckingAccount extends BankAccount {

    // props specific to Checking Account
    private int debitCard_Number;
    private int debitCard_PIN;

    // constructor
    public CheckingAccount(String name, String SSN, double initDeposite) {
        super(name, SSN, initDeposite);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    // Overriding Show info
    public void showInfo() {
        super.showInfo();
        System.out.println("ACOUNT TYPE: " + "Checking" + "  Debit Card Number: " + debitCard_Number
                + "  Debit Card PIN: " + debitCard_PIN + "  Rate: % " + rate);
    }

    private void setDebitCard() {
        this.debitCard_Number = (int) (Math.random() * Math.pow(10, 12));
        this.debitCard_PIN = (int) (Math.random() * Math.pow(10, 4));
    }

    // Set Base Rate
    public void setRate() {
        this.rate = getBaseRate() * .15;
    }

}
