package WalletFactory;

public class WalletFactory {
    public WalletProviders createWallet(String type,String mn,String t){
        if(type.equals("Electronic payment"))
            return new ElectronicPayment(mn,t);
        else if(type.equals("Telecommunication company"))
            return new TelecommunicationCompany(mn,t);
        else if(type.equals("Bank wallet"))
            return new BankWallet(mn,t);
        else
            return null;
    }

    public WalletFactory() {
    }
}
