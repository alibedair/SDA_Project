import Account.*;
import BillFactory.Billfactory;
import Strategy.Context;
import DatabaseManagemnet.Database;
import ThirdParty.BankAPI;
import WalletFactory.*;
import BillFactory.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to our APP ");
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getDatabase();
        BankAPI test = new BankAPI("010100");
        database.addBankAccount(test);
        WalletFactory walletFactory = new WalletFactory();
        WalletProviders walletProviders = walletFactory.createWallet("Electronic payment","010","Fawry");
        WalletProviders walletProviders1 =walletFactory.createWallet("Bank wallet","012","CIB wallet");
        WalletProviders walletProviders2 = walletFactory.createWallet("Telecommunication company","01028","Vodafone cash");
        database.addWalletAccount(walletProviders);
        database.addWalletAccount(walletProviders1);
        database.addWalletAccount(walletProviders2);
        while (exit) {
            System.out.print("please press 1 to SignUp or press 2 to Sign_in :");
            String button = scanner.next();
            AccountManagement accountManagement = new AccountManagement();
            InstapayAccount instapayAccount;
            BalanceManagement balanceManagement = new BalanceManagement();
            if (button.equals("1")){
                System.out.print("press 1 to Signup with bank account or 2 to Signup with Wallet account:");
                String option = scanner.next();
                instapayAccount=accountManagement.Sign_up(option);
                if(instapayAccount!=null){
                    boolean flag = true;
                    while (flag) {
                        instapayAccount.getFeatures();
                        String button1 = scanner.next();
                        if (button1.equals("1")) {
                            Context context = new Context(balanceManagement);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount, instapayAccount);
                        } else if (button1.equals("2")) {
                            if(instapayAccount.getType().equals("Bank account")) {
                                BankAPI bankAPI = new BankAPI();
                                Context context = new Context(bankAPI);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount, instapayAccount);
                            }
                            else {
                                System.out.println("Forbidden Request");
                            }
                        }else if(button1.equals("3")){
                            WalletProviders walletProviders3;
                            scanner.useDelimiter("\n");
                            System.out.println("please enter company type to filter our wallet providers :");
                            String c = scanner.next();
                            scanner.nextLine();
                            boolean flagW = false;
                            for(int i=0;i<database.getWalletAccounts().size();i++){
                                if(database.getWalletAccounts().get(i).getCompany().equals(c)){
                                    flagW =true;
                                    walletProviders3 = database.getWalletAccounts().get(i);
                                    Context context = new Context(walletProviders3);
                                    System.out.println("please enter the amount you want to transfer :");
                                    double amount = scanner.nextDouble();
                                    context.ChooseTransference(amount,instapayAccount);
                                }
                            }
                            if(!flagW)
                                System.out.println("you entered a company name that not matched to our Wallet providers");
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
                            System.out.println("please press button 1 if you want to pay a Gas bill");
                            System.out.println("please press button 2 if you want to pay a Water bill");
                            System.out.println("please press button 3 if you want to pay a Electricity bill");
                            String choice = scanner.next();
                            Billfactory billfactory = new Billfactory();
                            Bill bill;
                            if(choice.equals("1")){
                                 bill = billfactory.createbill("Gas");
                                bill.print();
                                bill.pay(instapayAccount);
                            }
                            else if(choice.equals("2")){
                                bill = billfactory.createbill("Water");
                                bill.print();
                                bill.pay(instapayAccount);
                            }
                            else if(choice.equals("3")){
                                bill = billfactory.createbill("Electricity");
                                bill.print();
                                bill.pay(instapayAccount);
                            }
                        }
                        else if (button1.equals("0")) {
                            System.out.println("You have signed out successfully");
                            flag = false;
                        }
                        else
                            System.out.println("you entered invalid button");
                    }
                }
            }
            else if (button.equals("2")){
                System.out.println("please enter your user name :");
                String un = scanner.next();
                System.out.println("please enter your password : ");
                String pw = scanner.next();
                instapayAccount = accountManagement.sign_in(un,pw);
                if(instapayAccount!=null){
                    boolean flag = true;
                    while (flag) {
                        instapayAccount.getFeatures();
                        String button1 = scanner.next();
                        if(button1.equals("1")){
                            Context context= new Context(balanceManagement);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount,instapayAccount);
                        }
                        else if(button1.equals("2")){
                            if (instapayAccount.getType().equals("Bank account")){
                                BankAPI bankAPI = new BankAPI();
                                Context context = new Context(bankAPI);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount,instapayAccount);
                            }
                            else
                                System.out.println("Forbidden request as you are not allowed to do this feature");

                        } else if (button1.equals("3")) {
                            WalletProviders walletProviders3;
                            scanner.useDelimiter("\n");
                            System.out.println("please enter company type to filter our wallet providers :");
                            String c = scanner.next();
                            scanner.nextLine();
                            boolean flagW = false;
                            for(int i=0;i<database.getWalletAccounts().size();i++){
                                if(database.getWalletAccounts().get(i).getCompany().equals(c)){
                                    flagW =true;
                                    walletProviders3 = database.getWalletAccounts().get(i);
                                    Context context = new Context(walletProviders3);
                                    System.out.println("please enter the amount you want to transfer :");
                                    double amount = scanner.nextDouble();
                                    context.ChooseTransference(amount,instapayAccount);
                                }
                            }
                            if(!flagW)
                                System.out.println("you entered a company name that not matched to our Wallet providers");

                        } else if (button1.equals("4")) {
                            System.out.println("Your current Balance = "+instapayAccount.InquireBalance());

                        }
                        else if(button1.equals("5")){
                            System.out.println("please enter the amount that you want to add");
                            double money = scanner.nextDouble();
                            balanceManagement.addtoBalance(instapayAccount,money);

                        }
                        else if(button1.equals("6")){
                            System.out.println("please press button 1 if you want to pay a Gas bill");
                            System.out.println("please press button 2 if you want to pay a Water bill");
                            System.out.println("please press button 3 if you want to pay a Electricity bill");
                            String choice = scanner.next();
                            Billfactory billfactory = new Billfactory();
                            Bill bill;
                            if(choice.equals("1")){
                                bill = billfactory.createbill("Gas");
                                bill.print();
                                bill.pay(instapayAccount);
                            }
                            else if(choice.equals("2")){
                                bill = billfactory.createbill("Water");
                                bill.print();
                                bill.pay(instapayAccount);
                            }
                            else if(choice.equals("3")){
                                bill = billfactory.createbill("Electricity");
                                bill.print();
                                bill.pay(instapayAccount);
                            }
                        }
                        else if(button1.equals("0")){
                            System.out.println("You have signed out successfully");
                            flag = false;

                        }
                        else
                            System.out.println("you entered invalid button");
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
        scanner.close();
        System.out.println("We will miss you");
    }
}

