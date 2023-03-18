package com.srvcode.async.controller;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.srvcode.async.Model.User;
import com.srvcode.async.service.LookupService;

/*
 * CommandLineRunner indicates that once this bean has been instantiated,
 * it should run/execute
 */

@Component
public class LookupAppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(LookupAppRunner.class);
	
	@Autowired
	private LookupService lookupService;
	
	@Override
	public void run(String... args) throws Exception {
		CompletableFuture<User> info1 = lookupService.findUser("Pytorch");
		CompletableFuture<User> info2 = lookupService.findUser("Tensorflow");
		
		CompletableFuture<User> info3 = lookupService.findUser("Scikit-learn");
		CompletableFuture<User> info4 = lookupService.findUser("spring-boot");

		CompletableFuture<User> info5 = lookupService.findUser("spring-mvc");
		CompletableFuture<User> info6 = lookupService.findUser("spring-security");
		
		/*
		 * This method CompletableFuture.allOf(info1, info2, info3, info4, info5, info6).join()
		 * ensures that all of the lookup operations will be completed before we get to this point.
		 */
		CompletableFuture.allOf(info1, info2, info3, info4, info5, info6).join();
		
		logger.info("-->" + info1.get());
		logger.info("-->" + info2.get());
		logger.info("-->" + info3.get());
		logger.info("-->" + info4.get());
		logger.info("-->" + info5.get());
		logger.info("-->" + info6.get());
	}
}
