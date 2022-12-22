package com.camunda.training;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDelegate implements JavaDelegate {
	private final Logger LOGGER = LoggerFactory.getLogger(LogDelegate.class.getName());

	public void execute(DelegateExecution execution) throws Exception {

		String response = (String) execution.getVariable("response");
		
		LOGGER.info("Webservice response: " + response);
			
	}
	
}