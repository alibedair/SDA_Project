package BillFactory;

public class Gasbill extends Bill {
  private String reader;

    public String getReader() {
        return reader;
    }

    public Gasbill() {
        reader = "6543";
        amount = 134;
        month = "March";
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    @Override
    public void print() {
        System.out.println("Total due : "+amount);
        System.out.println("month : "+month);
        System.out.println("Reading : "+reader);
    }
}