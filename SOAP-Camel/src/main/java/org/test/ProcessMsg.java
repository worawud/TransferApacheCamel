package org.test;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import ws.soap.GetUserName;


public class ProcessMsg implements Processor {

	  public void process(Exchange exchange) throws Exception {
		  

		  Message inMessage = exchange.getIn();
		  System.out.println("Message From User:"+inMessage.getBody(GetUserName.class));
		  GetUserName request =  inMessage.getBody(GetUserName.class);
		  System.out.println("Message From Old Name:"+request.getArg0());
		  System.out.println("Message From Old LName:"+request.getArg1());
		  request.setArg0("Pikachu");
		  request.setArg1("Richu");
		  exchange.getIn().setBody(request);

		}
	

}
