package com.srvcode.asyn.schedulers.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.srvcode.asyn.schedulers.model.User;
import com.srvcode.asyn.schedulers.service.LookupService;

@Component
public class LookupController {

	private static final Logger logger = LoggerFactory.getLogger(LookupController.class);
	
	@Autowired
	private LookupService lookupService;
	
	private static int userIndex = 0;
	private static final List<String> userList = new ArrayList<>();
	
	static {
		userList.add("Pytorch");
		userList.add("Tensorflow");
		userList.add("Scikit-learn");
		userList.add("spring-boot");
		userList.add("spring-mvc");
	}
	
	@Scheduled(fixedRate = 2000)
	public void scheduledTasks() throws Exception  {
		CompletableFuture<User> info = lookupService.findUser(userList.get(userIndex));
		userIndex = (userIndex + 1) % userList.size();
		logger.info("-->" + info.get());
	}
}
