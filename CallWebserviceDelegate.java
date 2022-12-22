package com.camunda.training;

import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.HttpRequest;
import org.camunda.connect.httpclient.HttpResponse;
import org.camunda.connect.httpclient.soap.SoapHttpConnector;
import org.camunda.connect.httpclient.soap.SoapHttpRequest;
import org.camunda.connect.httpclient.soap.SoapHttpResponse;
import org.camunda.connect.spi.ConnectorRequest;
import org.camunda.connect.spi.ConnectorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallWebserviceDelegate implements JavaDelegate {
	private final Logger LOGGER = LoggerFactory.getLogger(CallWebserviceDelegate.class.getName());

	public void execute(DelegateExecution execution) throws Exception {
		
		LOGGER.info("Starte Connector test");
		
		String response = testRESTConnector();
		//String response = testSOAPConnector();
		
		execution.setVariable("response", response);
		
		LOGGER.info("Connector test abgeschlossen");
			
	}
	
	//Simple REST-Call without parameters
	public String testRESTConnector() throws InterruptedException {
		LOGGER.info("Starte REST Connector Test");
		
		HttpConnector connector = Connectors.getConnector(HttpConnector.ID);
		
		///*
		//Calling via config methods
		HttpRequest request = connector.createRequest()
				.get()
				.url("http://localhost:8083/helloWorld");
		HttpResponse response = request.execute();
		
		String responseString = response.getResponse();
		//*/
		
		/*
		//Calling via generic API	
		HttpRequest request = connector.createRequest();
		request.setRequestParameter("method", "GET");
		request.setRequestParameter("url", "http://localhost:8083/add?n1=8&n2=9");
		HttpResponse response = request.execute();	
		
		String responseString = response.getResponseParameter("response");
		*/
		
		logRequest(request);
		logResponse(response);
		
		response.close();
		
		return responseString;
	}
	
	public String testSOAPConnector() {
		SoapHttpConnector connector = Connectors.getConnector(SoapHttpConnector.ID);
		
		///*
		SoapHttpRequest request = connector.createRequest()
		  .url("http://localhost:8080/ws")
		  .payload("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n"
		  		+ "				  xmlns:gs=\"http://spring.io/guides/gs-producing-web-service\">\r\n"
		  		+ "   <soapenv:Header/>\r\n"
		  		+ "   <soapenv:Body>\r\n"
		  		+ "      <gs:getCountryRequest>\r\n"
		  		+ "         <gs:name>Spain</gs:name>\r\n"
		  		+ "      </gs:getCountryRequest>\r\n"
		  		+ "   </soapenv:Body>\r\n"
		  		+ "</soapenv:Envelope>");
		SoapHttpResponse response = request.execute();
		
		String responseString = response.getResponse();
		//*/
		
		/*
		SoapHttpRequest request = connector.createRequest();
		request.setRequestParameter("url", "http://localhost:8080/ws");
		request.setRequestParameter("payload", "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n"
		  		+ "				  xmlns:gs=\"http://spring.io/guides/gs-producing-web-service\">\r\n"
		  		+ "   <soapenv:Header/>\r\n"
		  		+ "   <soapenv:Body>\r\n"
		  		+ "      <gs:getCountryRequest>\r\n"
		  		+ "         <gs:name>Spain</gs:name>\r\n"
		  		+ "      </gs:getCountryRequest>\r\n"
		  		+ "   </soapenv:Body>\r\n"
		  		+ "</soapenv:Envelope>");
		SoapHttpResponse response = request.execute();
		
		String responseString = response.getResponseParameter("response");
		*/

		logRequest(request);
		logResponse(response);
		
		response.close();
			
		return responseString;
	}
	
	public void logRequest(ConnectorRequest<?> request) {
		LOGGER.info("Request parameters:");
		Map<String, Object> requestParameters = request.getRequestParameters();
		for(String parameter : requestParameters.keySet()) {
			LOGGER.info("Parameter => " + parameter + ": " + requestParameters.get(parameter));
		}
	}
	
	public void logResponse(ConnectorResponse response) {
		LOGGER.info("Response parameters:");
		Map<String, Object> responseParameters = response.getResponseParameters();
		for(String parameter : responseParameters.keySet()) {
			LOGGER.info("Parameter => " + parameter + ": " + responseParameters.get(parameter));
		}
	}
	
}