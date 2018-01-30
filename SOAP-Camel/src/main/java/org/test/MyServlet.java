/*
 * #%L
 * Wildfly Camel
 * %%
 * Copyright (C) 2013 - 2015 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.test;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.GetWeather;
import net.webservicex.GetWeatherResponse;
import ws.soap.GetUserName;
import ws.soap.GetUserNameResponse;

@WebServlet(name = "HttpServiceServlet", urlPatterns = { "/*" }, loadOnStartup = 1)
public class MyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "java:jboss/camel/context/jaxws-hello-world-cxf")
	private CamelContext camelContext;


	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
    	ServletOutputStream out = res.getOutputStream();
    	System.out.println("fname"+fname);
    	System.out.println("lname"+lname);
        ProducerTemplate producer = camelContext.createProducerTemplate();        
        GetUserName reqws = new GetUserName();
        reqws.setArg0(fname);
        reqws.setArg1(lname);
        GetUserNameResponse result = producer.requestBody("direct:start", reqws, GetUserNameResponse.class);
        
      	System.out.println(result.getReturn());
      	out.println(result.getReturn());
    	
    }
}
