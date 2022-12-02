package com.project.expensetracker;

import com.project.expensetracker.task.CloudBackupTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Timer;

@SpringBootApplication
public class ExpensetrackerApplication {

	/**
	 * XTrak Application starter
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

	/**
	 * Task to backup XTraK DB every 12 hours
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void startTimerTask() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new CloudBackupTask(), 1000, 51840000);
	}
}