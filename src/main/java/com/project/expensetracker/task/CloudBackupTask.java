package com.project.expensetracker.task;

import com.project.expensetracker.service.BackupService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.TimerTask;

public class CloudBackupTask extends TimerTask {

    @Autowired
    BackupService backupService;

    @Override
    public void run() {
        backupService.uploadToGoogleDrive();
    }
}
