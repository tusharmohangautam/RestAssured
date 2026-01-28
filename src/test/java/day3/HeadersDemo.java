package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class HeadersDemo {
	
	// Headers value will always be same in response after every hit of the request.
	// NOTE : Only some Headers information keeps changing not all ...(Eg-> Date, Expires)
	
	
	// Approach 1 = When not storing response in any variable
	
	@Test
	void testHeaders1()
	{
		
		given()
		
		.when()
		  .get("https://www.google.com/")
		  
		 

		 .then() 
		   .header("Content-Type", "text/html; charset=ISO-8859-1")
		   .and()
		   .header("Cache-Control","private, max-age=0")
		   .and()
		   .header("Transfer-Encoding","chunked");
		  // .log().all();
		  
	  
		
	}
	
	// Approach 2 - Storing entire response in a variable - then finding Header Values & Printing
//	@Test
	void testHeaders2()
	{
		
		Response res=
				
		given()
		
		.when()
		  .get("https://www.google.com/");
		  
		
		//  Get Single Header Value

		  String header_value = res.getHeader("Content-Type");
		  System.out.println("Header value :" +" "+header_value);
		  
		  
		// Get all Headers information
		  
		  Headers myheaders = res.getHeaders();
		  
		 
		  
		  for(Header hd : myheaders)
		  {
				
			  System.out.println(hd.getName()+" "+hd.getValue());
			  
		  }
		  
	}	  
		  
/* NOTE : To print Headers values this logic is not much required as we write .log().headers(); 
inside then() method=> It will print all headers information by default */
		
	
	

}
