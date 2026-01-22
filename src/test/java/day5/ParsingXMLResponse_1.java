package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

// We will not XML dependencies in POM>x l as these will come by default with REST ASSURED

public class ParsingXMLResponse_1 {
	
	
	// Approach 1 -> Without Storing Response In A Variable
	
	@Test
	void textSMLResponse()
	{
		
		given()
		  
		.when()
		  .get("https://www.w3schools.com/xml/cd_catalog.xml")
		
		
		.then()
		 .statusCode(200)
		 .header("Content-Type","text/xml")
		 .body("CATALOG.CD[0].COMPANY", equalTo("Columbia"));
		// .body("CATALOG.CD[4].ARTIST" , equalTo("Eros Ramazzotti"));
		
		
		
		
	}
	
	
	
	
	
	
	

}
