package entities;

public final class SavingsAccount extends Account {

    private Double interestRate;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(String number, String holder, Double firstDeposit, Double interestRate){
        super(number, holder, firstDeposit);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance(){
        balance += balance * (interestRate / 100.0);
    }

    @Override
    public final void withdraw(Double amount) {
        balance -= amount;
    }
}
