package application;

import entities.Account;
import entities.SavingsAccount;

public class Program4 {
    public static void main(String[] args) {

        Account x = new Account("001", "Alex", 1000.0);
        Account y = new SavingsAccount("002", "Maria", 1000.0, 1.0);

        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println(x.getBalance());
        System.out.println(y.getBalance());
    }
}
