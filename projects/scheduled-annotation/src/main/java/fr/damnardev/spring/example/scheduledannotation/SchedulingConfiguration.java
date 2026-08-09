package fr.damnardev.spring.example.scheduledannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class SchedulingConfiguration {

	/*
	 * We are creating a ThreadPoolTaskScheduler bean to manage the scheduling of tasks.
	 */
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(5); // 5 threads to process scheduled tasks concurrently
		scheduler.setThreadNamePrefix("scheduled-task-"); // Prefix for thread names
		scheduler.setAwaitTerminationSeconds(30);
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		scheduler.initialize();
		return scheduler;
	}

}
