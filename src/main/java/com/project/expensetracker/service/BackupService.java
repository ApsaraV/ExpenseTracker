package com.project.expensetracker.service;

import com.project.expensetracker.sql.BackupQueryBuilder;
import com.project.expensetracker.util.DriveUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class BackupService {

    @PersistenceContext
    EntityManager entityManager;

    public void backupDB() {
        BackupQueryBuilder.buildQuery(entityManager).executeUpdate();
    }

    public void uploadToGoogleDrive() {
        try {
            backupDB();
            DriveUtil.upload();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
