package day4;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class JSONResponse1_Practice
{
	@Test
	void testJSONResponse()
	{
		
	given()
	 .contentType("application/json")
	 
	
	.when()
	  .get("https://dummyjson.com/products")
	
	
	.then()
	  .statusCode(200)
	  .header("Content-Type", "application/json; charset=utf-8")
	  .body("products[0].warrantyInformation",equalTo("1 week warranty"));
	
	
	}
	
	
	
	
	
	
	
	

	
}
