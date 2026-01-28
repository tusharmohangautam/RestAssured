package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PathAndQueryParameters {
	
	// To fetch Query & Path parameters in request we are doing this all
	
	// URL used : https://reqres.in/api/users?page=2&id=5
	// Domain : https://reqres.in/
	// Query Parameter : page=2
	// Query Parameter : id=5
	
	
	@Test
	void testQueryAndPathParameter()
	{
		
		given()
		 .pathParam("MyPath","users")  // Path Parameter , We have taken "MyPath" ourself to define Path Parameter value
		 .queryParam("page",2)            // Query Parameter
		 .queryParam("id",5)             // Query Parameter
		 
		 
		 
		 .when()
		   .get("https://reqres.in/api/{MyPath}")
		
		   // Query Parameter we no need to mention in GET url , as it will go by default 
		 
		 .then()
		  .statusCode(403);
		  
		
	}
	
	
	
	
	
	
	
	
	

}
