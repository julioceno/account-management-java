package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }


    public void withdraw(Double amount) throws DomainException {
        Double serveValue = balance - amount;

        if (amount > withdrawLimit) {
            throw new DomainException("O valor do saque é maior do que o limite de saque permitido.");
        }

        if (amount > balance) {
            throw new DomainException("O valor de saque é maior do que o valor atual da conta.");
        }

        balance = balance - amount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                ", withdrawLimit=" + withdrawLimit +
                '}';
    }
}
