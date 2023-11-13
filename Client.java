import Account.*;
import Strategy.Context;
import DatabaseManagemnet.Database;
import ThirdParty.BankAPI;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to our APP ");
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getDatabase();
        while (exit) {
            System.out.print("please press 1 to SignUp or press 2 to Sign_in :");
            String button = scanner.next();
            AccountManagement accountManagement = new AccountManagement();
            InstapayAccount instapayAccount;
            if (button.equals("1")){
                System.out.print("press 1 to Signup with bank account or 2 to Signup with Wallet account:");
                String option = scanner.next();
                instapayAccount=accountManagement.Sign_up(option);
                if(instapayAccount!=null){
                    boolean flag = true;
                    while (flag) {
                        System.out.println("press 1 if you want to transfer to another Instapay account");
                        System.out.println("press 2 if you want to transfer to a Bank account");
                        System.out.println("press 3 if you want to transfer to a Wallet  account");
                        System.out.println("press 4 if you want to view your balance");
                        System.out.println("press 5 if you want to increase your balance");
                        System.out.println("press 6 if you want to pay a bill");
                        System.out.println("press 0 if you want to Sign out");
                        String button1 = scanner.next();
                        BalanceManagement balanceManagement = new BalanceManagement();
                        if (button1.equals("1")) {
                            Context context = new Context(balanceManagement);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount, instapayAccount);
                        } else if (button1.equals("2")) {
                            BankAPI bankAPI = new BankAPI();
                            Context context = new Context(bankAPI);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount,instapayAccount);
                        }else if(button1.equals("3")){

                        }
                        else if(button1.equals("4")){
                            System.out.println("Your current Balance = "+instapayAccount.InquireBalance());
                        }
                        else if(button1.equals("5")){
                            System.out.println("please enter the amount that you want to add");
                            double money = scanner.nextDouble();
                            balanceManagement.addtoBalance(instapayAccount,money);
                        }
                        else if(button1.equals("6")){
                            System.out.println("ali");
                            System.out.println("d           ");

                        }
                        else if (button1.equals("0")) {
                            System.out.println("You have signed out successfully");
                            flag = false;
                        }
                    }
                }
            }
            else if (button.equals("2")){
                System.out.println("please enter your user name :");
                String un = scanner.next();
                System.out.println("please enter your password : ");
                String pw = scanner.next();
                instapayAccount = accountManagement.sign_n(un,pw);
                if(instapayAccount!=null){
                    boolean flag = true;
                    while (flag) {
                        System.out.println("press 1 if you want to transfer to another Instapay account");
                        System.out.println("press 2 if you want to transfer to a Bank account");
                        System.out.println("press 3 if you want to transfer to a Wallet  account");
                        System.out.println("press 4 if you want to view your balance");
                        System.out.println("press 5 if you want to increase your balance");
                        System.out.println("press 6 if you want to pay a bill");
                        System.out.println("press 0 if you want to Sign out");
                        String button1 = scanner.next();
                    }
                }
            }
            else
                System.out.println("You have entered invalid button");
            System.out.print("Do you want to exit the program y/n:");
            String power = scanner.next();
            if(power.equals("y")){
                exit = false;
            }
        }
        System.out.println("We will miss you");
        System.out.println("Accounts of Banks:");
        database.printBankAccounts();
        System.out.println("Accounts of instapay:");
        database.printSavedAccounts();
        System.out.println("Accounts of Wallet providers:");
        database.printWalletAccounts();
    }
}

