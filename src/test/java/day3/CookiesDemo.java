package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesDemo {
	
	// Approach 1 = When not storing response in any variable
//	@Test
	void testCookies()
	{
		
		given()
		
		.when()
		  .get("https://www.google.com/")
		  
		 
/*NOTE : We should not hard code the Cookie value and then compare the value because after 
 * each hit Cookie value gets changing - So if we are hard coding our Cookie value then 
 * our method should get failed */

		 .then() 
		   .cookie("AEC" , "AaJma5usZBrDy_jUV-i9gUUc_LNwSs50g74fVnhKj6GksdwTRCjZfmsQzJk")
		   .log().all();
		  
	  
		
	}
	
	// Approach 2 - Storing entire response in a variable - then finding Cookies Values & Printing
	@Test
	void testCookies2()
	{
		
		Response res=
				
		given()
		
		.when()
		  .get("https://www.google.com/");
		  
		
		//  Get Single Cookie Value

		  String cookie_AEC = res.getCookie("AEC");
		  System.out.println("Cookie AEC value :" +" "+cookie_AEC);
		  
		  
		// Get all Cookies information
		  
		  Map<String,String> cookies_values = res.getCookies();
		  
		  System.out.println(cookies_values.keySet()); // Will print Cookies Names
		  
		  for(String k :cookies_values.keySet())
		  {
				String  cookievalue =  res.getCookie(k);
			  System.out.println(k+" "+cookievalue);
			  
		  }
		  
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
