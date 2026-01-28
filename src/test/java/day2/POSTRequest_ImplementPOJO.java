package day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class POSTRequest_ImplementPOJO {
	
	

	@Test
	void createPOSTDataUsingPOJO()
	{
		POJOClass pc = new POJOClass();
		
		pc.setUserid("105");
		pc.setTitle("Quality Engineer");
		pc.setDepartment("Tester");
		
		given()
		 .contentType("application/json")
		 .body(pc)
		
		
		
		.when()
		  .post("https://jsonplaceholder.typicode.com/posts")
		
		
		.then()
		 .statusCode(201)
		 .header("Content-Type","application/json; charset=utf-8")
		 .body("userid",equalTo("105"))
		 .body("title", equalTo("Quality Engineer"))
		 .body("department", equalTo("Tester"))
		 ;
		
		
		
		
		
		
	}
	

}
