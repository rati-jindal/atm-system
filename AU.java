package OopsConcepts.AtmProject;

import java.util.Scanner;

public class AU implements AtmService {
    Scanner sc = new Scanner(System.in);
    Atm atm = new Atm();
    @Override
    public void cashWithdrawal(String accountNo) {
        //entering amount
        System.out.println("Enter Amount");
        System.out.println("Enter 0 for exit");
        double amount = sc.nextDouble();
        if (amount == 0) {
            Test.mainMenu();
        }
        //checking if amount is positive and is available
        if (amount > 0 && amount <= atm.getAtmBalance()) {
            //entering pin
            System.out.println("Enter pin");
            System.out.println("Enter 0 for exit");
            sc.nextLine();
            String pin = sc.nextLine();
            if (pin.equals("0")) {
                Test.mainMenu();
            } else if (pin.length() == 4) {
                Account account = Test.auth(accountNo, pin);
                //checking if account-pin exist
                if (account == null) {
                    System.out.println("Error");
                    Test.mainMenu();
                } else {
                    //checking if account balance is sufficient
                    if (account.getBalance() < amount) {
                        System.out.println("Error");
                        Test.mainMenu();
                    } else {
                        System.out.println("Withdrawing");
                        account.setBalance(account.getBalance() - amount);
                        atm.setAtmBalance(atm.getAtmBalance() - amount);
                        System.out.println("Done..");
                        System.out.println("Your Current Balance is : " + account.getBalance());
                        Test.mainMenu();
                    }
                }
            } else {
                System.out.println("Error");
                Test.mainMenu();
            }
        } else {
            System.out.println("Error");
            Test.mainMenu();
        }
    }

    @Override
    public void fundTransfer(String accountNo) {
        System.out.println("Enter Reciever Account Number");
        System.out.println("Enter 0 to exit");
        String reciverAccNo = sc.nextLine();
        if (reciverAccNo.equals("0")){
            Test.mainMenu();
        }else {
            Account reciverAccount = Test.searching(reciverAccNo);
            System.out.println("This account belongs to :"+reciverAccount.getName());
            System.out.println("Enter 1 to confirm");
            System.out.println("Enter 0 to exit");
            int inp = sc.nextInt();
            if (inp==0){
                Test.mainMenu();
            }else {
                //entering amount
                System.out.println("Enter Amount");
                System.out.println("Enter 0 for exit");
                double amount = sc.nextDouble();
                if (amount == 0) {
                    Test.mainMenu();
                }
                //entering pin
                System.out.println("Enter pin");
                System.out.println("Enter 0 for exit");
                sc.nextLine();
                String pin = sc.nextLine();
                if (pin.equals("0")) {
                    Test.mainMenu();
                } else if (pin.length() == 4) {
                    Account account = Test.auth(accountNo, pin);
                    //checking if account-pin exist
                    if (account == null) {
                        System.out.println("Error");
                        Test.mainMenu();
                    } else {
                        //checking if account balance is sufficient
                        if (account.getBalance() < amount) {
                            System.out.println("Error");
                            Test.mainMenu();
                        } else {
                            System.out.println("Transfering");
                            account.setBalance(account.getBalance() - amount);
                            reciverAccount.setBalance(reciverAccount.getBalance() + amount);
                            System.out.println("Done..");
                            System.out.println("Your Current Balance is : " + account.getBalance());
                            Test.mainMenu();
                        }
                    }
                } else {
                    System.out.println("Error");
                    Test.mainMenu();
                }
            }
        }
    }

    @Override
    public void checkBalance(String accountNo) {
        System.out.println("Enter pin");
        System.out.println("Enter 0 for exit");
        String pin = sc.nextLine();
        if (pin.equals("0")) {
            Test.mainMenu();
        } else if (pin.length() == 4) {
            Account account = Test.auth(accountNo, pin);
            //checking if account-pin exist
            if (account == null) {
                System.out.println("Error");
                Test.mainMenu();
            } else {
                System.out.println("Your Current Balance is : " + account.getBalance());
                Test.mainMenu();
            }
        }
    }

}