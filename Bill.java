import java.sql.Date;

abstract class Bill{
    private double amount;
    private String month;
    private boolean ispaid;
    private Date duedate;

    public  double getamount(){
         return amount;
    }
    abstract void pay(); // it will be implemented in the Gas , electricty , water 
}