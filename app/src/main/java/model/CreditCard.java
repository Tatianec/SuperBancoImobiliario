package model;

public class CreditCard {
    private int id = 0;
    private double balance;
    private static int[] LAST_CASR_ID = { 1 };

    public CreditCard() {
        this.id = this.LAST_CASR_ID[0];
        this.balance = 15000.00;
        this.LAST_CASR_ID[0]++;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public int getLastCasrID() {
        return LAST_CASR_ID[0];
    }


    public void creditValue(double value) {
        balance += value;
    }

    public void debitValue(double value) throws Exception {
        try {
            if ( this.balance >= value ) {
                this.balance = this.balance - value;
            }
        } catch ( Exception ex ) {
            throw new Exception("Saldo insuficiente");
        }
    }

}
