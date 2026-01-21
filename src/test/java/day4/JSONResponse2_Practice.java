package day4;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class JSONResponse2_Practice {
	
	// Approach 2 -> Storing response in a variable then doing validations
	
	@Test
	void testJSONResponse()
	{
		
		Response res=
		given()
		  .contentType("ContentType.JSON")
		
		.when()
		   .get("https://dummyjson.com/products");
		
		
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8" );
		
		String shipinformation = res.jsonPath().get("products[16].shippingInformation").toString();
		
		Assert.assertEquals(shipinformation,"Ships overnight");
		
		
		
		String images = res.jsonPath().get("products[16].images[0]").toString();
		
		
		Assert.assertEquals(images ,"https://cdn.dummyjson.com/product-images/groceries/beef-steak/1.webp");
		 
		
		
	}
	
	
	
	
	

}
