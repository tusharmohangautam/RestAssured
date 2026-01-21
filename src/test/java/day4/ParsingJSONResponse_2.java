package day4;     // Website : https://jsonplaceholder.typicode.com/


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ParsingJSONResponse_2 {
	
	
	
	/* Approach 2 when storing response in one variable & we will be able to perform different
	  validations on Response */
	 
	// Approach 2
	
	@Test(priority=1)
	void testJSONResponse2()
	{
		
	Response res = 
	given()
	
	.contentType("application/json")
         //	.contentType("ContentType.JSON")   
	
	
	.when()
	.get("https://jsonplaceholder.typicode.com/users"); 
	
	  
	Assert.assertEquals(res.getStatusCode(),200);
	Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
	
	String userName = res.jsonPath().get("[1].username").toString();
	
	/* This get method will return the value in Object format when we close the statement
	right after get method -> So if the value is in the Object format we can't do any other
	validations because we exactly want Primitive Value (i.e. String / Integer / Double ..)
	So what we have to do is after capturing value using get method is - we will convert
	the value in String form using .toString() method
	*/
	
	Assert.assertEquals(userName,"Antonette");
	
	  	  
	  
	}
	
	
}
