package WalletFactory;

public class WalletFactory {
    public WalletProviders createWallet(String type){
        if(type.equals("Electronic payment"))
            return new ElectronicPayment();
        else if(type.equals("Telecommunication company"))
            return new TelecommunicationCompany();
        else if(type.equals("Bank wallet"))
            return new BankWallet();
        else
            return null;
    }
}
