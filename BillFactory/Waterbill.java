package BillFactory;

public class Waterbill extends Bill {
private String literConsumed;

    public String getLiterConsumed() {
        return literConsumed;
    }

    public Waterbill() {
        literConsumed = "5 liters";
        amount = 70;
        month = " May";
    }

    public void setLiterConsumed(String literConsumed) {
        this.literConsumed = literConsumed;
    }

    @Override
    public void print() {
        System.out.println("Total due : "+amount);
        System.out.println("month : "+month);
        System.out.println("# of liters consumed : "+literConsumed);
    }
}