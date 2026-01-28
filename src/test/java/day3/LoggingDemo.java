package day3;

import static io.restassured.RestAssured.given;


import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class LoggingDemo {
	
	
	@Test
	void testCookies()
	{
		
		given()
		
		.when()
		  .get("https://www.google.com/")
		  
		

		 .then() 
		    
		 //  .log().all()
		   .log().body()
		 //  .log().cookies()
		   .log().headers();
	  
		
	}
	
	
	


}
