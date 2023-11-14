package BillFactory;


public class Electrictybill extends Bill {
    private String TypeOfConsume;
    private String NoOfContainer;

    public Electrictybill() {
         TypeOfConsume = "homely";
         NoOfContainer = "4321";
         month = "August";
         amount = 999;
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
        System.out.println("Total due : " + amount);
        System.out.println("month : " + month);
        System.out.println("Type of consume : " + TypeOfConsume);
        System.out.println("# of container : " + NoOfContainer);
    }
}