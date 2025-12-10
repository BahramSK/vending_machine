package model;

public abstract class PaymentAcceptor {

    protected int amount;

    public PaymentAcceptor(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract void showMenu();

    public abstract void handleInput();
}
