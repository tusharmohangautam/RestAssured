import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateData_JSONObject {

	
	@Test(priority=1)
	void createUserDat()
	{
		
	JSONObject jsobj = new JSONObject();
	
	jsobj.put("title","producthead");
	jsobj.put("department","software");
	jsobj.put("id",102);
	
	given()
	 .contentType("application/json")
	 .body(jsobj.toString())
		
	
	 .when()
		.post("https://jsonplaceholder.typicode.com/posts")
		
	.then()
	  .body("title",equalTo("producthead"))
	  .header("Content-Type","application/json; charset=utf-8")
	  .statusCode(201);
		
	}
	
	
	@Test(priority=2)
	void deleteUserData()
	{
		
	
	
	given()
	 
		
	
	 .when()
		.post("https://jsonplaceholder.typicode.com/posts")
		
	.then()
	  
	  .statusCode(204);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
