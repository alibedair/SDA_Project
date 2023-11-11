import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        WalletAccount walletAccount = new WalletAccount("01023");
        Database database = Database.getDatabase();
        database.addWalletAccount(walletAccount);
        BankAccount bankAccount = new BankAccount("01013");
        database.addBankAccount(bankAccount);
        InstapayAccount test = new  AccountWithBank("bedo","122");
        InstapayAccount test1 = new AccountWithWallet("ramy","123");
        database.addAccount(test1);
        database.addAccount(test);
        System.out.println("Welcome to our APP ");
        boolean exit = true;
        while (exit) {
            int choice;
            System.out.print("please press 1 to SignUp or press 2 to Signin :  ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            boolean flag = true;
            if (choice == 1) {
                System.out.print("press 1 to Signup with bank account or 2 to Signup with Wallet account : ");
                int button = scanner.nextInt();
                InstapayAccount instapayAccount;
                if (button == 1) {
                    instapayAccount = new AccountWithBank();
                    System.out.println("please enter your Mobile number associated with the Bank :");
                    String number = scanner.next();
                    if (instapayAccount.signup(number)) {
                        String choice1;
                        while (flag) {
                            System.out.println("press 1 if you want to transfer to another Instapay account");
                            System.out.println("press 2 if you want to transfer to a Bank account");
                            System.out.println("press 3 if you want to transfer to a Wallet  account");
                            System.out.println("press 4 if you want to view your balance");
                            System.out.println("press 5 if you want to increase your balance");
                            System.out.println("press 0 if you want to Sign out");
                            choice1 = scanner.next();
                            if (choice1.equals("1")) {
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                instapayAccount.transfer(amount);
                            } else if (choice1.equals("2")) {
                                BankAccount bankAccount1 = new BankAccount();
                                Context context = new Context(bankAccount1);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount, instapayAccount);

                            } else if (choice1.equals("3")) {
                                WalletAccount walletAccount1 = new WalletAccount();
                                Context context = new Context(walletAccount1);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount, instapayAccount);

                            } else if (choice1.equals("4")) {
                                System.out.println("your balance = " + instapayAccount.InquireBalance());

                            } else if (choice1.equals("5")) {
                                System.out.println("please enter the amount of money that you want to add to your balance:");
                                double amount = scanner.nextDouble();
                                instapayAccount.addtoBalance(amount);
                            } else if (choice1.equals("0")) {
                                flag = false;
                                System.out.println("You have signed out successfully");
                            } else {
                                System.out.println("You have entered invalid button");
                            }
                        }
                    }
                } else if (button == 2) {
                    instapayAccount = new AccountWithWallet();
                    System.out.println("please enter your Mobile number associated with the Wallet :");
                    String number = scanner.next();
                    while (flag) {
                        if (instapayAccount.signup(number)) {
                            System.out.println("press 1 if you want to transfer to another Instapay account");
                            System.out.println("press 2 if you want to transfer to a Wallet  account");
                            System.out.println("press 3 if you want to view your balance");
                            System.out.println("press 4 if you want to increase your balance");
                            System.out.println("press 0 if you want to Sign out");
                            String choice2;
                            choice2 = scanner.next();
                            if (choice2.equals("1")) {
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                instapayAccount.transfer(amount);

                            } else if (choice2.equals("2")) {
                                WalletAccount walletAccount1 = new WalletAccount();
                                Context context = new Context(walletAccount1);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount, instapayAccount);

                            } else if (choice2.equals("3")) {
                                System.out.println("your balance = " + instapayAccount.InquireBalance());
                            } else if (choice2.equals("4")) {
                                System.out.println("please enter the amount of money that you want to add to your balance:");
                                double amount = scanner.nextDouble();
                                instapayAccount.addtoBalance(amount);
                            } else if (choice2.equals("0")) {
                                flag = false;
                                System.out.println("You have signed out successfully");

                            } else {
                                System.out.println("You have entered invalid button");
                            }
                        }
                        else
                            flag =false;

                    }
                } else
                    System.out.println("You pressed invalid number");
            } else if (choice == 2) {
                    System.out.println("please enter your UserName :  ");
                    String Uname = scanner.next();
                    AppController appController=new AppController();
                    if(appController.checkAccountExistence(Uname)) {
                        int index = database.getAccountIndex(Uname);
                        InstapayAccount instapayAccount = database.getSavedAccounts().get(index);
                        System.out.println("please enter your Password :  ");
                        String pass = scanner.next();
                        System.out.println("please enter your Mobile Number :  ");
                        String number = scanner.next();
                        if (instapayAccount.signin(Uname, pass, number)) {
                            int temp = database.getAccountIndex(Uname);
                            instapayAccount = database.getSavedAccounts().get(temp);
                            String choice1;
                            boolean flag1 = true;
                            while (flag1) {
                                System.out.println("press 1 if you want to transfer to another Instapay account");
                                System.out.println("press 2 if you want to transfer to a Bank account");
                                System.out.println("press 3 if you want to transfer to a Wallet  account");
                                System.out.println("press 4 if you want to view your balance");
                                System.out.println("press 5 if you want to increase your balance");
                                System.out.println("press 0 if you want to Sign out");
                                choice1 = scanner.next();
                                if (choice1.equals("1")) {
                                    System.out.println("please enter the amount of money that you want to transfer:");
                                    double amount = scanner.nextDouble();
                                    instapayAccount.transfer(amount);
                                } else if (choice1.equals("2")) {
                                    if(instapayAccount.getType().equals("Bank account")) {
                                        BankAccount bankAccount1 = new BankAccount();
                                        Context context = new Context(bankAccount1);
                                        System.out.println("please enter the amount of money that you want to transfer:");
                                        double amount = scanner.nextDouble();
                                        context.ChooseTransference(amount, instapayAccount);
                                    }
                                    else
                                        System.out.println("You are not allowed to do this feature as this account is not associated with Bank account ");
                                } else if (choice1.equals("3")) {
                                    WalletAccount walletAccount1 = new WalletAccount();
                                    Context context = new Context(walletAccount1);
                                    System.out.println("please enter the amount of money that you want to transfer:");
                                    double amount = scanner.nextDouble();
                                    context.ChooseTransference(amount, instapayAccount);

                                } else if (choice1.equals("4")) {
                                    System.out.println("your balance = " + instapayAccount.InquireBalance());

                                } else if (choice1.equals("5")) {
                                    System.out.println("please enter the amount of money that you want to add to your balance:");
                                    double amount = scanner.nextDouble();
                                    instapayAccount.addtoBalance(amount);
                                } else if (choice1.equals("0")) {
                                    flag1 = false;
                                    System.out.println("You have signed out successfully");
                                } else {
                                    System.out.println("You have entered invalid button");
                                }
                            }
                        }
                    }
                }
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
