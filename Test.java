package OopsConcepts.AtmProject;

import java.util.Scanner;

public class Test {

    private final static Account[] accounts = {
            new Account("Test-1", "SBI-123456", 15000, "7456"),
//            new Account("Test-2", "ICICI-789654", 20000, "4789"),
            new Account("Test-3", "AU-965478", 22000, "4789"),
//            new Account("Test-4", "HDFC-231456", 29000, "8629"),
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        mainMenu();

    }

    public static Account auth(String accountNo,String pin){
        for(Account account: accounts){
            if (account.getAccountNo().equals(accountNo)&&account.getPin().equals(pin) ){
                return account;
            }
        }
        return null;
    }

    public static Account searching(String accountNo){
        for(Account account: accounts){
            if (account.getAccountNo().equals(accountNo)){
                return account;
            }
        }
        return null;
    }

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for Account No ");
        System.out.println("Enter 0 for exit");
        int inp = scanner.nextInt();
        scanner.nextLine();
        if (inp == 1) {
            System.out.println("Enter Account No");
            String accNo = scanner.nextLine();
            String accName = searching(accNo).getName();
            if (accName!=null){
                System.out.println("Welcome... " + accName);
                System.out.println( "Enter 1 for Cash Withdrawal\n" +
                        "Enter 2 for Fund Transfer\n" +
                        "Enter 3 for Balance Enquiry\n"+
                        "Enter 0 to quit");
                int inp1 = scanner.nextInt();
                String bankName = accNo.split("-")[0];
                if (bankName.equals("SBI")){
                    Atm atm = new SBI();
                    if (inp1==1){
                        atm.cashWithdrawal(accNo);
                    } else if (inp1 == 2) {
                        atm.fundTransfer(accNo);
                    } else if (inp1 == 3) {
                        atm.checkBalance(accNo);
                    }
                }
                else if (bankName.equals("AU")){
                    Atm atm = new AU();
                    if (inp1==1){
                        atm.cashWithdrawal(accNo);
                    } else if (inp1 == 2) {
                        atm.fundTransfer(accNo);
                    } else if (inp1 == 3) {
                        atm.checkBalance(accNo);
                    }
                }
            }else {
                System.out.println("Wrong Account No");
                mainMenu();
            }

        }




    }

}
