public class Context {
    private Transference transference;

    public Context(Transference transference) {
        this.transference = transference;
    }
    public void doOperation(String Mobile_no,int amount){
        transference.transfer(Mobile_no,amount);
    };

}
