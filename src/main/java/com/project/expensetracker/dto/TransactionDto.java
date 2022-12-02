package com.project.expensetracker.dto;

public class TransactionDto {

    private DailySummaryDto dailySummary;

    private MonthlySummaryDto monthlySummary;

    public DailySummaryDto getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(DailySummaryDto dailySummary) {
        this.dailySummary = dailySummary;
    }

    public MonthlySummaryDto getMonthlySummary() {
        return monthlySummary;
    }

    public void setMonthlySummary(MonthlySummaryDto monthlySummary) {
        this.monthlySummary = monthlySummary;
    }
}

