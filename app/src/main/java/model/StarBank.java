package model;

public class StarBank {

    private static StarBank instance = null;
    CreditCard creditCard;

    public StarBank() {
    }

    public static StarBank getInstance(){
        if(instance == null){
            instance = new StarBank();
        }
        return instance;
    }

    public void starCreditCards(){
        int[] j;
        for ( int i = 1; i < 7; i++ ){
            creditCard = new CreditCard(i, 15.000);
            j = new int[i];
            creditCard.setLastCasrIf(j);
        }

    }

    public void roundCompleted(CreditCard creditCard, double value){
            creditCard.creditValue(value);
    }

    public boolean transfer(CreditCard payer, CreditCard receiver, double value){
        boolean transfer = true;

        try {
            payer.debitValue(value);
            receiver.debitValue(value);
        } catch ( Exception e ) {
            transfer = false;
            throw new RuntimeException(e.getMessage());

        }
        return transfer;
    }

    public void receive(CreditCard card, double value){
        card.creditValue(value);
    }

    public boolean pay(CreditCard card, double value){
        try {
            card.debitValue(value);
        } catch ( Exception e ) {
            throw new RuntimeException(e.getMessage());
        }
        return true;
    }
}
