package application;

import java.util.Scanner;
import entities.Account;
import entities.BusinessAccount;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Sistema Bancário ===\n");
        System.out.println("Qual tipo de conta deseja criar?");
        System.out.println("1 - Conta Normal");
        System.out.println("2 - Conta Empresarial");
        System.out.print("Escolha uma opção (1 ou 2): ");
        int opcao = Integer.parseInt(sc.nextLine());
        
        System.out.print("Número da conta: ");
        String number = sc.nextLine();
        
        System.out.print("Nome do titular: ");
        String holder = sc.nextLine();
        
        System.out.print("Deseja fazer um depósito inicial? (s/n): ");
        String resposta = sc.nextLine();
        Double firstDeposit = 0.0;
        
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Valor do depósito inicial: ");
            firstDeposit = Double.parseDouble(sc.nextLine());
        }
        
        if (opcao == 1) {
            Account account = new Account(number, holder, firstDeposit);
            exibirDetalhesAccount(account);
            menuOperacoesAccount(sc, account);
        } else if (opcao == 2) {
            System.out.print("Limite de empréstimo: ");
            Double loanLimit = Double.parseDouble(sc.nextLine());

            BusinessAccount businessAccount = new BusinessAccount(number, holder, firstDeposit, loanLimit);
            exibirDetalhesBusinessAccount(businessAccount);
            menuOperacoesBaccount(sc, businessAccount);
        } else {
            System.out.println("Opção inválida!");
        }
        
        sc.close();
    }
    
    public static void exibirDetalhesAccount(Account account) {
        System.out.println("\n=== Conta Criada com Sucesso ===");
        System.out.println("Tipo: Conta Normal");
        System.out.println("Número: " + account.getNumber());
        System.out.println("Titular: " + account.getHolder());
        System.out.println("Saldo: R$ " + String.format("%.2f", account.getBalance()));
    }
    
    public static void exibirDetalhesBusinessAccount(BusinessAccount account) {
        System.out.println("\n=== Conta Criada com Sucesso ===");
        System.out.println("Tipo: Conta Empresarial");
        System.out.println("Número: " + account.getNumber());
        System.out.println("Titular: " + account.getHolder());
        System.out.println("Saldo: R$ " + String.format("%.2f", account.getBalance()));
        System.out.println("Limite de Empréstimo: R$ " + String.format("%.2f", account.getLoanLimit()));
    }
    
    public static void menuOperacoesAccount(Scanner sc, Account account) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menu de Operações ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int operacao = Integer.parseInt(sc.nextLine());

            switch (operacao) {
                case 1:
                    System.out.print("Valor a depositar: R$ ");
                    Double deposito = Double.parseDouble(sc.nextLine());
                    if (deposito > 0) {
                        account.deposit(deposito);
                        System.out.println("Depósito realizado com sucesso!");
                        System.out.println("Novo saldo: R$ " + String.format("%.2f", account.getBalance()));
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 2:
                    System.out.print("Valor a sacar: R$ ");
                    Double saque = Double.parseDouble(sc.nextLine());
                    if (saque > 0 && saque <= account.getBalance()) {
                        account.withdraw(saque);
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Novo saldo: R$ " + String.format("%.2f", account.getBalance()));
                    } else if (saque > account.getBalance()) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 3:
                    System.out.println("\nSaldo atual: R$ " + String.format("%.2f", account.getBalance()));
                    break;


                case 4:
                    System.out.println("\nObrigado por usar nosso banco! Até logo!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuOperacoesBaccount(Scanner sc, BusinessAccount account) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menu de Operações ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Pegar Emprestimo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int operacao = Integer.parseInt(sc.nextLine());

            switch (operacao) {
                case 1:
                    System.out.print("Valor a depositar: R$ ");
                    Double deposito = Double.parseDouble(sc.nextLine());
                    if (deposito > 0) {
                        account.deposit(deposito);
                        System.out.println("Depósito realizado com sucesso!");
                        System.out.println("Novo saldo: R$ " + String.format("%.2f", account.getBalance()));
                        System.out.println("Crédito Atual: R$ " + String.format("%.2f", account.getLoanLimit()));
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 2:
                    System.out.print("Valor a sacar: R$ ");
                    Double saque = Double.parseDouble(sc.nextLine());
                    if (saque > 0 && saque <= account.getBalance()) {
                        account.withdraw(saque);
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Novo saldo: R$ " + String.format("%.2f", account.getBalance()));
                        System.out.println("Crédito Atual: R$ " + String.format("%.2f", account.getLoanLimit()));
                    } else if (saque > account.getBalance()) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 3:
                    System.out.println("\nSaldo atual: R$ " + String.format("%.2f", account.getBalance()));
                    break;

                case 4:
                    System.out.print("\nDigite o valor do emprestimo: R$ ");
                    Double amount = Double.parseDouble(sc.nextLine());
                    if(amount <= account.getLoanLimit()){
                        account.loan(amount);
                        System.out.println("Emprestimo realizado!");
                        System.out.println("Novo saldo: R$ " + String.format("%.2f", account.getBalance()));
                        System.out.println("Crédito Atual: R$ " + String.format("%.2f", account.getLoanLimit()));
                    } else {
                        System.out.println("Você não tem credito o suficiente, tente outro valor!");
                    }
                    break;

                case 5:
                    System.out.println("\nObrigado por usar nosso banco! Até logo!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}