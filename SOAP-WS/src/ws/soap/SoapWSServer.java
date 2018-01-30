package ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SoapWSServer {
	
	@WebMethod
	public String getUserName(String name,String lname) {
		System.out.println(name+" "+lname);
		return name+" "+lname;
	}
	
	

}
