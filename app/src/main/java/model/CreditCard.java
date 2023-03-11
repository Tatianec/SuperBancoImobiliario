package model;

public class CreditCard {
    private int id;
    private double balance;
    private int lastCasrIf[];


    public CreditCard(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.lastCasrIf = new int[6];
    }

    public int[] getLastCasrIf() {
        return lastCasrIf;
    }

    public void setLastCasrIf(int[] lastCasrIf) {
        this.lastCasrIf = lastCasrIf;
    }

    public void creditValue(double value) {
        balance += value;
    }

    public void debitValue(double value) throws Exception {
        try {
            if ( this.balance <= value ) {
                balance = balance - value;
            }
        } catch ( Exception ex ) {
            throw new Exception(ex.getMessage());
        }
    }

}
