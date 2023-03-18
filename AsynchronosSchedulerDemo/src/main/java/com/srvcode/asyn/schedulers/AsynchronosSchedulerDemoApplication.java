package com.srvcode.asyn.schedulers;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
/*
 *  @EnableAsync turns on spring's ability to run asynchronous method
 *  in background thread pool.
 */
@EnableAsync
@EnableScheduling
public class AsynchronosSchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronosSchedulerDemoApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);	// Two threads are running simultaneously
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookup-");
		executor.initialize();
		
		return executor;
	}
	
}
