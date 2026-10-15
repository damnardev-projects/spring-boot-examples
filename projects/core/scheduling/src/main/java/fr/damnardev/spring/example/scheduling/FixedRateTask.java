package fr.damnardev.spring.example.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRateTask {

	private static final Logger logger = LoggerFactory.getLogger(FixedRateTask.class);

	@Scheduled(fixedRate = Constants.DELAY)
	public void execute() throws InterruptedException {
		logger.info("[FIXED RATE] Task executed");
		Thread.sleep(Constants.SLEEP);
	}

}
