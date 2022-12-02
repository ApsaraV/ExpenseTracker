package com.project.expensetracker.util;

import com.project.expensetracker.model.TransactionDetails;

import java.util.List;

public class Transactionutil {

    public static Double getTotal(List<TransactionDetails> transactionDetailsList) {
        return transactionDetailsList.stream().mapToDouble(TransactionDetails::getAmount).sum();
    }
}
