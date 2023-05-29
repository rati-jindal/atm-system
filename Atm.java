package OopsConcepts.AtmProject;

public abstract class Atm {

    private static double atmBalance = 100000;

    public abstract void cashWithdrawal(String accountNo);
    public abstract void fundTransfer(String accountNo);
    public abstract void checkBalance(String accountNo);

    public static double getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(double atmBalance) {
        this.atmBalance = atmBalance;
    }

}
