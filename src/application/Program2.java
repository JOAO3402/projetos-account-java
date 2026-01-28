package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program2 {
    public static void main(String[] args) {

        Account acc = new Account("1234", "Alex", 1000.0);
        BusinessAccount bacc = new BusinessAccount("5678", "Maria", 2000.0, 500.0);

        Account acc1 = bacc;
        Account acc2 = new BusinessAccount("9012", "Bob", 3000.0, 1000.0);
        Account acc3 = new SavingsAccount("3456", "Anna", 4000.0, 2.5);


        BusinessAccount acc4 = (BusinessAccount)acc2;
        acc4.loan(500.0);

        // BusinessAccount acc5 = (BusinessAccount)acc3;

        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Empréstimo realizado!");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Atualização de saldo realizada!");
        }
    }
}
