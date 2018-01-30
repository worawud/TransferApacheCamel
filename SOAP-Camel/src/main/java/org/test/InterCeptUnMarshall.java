package org.test;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import ws.soap.GetUserNameResponse;

public class InterCeptUnMarshall implements Processor {

	  public void process(Exchange exchange) throws Exception {

		  Message inMessage = exchange.getIn();
		  GetUserNameResponse xmlResponse =  (GetUserNameResponse) inMessage.getBody(GetUserNameResponse.class);
		  System.out.println("XML Response:"+xmlResponse.getReturn());
		  
//		  
//		  JAXBContext jaxbContext = JAXBContext.newInstance(HelloWorldResponse.class);
//		  Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//		  StringReader reader = new StringReader(xmlResponse);
//		  HelloWorldResponse responeAfterUnmarshal = (HelloWorldResponse) unmarshaller.unmarshal(reader);
//		  logger.info("ResponeAfterUnmarshal:"+responeAfterUnmarshal.toString());
	}
	  
}
