package com.project.expensetracker.service;

import com.project.expensetracker.dto.DailySummaryDto;
import com.project.expensetracker.dto.TransactionDto;
import com.project.expensetracker.model.Ledger;
import com.project.expensetracker.model.Profile;
import com.project.expensetracker.model.TransactionDetails;
import com.project.expensetracker.repository.LedgerRepository;
import com.project.expensetracker.repository.ProfileRepository;
import com.project.expensetracker.repository.TransactionRepository;
import com.project.expensetracker.sql.GetAllTransactionByDate;
import com.project.expensetracker.util.Transactionutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    LedgerRepository ledgerRepository;

    @PersistenceContext
    EntityManager entityManager;

    public void addLedger(Profile profile) {
        Profile profileToupdate = profileRepository.findById(profile.getProfileId()).orElse(null);
        if (profileToupdate != null) {
            profile.getLedgerList().forEach(ledger -> ledger.setProfile(profileToupdate));
            profileToupdate.getLedgerList().addAll(profile.getLedgerList());
            profileRepository.save(profileToupdate);
        }
    }

    public void updateLedger(Ledger ledger) {
        Optional<Ledger> optionalLedger = ledgerRepository.findById(ledger.getId());
        if (optionalLedger.isPresent()) {
            Ledger ledgerToUpdate = optionalLedger.get();
            ledgerToUpdate.setCurrency(ledger.getCurrency());
            ledgerToUpdate.setName(ledger.getName());
            ledgerToUpdate.setDescription(ledger.getDescription());
            ledgerRepository.save(ledgerToUpdate);
        }
    }

    public void deleteLedger(int ledgerId) {
        ledgerRepository.deleteById(ledgerId);
    }

    public void addTransaction(Ledger ledger) {
        Ledger ledgerDB = ledgerRepository.findById(ledger.getId()).get();
        ledger.getTransactionDetailsList().forEach(transactionDetails -> transactionDetails.setLedger(ledgerDB));
        ledgerDB.getTransactionDetailsList().addAll(ledger.getTransactionDetailsList());
        ledgerRepository.save(ledgerDB);
    }

    public void updateTransaction(TransactionDetails transactionDetails) {
        TransactionDetails details = transactionRepository.findById(transactionDetails.getId()).get();
        details.setAmount(transactionDetails.getAmount());
        details.setDescription(transactionDetails.getDescription());
        details.setRemark(transactionDetails.getRemark());
        details.setType(transactionDetails.getType());
        transactionRepository.save(details);
    }

    public void deleteTransaction(int transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Transactional
    public TransactionDto getDailySummary(Date dateObj) {
        TransactionDto transactionDto = new TransactionDto();
        DailySummaryDto dailySummaryDto = new DailySummaryDto();
        List<TransactionDetails> transactionDetailsList = GetAllTransactionByDate.createQuery(entityManager, dateObj).getResultList();
        List<TransactionDetails> creditTransactions = transactionDetailsList.parallelStream().filter(transactionDetails -> "INCOME".equals(transactionDetails.getType())).collect(Collectors.toList());
        List<TransactionDetails> debitTransactions = transactionDetailsList.parallelStream().filter(transactionDetails -> "EXPENSE".equals(transactionDetails.getType())).collect(Collectors.toList());
        dailySummaryDto.setCreditTransactions(creditTransactions);
        dailySummaryDto.setDebitTransactions(debitTransactions);
        dailySummaryDto.setDate(dateObj);
        dailySummaryDto.setTotalExpense(Transactionutil.getTotal(debitTransactions));
        dailySummaryDto.setTotalIncome(Transactionutil.getTotal(creditTransactions));
        transactionDto.setDailySummary(dailySummaryDto);
        return transactionDto;
    }
}
