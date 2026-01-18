package day1;          // Website : https://jsonplaceholder.typicode.com/

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPMethods {

	
	int id;
	
	
	@Test(priority=1)
	void getRequest()
	{
		given()
		
		.when()
		  .get("https://jsonplaceholder.typicode.com/posts/1")
		  
		  .then()
		   .statusCode(200)
		   .body("id",equalTo(1))
		   .log().all();
			
	}
	
	@Test(priority=2)
	void createUser()
	{
		HashMap data = new HashMap();
		data.put("title","tushar");
		data.put("body","classicphysique");
		
		id=	given()
		 .contentType("application/json")
		 .body(data)
		 
		 
		 .when()
		  .post("https://jsonplaceholder.typicode.com/posts")
		  .jsonPath().getInt("id");
		  
		 
		
	}
	
	
	@Test(priority=3)
	void updateUser()
	{
		
		HashMap data = new HashMap();
		data.put("title","tushar123");
		data.put("body","classicphysique456");
		
		given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		  .put("https://jsonplaceholder.typicode.com/posts/"+id)
		  
		  .then()
		  .log().all();
		
		
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		
		given()   
		
		 
		
		.when()
		  .delete("https://jsonplaceholder.typicode.com/posts/"+id)
		 
		  
		 
	    .then()
		 // .statusCode(204)
		  .log().all();
		
		
	}
	
	
}
