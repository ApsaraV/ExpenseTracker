package com.project.expensetracker.dto;

import com.project.expensetracker.model.TransactionDetails;

import java.util.Date;
import java.util.List;

public class DailySummaryDto {

    Date date;

    private Double totalIncome;

    private Double totalExpense;

    private long balance;

    List<TransactionDetails> debitTransactions;

    List<TransactionDetails> creditTransactions;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<TransactionDetails> getDebitTransactions() {
        return debitTransactions;
    }

    public void setDebitTransactions(List<TransactionDetails> debitTransactions) {
        this.debitTransactions = debitTransactions;
    }

    public List<TransactionDetails> getCreditTransactions() {
        return creditTransactions;
    }

    public void setCreditTransactions(List<TransactionDetails> creditTransactions) {
        this.creditTransactions = creditTransactions;
    }
}
