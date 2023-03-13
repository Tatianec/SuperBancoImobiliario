package model;

import android.widget.Toast;

import java.util.ArrayList;

public class StarBank {

    private static StarBank instance = null;

    ArrayList<CreditCard> creditCards = new ArrayList<>();

    public StarBank() {
    }

    public static StarBank getInstance(){
        if(instance == null){
            instance = new StarBank();
        }
        return instance;
    }

    public void starCreditCards(){
        for ( int i = 0; i < 6; i++ ){
            creditCards.add(new CreditCard());
        }
    }
    public CreditCard getCardById(int cardId){
        return this.creditCards.get(cardId);
    }

    public void roundCompleted(CreditCard creditCard, double value){

            creditCard.creditValue(value);
    }

    public boolean transfer(CreditCard payer, CreditCard receiver, double value){
        try {
            payer.debitValue(value);
            receiver.creditValue(value);
        } catch ( Exception e ) {
            return false;
        }

        return true;
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
