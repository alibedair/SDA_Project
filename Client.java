import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Payment System!");
        System.out.println("Please choose a payment method:");
        System.out.println("1. Vodafone Cash");
        System.out.println("2. Fawry");
        System.out.println("3. Bank wallet");
        Transference transference;
        WalletProviders wp;
        int amount;
        int choice=scanner.nextInt();
        if (choice == 1) {
            System.out.println("You have chosen to pay with  vodafone cash. Please provide amount of payment.");
            amount=scanner.nextInt();
            wp=new VodafoneCash();
            transference=new MobileWallet(wp);
            transference.transfere(amount);
              
        } else if (choice == 2) {
            System.out.println("You have chosen to pay with fawry. Please enter amount of payement ");
            amount=scanner.nextInt();
            wp=new Fawry();
            transference=new MobileWallet(wp);
            transference.transfere(amount);
              
        } 
        else if (choice==3) {
            System.out.println("You have chosen to pay with visa. Please enter amount of payement ");
            amount=scanner.nextInt();
            wp=new CIB_Bank();
            transference=new MobileWallet(wp);
            transference.transfere(amount);
              
        }
        else
        {
             System.out.println("please enter valid choice ");
        }

        scanner.close();
    }
}
    
