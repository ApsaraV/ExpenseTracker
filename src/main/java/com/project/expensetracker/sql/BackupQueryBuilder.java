package com.project.expensetracker.sql;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BackupQueryBuilder {

    public static Query buildQuery(EntityManager entityManager) {
        return entityManager.createNativeQuery(getBackupQueryString());
    }

    private static String getBackupQueryString() {
        return "BACKUP TO 'mydatabase.zip'";
    }
}
