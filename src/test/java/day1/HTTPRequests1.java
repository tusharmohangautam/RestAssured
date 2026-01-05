package day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;
/*given( pre-condition)
 * when( actions )
 * then( validations)
 */
public class HTTPRequests1 {
	
	int id;
	
	@Test(priority=1)
	void getUsers()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		
		.then()
		  .statusCode(200)
		  .body("page",equalTo(2))
		  .log().all();	
		
		
	}
	
	
	
	
	
	// We will send some data to create user information
	@Test(priority=2)
	void createUser()
	{
		
		HashMap data = new HashMap();
		data.put("name","pavan");
		data.put("job","trainer");
		
		
	id=	given()
		  .contentType("application/json")
		  .body(data)
		
		  
		 .when()
		    .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");    // immediaely getting id from response 
		                        // if we capture String value(e.g name/job) then use .getString()
		 
		 
	//	 .then()           // not putting any validation on the response
	//	   .statusCode(201)    // 401 bcz otherwise I was getting error
	//	   .log().all()	
		
	}
	
	@Test(priority=3 ,dependsOnMethods={"createUser"})
	void updateUSer()
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
