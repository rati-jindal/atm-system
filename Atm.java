package OopsConcepts.AtmProject;

public class Atm {
    private static double atmBalance = 100000;

    public static double getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(double atmBalance) {
        this.atmBalance = atmBalance;
    }
}
