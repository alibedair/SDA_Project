package BillFactory;

public class Electrictybill extends Bill {
    private String TypeOfConsume;
    private String NoOfContainer;

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
}