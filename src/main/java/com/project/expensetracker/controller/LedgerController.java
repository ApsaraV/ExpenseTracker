package com.project.expensetracker.controller;

import com.project.expensetracker.dto.TransactionDto;
import com.project.expensetracker.model.Ledger;
import com.project.expensetracker.model.Profile;
import com.project.expensetracker.model.TransactionDetails;
import com.project.expensetracker.service.TransactionService;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<Object> addLedger(@RequestBody Profile profile) {
        try {
            transactionService.addLedger(profile);
            return ResponseEntity.ok().body("Ledger added successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error adding ledger");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateLedger(@RequestBody Ledger ledger) {
        try {
            transactionService.updateLedger(ledger);
            return ResponseEntity.ok().body("Ledger updated successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating ledger");
        }
    }

    @DeleteMapping("/delete/{ledgerId}")
    public ResponseEntity<Object> deleteLedger(@PathVariable int ledgerId) {
        try {
            transactionService.deleteLedger(ledgerId);
            return ResponseEntity.ok().body("Ledger deleted Successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting ledger");
        }
    }

    @PostMapping("/addTransaction")
    public ResponseEntity<Object> addTransaction(@RequestBody Ledger ledger) {
        try {
            transactionService.addTransaction(ledger);
            return ResponseEntity.ok().body("Transaction added successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error adding Transaction");
        }
    }

    @PutMapping("/updateTransaction")
    public ResponseEntity<Object> updateTransaction(@RequestBody TransactionDetails transactionDetails) {
        try {
            transactionService.updateTransaction(transactionDetails);
            return ResponseEntity.ok().body("Transaction updated successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating Transaction");
        }
    }

    @DeleteMapping("/deleteTransaction/{transactionId}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable int transactionId) {
        try {
            transactionService.deleteTransaction(transactionId);
            return ResponseEntity.ok().body("Transaction deleted Successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting Transaction");
        }
    }

    @GetMapping("/dailySummary")
    public ResponseEntity<TransactionDto> getDailySummary(@RequestParam String date) {
        Date dateObj = ISODateTimeFormat.basicDate().parseDateTime(date).toDate();
        TransactionDto transactionDto = transactionService.getDailySummary(dateObj);
        return ResponseEntity.ok(transactionDto);
    }

}
