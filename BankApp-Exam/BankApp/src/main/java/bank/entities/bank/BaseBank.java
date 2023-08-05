package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ExceptionMessages.*;

public abstract class BaseBank implements Bank {

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (this.clients.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        this.clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
//        "Name: {bankName}, Type: {bankType}
//        Clients: {clientName1}, {clientName2} ... / Clients: none
//        Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}"

        stringBuilder.append(
                String.format("Name: %s, Type: %s",
                        this.getName(),this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        stringBuilder.append("Clients: ")
                .append(this.clients.isEmpty()
                        ? "none"
                        : this.clients.stream().map(Client::getName).collect(Collectors.joining(", ")))
                .append(System.lineSeparator());
        stringBuilder.append("Loans: ")
                .append(this.loans.size())
                .append(", Sum of interest rates: ")
                .append(this.sumOfInterestRates());

        return stringBuilder.toString();
    }
}
