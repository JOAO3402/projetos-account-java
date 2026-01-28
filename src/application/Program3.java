package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program3 {

    public static void main(String[] args) {

        Account acc1 = new Account("1234", "Alex", 1000.0);
        acc1.withdraw(200.0);
        System.out.println("Saldo de Alex: " + String.format("%.2f", acc1.getBalance()));

        Account acc2 = new SavingsAccount("1345", "Maria", 1000.0, 3.0);
        acc2.withdraw(200.0);
        System.out.println("Saldo de Maria: " + String.format("%.2f", acc2.getBalance()));

        Account acc3 = new BusinessAccount("5678", "Bob", 1000.0, 500.0);
        acc3.withdraw(200.0);
        System.out.println("Saldo de Bob: " + String.format("%.2f", acc3.getBalance()));
    }
}
