import Account.*;
import BillFactory.Billfactory;
import DatabaseManagemnet.AppController;
import Strategy.Context;
import DatabaseManagemnet.Database;
import ThirdParty.BankAPI;
import WalletFactory.WalletFactory;
import WalletFactory.WalletProviders;
import BillFactory.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to our APP ");
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getDatabase();
        AppController appController = new AppController(database);
        WalletFactory walletFactory = new WalletFactory();
        BankAPI test = new BankAPI("010100");
        database.addBankAccount(test);
        WalletProviders walletProviders = walletFactory.createWallet("Electronic payment","01020","Fawry");
        WalletProviders walletProviders1 = walletFactory.createWallet(" Bank wallet","01023","CIB smart wallet");
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
                            BankAPI bankAPI = new BankAPI();
                            Context context = new Context(bankAPI);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount,instapayAccount);
                        }else if(button1.equals("3")){
                            boolean flagWallet = false;
                            if(!flagWallet)
                                System.out.println("you entered invalid company name");
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
                            boolean flagWallet = false;
                            if(!flagWallet)
                                System.out.println("you entered invalid company name");

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
        System.out.println("We will miss you");
    }
}

