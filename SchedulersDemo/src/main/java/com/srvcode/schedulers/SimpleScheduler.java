package com.srvcode.schedulers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduler {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
/*	
	
	@Scheduled(fixedRate=3000)
	public void ScheduledFixedRateLookup() {
		System.out.println("The time is now: " + dateFormat.format(new Date()));
	}
	
	@Scheduled(fixedDelay=3000)
	public void ScheduledDelayedLookup() throws InterruptedException {
		System.out.println("The time is now: " + dateFormat.format(new Date()));
		Thread.sleep(5000);
	}
	
	@Scheduled(fixedRate=3000, initialDelay = 5000)
	public void ScheduledInitialDelayLookup() throws InterruptedException {
		System.out.println("The time is now: " + dateFormat.format(new Date()));
		Thread.sleep(5000);
	}
	
*/
	@Scheduled(fixedRateString="${scheduler.rate}")
	public void ScheduledfixedRateStringLookup() throws InterruptedException {
		System.out.println("The time is now: " + dateFormat.format(new Date()));
	}
}
