package fr.damnardev.spring.example.scheduledannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedDelayScheduler {

	private static final Logger logger = LoggerFactory.getLogger(FixedDelayScheduler.class);

	/*
	 * Create a scheduled task that runs with a fixed delay of 5 seconds compared to the completion time of the previous execution.
	 */
	@Scheduled(fixedDelay = 5000)
	public void scheduledTaskWithFixedDelay() throws InterruptedException {
		logger.info("[FIXED DELAY] Task executed");
		Thread.sleep(3000); // Simulate a long-running task
	}

}
