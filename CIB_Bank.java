public class CIB_Bank implements WalletProviders {

    @Override
    public void transferwallet(int amount) {
        System.out.println("Paying using Bank wallet"+ amount);
    }
    
}
