package day2;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestWays_JSONObject {

	
	// Create POST request data using JSONObject
	
	@Test
	void createUserData1()
	{
			
			JSONObject jsobj = new JSONObject();
			 jsobj.put("name","tushar");
			 jsobj.put("school","alingua");
			 jsobj.put("rollno","101");
			 
			 given()
			   .contentType("application/json")
			    .body(jsobj.toString())
			
			.when()
			  .post("https://jsonplaceholder.typicode.com/posts")
			
			.then()
			 .statusCode(201)
			 .header("Content-Type","application/json; charset=utf-8")
			 .body("name",equalTo("tushar"))
			 .body("school",equalTo("alingua"));
			
	}
	
	
	@Test(priority=2)
	void deleteUSeerData()
	{
		
		given()
		
		.when()
		  .delete("https://jsonplaceholder.typicode.com/posts")
		
		.then()
		 .statusCode(404)
		 .header("Transfer-Encoding","chunked");
		
		
	}
	
	
}
