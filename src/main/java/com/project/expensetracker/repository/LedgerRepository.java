package com.project.expensetracker.repository;

import com.project.expensetracker.model.Ledger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepository extends CrudRepository<Ledger, Integer> {
}
