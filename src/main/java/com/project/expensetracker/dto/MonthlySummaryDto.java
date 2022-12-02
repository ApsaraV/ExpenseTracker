package com.project.expensetracker.dto;

import java.util.List;

public class MonthlySummaryDto {

    private long totalIncome;

    private long totalExpense;

    private long balance;

    List<DailySummaryDto> dailySummaryList;

    public long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(long totalExpense) {
        this.totalExpense = totalExpense;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<DailySummaryDto> getDailySummaryList() {
        return dailySummaryList;
    }

    public void setDailySummaryList(List<DailySummaryDto> dailySummaryList) {
        this.dailySummaryList = dailySummaryList;
    }
}
