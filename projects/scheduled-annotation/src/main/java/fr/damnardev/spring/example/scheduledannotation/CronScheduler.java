package fr.damnardev.spring.example.scheduledannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {

	private static final Logger logger = LoggerFactory.getLogger(CronScheduler.class);

	/*
	 * Create a scheduled task that runs every 5 seconds using a cron expression.
	 */
	@Scheduled(cron = "*/5 * * * * *")
	public void scheduledTaskWithCron() throws InterruptedException {
		logger.info("[CRON] Task executed");
		Thread.sleep(3000); // Simulate a long-running task
	}

}
