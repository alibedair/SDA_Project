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
        int choice;
        System.out.print("please press 1 to SignUp or press 2 to Signin :  ");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        if(choice==1) {
            System.out.print("press 1 to Signup with bank account or 2 to Signup with Wallet account : ");
            int button = scanner.nextInt();
            InstapayAccount instapayAccount;
            if (button == 1) {
                instapayAccount = new AccountWithBank();
                System.out.println("please enter your Mobile number associated with the Bank :");
                String number = scanner.next();
                if(instapayAccount.signup(number)){
                    String choice1;
                    boolean flag = true;
                    while (flag) {
                        System.out.println("press 1 if you want to transfer to another Instapay account");
                        System.out.println("press 2 if you want to transfer to a Bank account");
                        System.out.println("press 3 if you want to transfer to a Wallet  account");
                        System.out.println("press 4 if you want to view your balance");
                        System.out.println("press 5 if you want to increase your balance");
                        System.out.println("press 0 if you want to Sign out");
                        choice1 = scanner.next();
                        if (choice1.equals("1")){
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            instapayAccount.transfer(amount);
                        } else if (choice1.equals("2")) {
                            BankAccount bankAccount1 = new BankAccount() ;
                            Context context = new Context(bankAccount1);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount,instapayAccount);

                        } else if (choice1.equals("3")) {
                            WalletAccount walletAccount1 = new WalletAccount();
                            Context context = new Context(walletAccount1);
                            System.out.println("please enter the amount of money that you want to transfer:");
                            double amount = scanner.nextDouble();
                            context.ChooseTransference(amount,instapayAccount);

                        } else if (choice1.equals("4")) {
                            System.out.println("your balance = "+instapayAccount.InquireBalance());

                        }else if(choice1.equals("5")){
                            System.out.println("please enter the amount of money that you want to add to your balance:");
                            double amount = scanner.nextDouble();
                            instapayAccount.addtoBalance(amount);
                        }
                        else if (choice1.equals("0")) {
                            flag = false;
                            System.out.println("You have signed out successfully");
                            System.out.println("We will miss you");
                        }
                        else {
                            System.out.println("You have entered invalid button");
                        }
                    }
                }
            } else if (button == 2) {
                instapayAccount = new AccountWithWallet();
                System.out.println("please enter your Mobile number associated with the Wallet :");
                String number = scanner.next();
                if(instapayAccount.signup(number)){

                }
            } else
                System.out.println("You pressed invalid number");
        }
            else if(choice==2){
                System.out.print("press 1 to Signin with bank account or 2 to Signin with Wallet account : ");
                InstapayAccount instapayAccount;
                int button = scanner.nextInt();
                if(button==1){
                    instapayAccount = new AccountWithBank();
                    System.out.println("please enter your user Name :");
                    String un = scanner.next();
                    System.out.println("please enter your password :");
                    String pw = scanner.next();
                    if(instapayAccount.signin(un,pw)){
                        String choice1;
                        boolean flag = true;
                        while (flag) {
                            System.out.println("press 1 if you want to transfer to another Instapay account");
                            System.out.println("press 2 if you want to transfer to a Bank account");
                            System.out.println("press 3 if you want to transfer to a Wallet  account");
                            System.out.println("press 4 if you want to view your balance");
                            System.out.println("press 5 if you want to increase your balance");
                            System.out.println("press 0 if you want to Sign out");
                            choice1 = scanner.next();
                            if (choice1.equals("1")){
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                instapayAccount.transfer(amount);
                            } else if (choice1.equals("2")) {
                                BankAccount bankAccount1 = new BankAccount() ;
                                Context context = new Context(bankAccount1);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount,instapayAccount);
                            } else if (choice1.equals("3")) {
                                WalletAccount walletAccount1 = new WalletAccount();
                                Context context = new Context(walletAccount1);
                                System.out.println("please enter the amount of money that you want to transfer:");
                                double amount = scanner.nextDouble();
                                context.ChooseTransference(amount,instapayAccount);

                            } else if (choice1.equals("4")) {
                                System.out.println("your balance = "+instapayAccount.InquireBalance());

                            }else if(choice1.equals("5")){
                                System.out.println("please enter the amount of money that you want to add to your balance:");
                                double amount = scanner.nextDouble();
                                instapayAccount.addtoBalance(amount);
                            }
                            else if (choice1.equals("0")) {
                                flag = false;
                                System.out.println("You have signed out successfully");
                                System.out.println("We will miss you");
                            }
                            else {
                                System.out.println("You have entered invalid button");
                            }
                        }
                    }
                }
                if(button==2){
                    instapayAccount = new AccountWithWallet();
                    System.out.println("please enter your user Name :");
                    String un = scanner.next();
                    System.out.println("please enter your password :");
                    String pw = scanner.next();
                    if(instapayAccount.signin(un,pw)){

                    }
                }
        }
            System.out.println("Accounts of Banks:");
            database.printBankAccounts();
        System.out.println("Accounts of instapay:");
            database.printSavedAccounts();
        System.out.println("Accounts of Wallet providers:");
            database.printWalletAccounts();
    }
}
    
