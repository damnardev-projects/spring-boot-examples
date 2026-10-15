package fr.damnardev.spring.example.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronTask {

	private static final Logger logger = LoggerFactory.getLogger(CronTask.class);

	@Scheduled(cron = Constants.CRON)
	public void execute() throws InterruptedException {
		logger.info("[CRON] Task executed");
		Thread.sleep(Constants.SLEEP);
	}

}
