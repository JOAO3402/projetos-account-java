package entities;

public class Account {

    private String number;
    private String holder;
    protected Double balance = 0.0;

    public Account(){
    }

    public Account(String number, String holder, Double firstDeposit){
        this.number = number;
        this.holder = holder;
        this.balance += firstDeposit;
    }

    public Double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public void withdraw(Double amount){
        balance -= amount;
    }

    public void deposit(Double amount){
        balance += amount;
    }
}
