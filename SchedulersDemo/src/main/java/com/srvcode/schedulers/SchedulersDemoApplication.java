package com.srvcode.schedulers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/*
 * @EnableScheduling annotation tells Spring that this particular application
 * will run tasks at scheduled intervals;
 * 
 * This annotation will bring up a task executor to run the scheduled task
 * on a background thread, not on the main thread.
 */
@EnableScheduling
public class SchedulersDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulersDemoApplication.class, args);
	}

}
