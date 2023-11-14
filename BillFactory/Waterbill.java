package BillFactory;

public class Waterbill extends Bill {
private String literConsumed;

    public String getLiterConsumed() {
        return literConsumed;
    }

    public Waterbill() {
        ispaid=false;
        literConsumed = "5 liters";
    }

    public void setLiterConsumed(String literConsumed) {
        this.literConsumed = literConsumed;
    }

    @Override
    public void print() {
        System.out.println("Total due : "+amount);
        System.out.println("month : "+month);
        System.out.println("Date : "+duedate);
        System.out.println("# of liters consumed : "+literConsumed);
        if(ispaid==false)
            System.out.println("The bill is not paid yet");
        else
            System.out.println("The bill is paid");
    }
}