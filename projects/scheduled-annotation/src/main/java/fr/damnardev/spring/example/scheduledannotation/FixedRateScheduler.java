package fr.damnardev.spring.example.scheduledannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRateScheduler {

	private static final Logger logger = LoggerFactory.getLogger(FixedRateScheduler.class);

	/*
	 * Create a scheduled task that runs at a fixed rate of 5 seconds compared to the start time of the previous execution.
	 */
	@Scheduled(fixedRate = 5000)
	public void scheduledTaskWithFixedRate() throws InterruptedException {
		logger.info("[FIXED RATE] Task executed");
		Thread.sleep(3000); // Simulate a long-running task
	}

}
