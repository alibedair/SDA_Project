
    public  class MobileWallet implements Transference {

        WalletProviders walletproviders;
        int amount;
        public MobileWallet(WalletProviders walletproviders)
        {
            this.walletproviders=walletproviders;
        }
        
            @Override
            public void transfere(int amount) {
                System.out.print("amount payed using ");
                walletproviders.transferwallet(amount);
            } 
        }
        
        
        

