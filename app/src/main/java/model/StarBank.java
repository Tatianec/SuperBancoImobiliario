package model;

public class StarBank {

    private static StarBank instance = null;

    public StarBank() {
    }

    public static StarBank getInstance(){
        if(instance == null){
            instance = new StarBank();
        }
        return instance;
    }

    public void starCreditCards(){}

    public void roundCompleted(CreditCard creditCard, double value){

    }

    public boolean transfer(CreditCard payer, CreditCard receiver, double value){
        return true;
    }

    public void receive(CreditCard card, double value){}

    public boolean pay(CreditCard card, double value){
        return true;
    }
}
