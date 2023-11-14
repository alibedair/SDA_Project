package BillFactory;

import java.util.Random;

public class Electrictybill extends Bill {
    private String TypeOfConsume;
    private String NoOfContainer;

    public Electrictybill() {
         TypeOfConsume = "homely";
         ispaid = false;
         NoOfContainer = "4321";
    }

    public String getTypeOfConsume() {
        return TypeOfConsume;
    }

    public void setTypeOfConsume(String typeOfConsume) {
        TypeOfConsume = typeOfConsume;
    }

    public String getNoOfContainer() {
        return NoOfContainer;
    }

    public void setNoOfContainer(String noOfContainer) {
        NoOfContainer = noOfContainer;
    }

    @Override
    public void print() {
        System.out.println("Total due : "+amount);
        System.out.println("month : "+month);
        System.out.println("Date : "+duedate);
        System.out.println("Type of consume : "+TypeOfConsume);
        System.out.println("# of container : "+NoOfContainer);
        if(ispaid==false)
            System.out.println("The bill is not paid yet");
        else
            System.out.println("The bill is paid");
    }
}