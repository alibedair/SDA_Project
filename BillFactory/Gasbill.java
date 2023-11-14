package BillFactory;

public class Gasbill extends Bill {
  private String reader;

    public String getReader() {
        return reader;
    }

    public Gasbill() {
        ispaid = false;
        reader = "6543";
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    @Override
    public void print() {
        System.out.println("Total due : "+amount);
        System.out.println("month : "+month);
        System.out.println("Date : "+duedate);
        System.out.println("Reading : "+reader);
        if(ispaid==false)
            System.out.println("The bill is not paid yet");
        else
            System.out.println("The bill is paid");
    }
}