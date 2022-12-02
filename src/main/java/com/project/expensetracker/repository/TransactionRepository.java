package com.project.expensetracker.repository;

import com.project.expensetracker.model.TransactionDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionDetails, Integer> {
}
