package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

// We will not XML dependencies in POM>x l as these will come by default with REST ASSURED

public class ParsingXMLResponse_2 {
	
	
	// Approach 2 -> When Storing Response In A Variable
	
	@Test
	void textSMLResponse()
	{
		
		Response res=
		given()
		  
		.when()
		  .get("https://www.w3schools.com/xml/cd_catalog.xml");
		
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		Assert.assertEquals(res.header("Content-Type"),"text/xml");
		
		String artist =   res.xmlPath().get("CATALOG.CD[0].ARTIST").toString();
		
		
		Assert.assertEquals(artist,"Bob Dylan");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	.then()
		 .statusCode(200)
		 .header("Content-Type","text/xml")
		 .body("CATALOG.CD[0].COMPANY", equalTo("Columbia"));
		 .body("CATALOG.CD[4].ARTIST" , equalTo("Eros Ramazzotti"));
		
	*/	
		
		
	}
	
	
	
	
	
	
	

}
