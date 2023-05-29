package OopsConcepts.AtmProject;

public class Account {

    private String name;
    private String accountNo;
    private double balance;
    private String pin;

    public Account(String name, String accountNo, double balance, String pin) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
