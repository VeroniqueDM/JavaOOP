package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ConstantMessages.*;
import static bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private LoanRepository loanRepository;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loanRepository = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
        } else if (type.equals("BranchBank")) {
            bank = new BranchBank(name);
        } else {
            throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }
        this.banks.add(bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        if (type.equals("StudentLoan")) {
            loan = new StudentLoan();
        } else if (type.equals("MortgageLoan")) {
            loan = new MortgageLoan();
        } else {
            throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
        this.loanRepository.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Bank bank = this.banks.stream().filter(bank1 -> bank1.getName().equals(bankName)).findFirst().orElse(null);
        Loan loan = this.loanRepository.findFirst(loanType);
        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }
        bank.addLoan(loan);
        this.loanRepository.removeLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Bank bank = this.banks.stream().filter(bank1 -> bank1.getName().equals(bankName)).findFirst().orElse(null);
        Client client;
        if (clientType.equals("Student")) {
            client = new Student(clientName, clientID, income);
        } else if (clientType.equals("Adult")) {
            client = new Adult(clientName, clientID, income);
        } else {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        if ((bank.getClass().getSimpleName().equals("CentralBank") && clientType.equals("Student")) ||
                (bank.getClass().getSimpleName().equals("BranchBank") && clientType.equals("Adult"))
        ) {
            return UNSUITABLE_BANK;
        }
        bank.addClient(client);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = this.banks.stream().filter(bank1 -> bank1.getName().equals(bankName)).findFirst().orElse(null);
        double sum = bank.getClients().stream().mapToDouble(Client::getIncome).sum() +
                bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        return String.format(FUNDS_BANK, bankName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.banks.stream().map(Bank::getStatistics).collect(Collectors.joining(System.lineSeparator())));
        return stringBuilder.toString();
    }
}
