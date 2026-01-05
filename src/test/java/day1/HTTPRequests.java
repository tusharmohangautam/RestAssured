package day1;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

// as these are static packages -we have to use static keyword with them

public class HTTPRequests {
	
	String id;    // Earlier it was int but to run code Gemini suggest String
	
	
	
	@Test(priority=1)
	void getUsers()      // get list of user details - sending GET request 
	{
		
		
		given()
		
		
		
		.when()              // it's a part of given method()
		    
		    .get("https://reqres.in/api/users?page=2")
		
		.then()
		  
		    .statusCode(200)
		    .body("page",equalTo(2))
		    .log().all();                   // display entire response in console
		
	}	
		
		
		
		
		@Test(priority=2)
		void createUser()
		{
			
			// we are using HashMap here to generate data- but not recommended
			
			HashMap data = new HashMap();
			
			data.put("name","pavan");
			data.put("job","trainer");
			
			
		id=	given()    // remeber what kind of data we are sending  i.e. json  etc....
			
			  .contentType("application/json")
			  .body(data)
			  
			
			  /* as after sending request it will display response payload - and I'm capturing
			  id and assign the value to id variable created at class level 
			  -> and based on received id we will update the user details in put request
			  by passing the received id 
			  */
			  
			.when()
			  .post("https://reqres.in/api/users")
//  .jsonPath().getInt("id");   // it was used if i take int=id at class level but didn't work
			  .jsonPath().getString("id");  
		
			  
			  
			// I will not do validation on response payload
		//	.then()
		//	  .statusCode(201)
		//	  .log().all();
			
			  
			  
		}
		
	
		
		@Test(priority=3, dependsOnMethods={"createUser"})
		void updateUser()
		{
			
	         HashMap data = new HashMap();
			
			data.put("name","tushar");
			data.put("job","teacher");
			
			
		   given()   
			
			  .contentType("application/json")
			  .body(data)
			  
			
	
			.when()
			  .put("https://reqres.in/api/users/"+id)
			 
			  
			  
			
		    .then()
			  .statusCode(200)
			  .log().all();
			
			
			
		}
		
		
		@Test(priority=4)
		void deleteUser()
		{
			
			given()   
			
			 
			
			.when()
			  .delete("https://reqres.in/api/users/"+id)
			 
			  
			 
		    .then()
			  .statusCode(204)
			  .log().all();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
