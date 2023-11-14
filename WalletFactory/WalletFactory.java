package WalletFactory;

public class WalletFactory {
    public WalletProviders createWallet(String type,String mn,String company){
        if(type.equals("Electronic payment"))
            return new ElectronicPayment(mn,company);
        else if(type.equals("Telecommunication company"))
            return new TelecommunicationCompany(mn,company);
        else if(type.equals("Bank wallet"))
            return new BankWallet(mn,company);
        else
            return null;
    }

    public WalletFactory() {
    }
}
