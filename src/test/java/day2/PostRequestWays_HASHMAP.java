package day2;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class PostRequestWays_HASHMAP {

	
	// Create POST request data using HASHMAP
	
		@Test(priority=1)
		void createUserData1()
		{
			HashMap hm = new HashMap();
			hm.put("userid","1");
			hm.put("title","Quality Analyst");
			hm.put("department","QA");
			
			String coursesArray [] = {"Maths","c","java"};
			hm.put("courses","coursesArray");
			
			given()
			 .contentType("application/json")
			 .body(hm)
			 
			.when()
			  .post("https://jsonplaceholder.typicode.com/posts")
			
			.then()
			 .statusCode(201)
			 .header("Content-Type","application/json; charset=utf-8")
			 .body("title",equalTo("Quality Analyst"));
			
			
		}
		
	@Test(priority=2)
	void deleteUserData()
	{
		given()
		
		.when()
		  .delete("https://jsonplaceholder.typicode.com/posts")
		
		.then()
		 .statusCode(404);
		
	}
	
	
	
	
	
	
	
	
}
