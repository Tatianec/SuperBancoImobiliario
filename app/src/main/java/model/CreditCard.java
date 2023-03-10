package model;

public class CreditCard {
    private int id;
    private double balance = 15.000;
    private int lastCasrIf;

    public CreditCard(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.lastCasrIf += 1;
    }

    public void creditValue(double value) {
        balance += value;
    }

    public void debitValue(double value) {
        try {
            if ( this.balance <= value ) {
                balance = balance - value;
            }
        } catch ( Exception ex ) {

        }
    }

}
