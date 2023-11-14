package BillFactory;

import Account.InstapayAccount;

abstract public class Bill{
    protected double amount;
    protected String month;
    public  double getamount(){
         return amount;
    }
     public void pay(InstapayAccount instapayAccount) {
         if(amount>instapayAccount.InquireBalance()){
             System.out.println("You do not have enough funds");
             return;
         }
         else {
             double newBalance = instapayAccount.InquireBalance() - amount;
             instapayAccount.setBalance(newBalance);
             System.out.println("Your bill is paid Successfully");
         }
     }
     abstract public void print();
}