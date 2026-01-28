package day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class JSON_Revision {
	
	// Approach1 - Without storing response in a variable
	
//	@Test
	void testJSONResponse1()
	{
		
		given()
		  //.contentType("application/json")
		 .contentType("ContentType.JSON")
		
		.when()
		   .get("https://dummyjson.com/products")
		
		.then()
		 .statusCode(200)
		 .header("Content-Type", "application/json; charset=utf-8")
		 .body("products[1].warrantyInformation", equalTo("1 year warranty"))
		 
		;
		
		
	}
	
	
	// Approach2 - Storing response in a variable
	
//	@Test
	void testJSONResponse2()
	{
		
	Response res=
		given()
		  //.contentType("application/json")
		 .contentType("ContentType.JSON")
		
		.when()
		   .get("https://dummyjson.com/products");
	
	
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
	
	String exp_title = res.jsonPath().get("products[1].title").toString();
		
	Assert.assertEquals(exp_title, "Eyeshadow Palette with Mirror");
			
		
	String exp_beauty = res.jsonPath().getString("products[2].category").toString();
	
	Assert.assertEquals(exp_beauty,"beauty");
		
	}
	
	
	
	// Approach3 - Searching specific Element in JSON Response using for loop
	
	@Test
	void testJSONResponse3()
	{
		
		Response res =
		given()
		
		   .contentType("ContentType.JSON")
		   
		
		.when()
		  .get("https://dummyjson.com/products");
		
		
		JSONObject jsobj = new JSONObject(res.asString());
		
		boolean status = false;
		
		for(int i=0; i<jsobj.getJSONArray("products").length();i++)
		{
			
		String exp_title =	jsobj.getJSONArray("products").getJSONObject(i).get("title").toString();
			
			if(exp_title.equals("Eyeshadow Palette with Mirror"))
			{
				status=true;
				break;
				
			}
		
			
		}
		
		
		if(status==true)
		{
		  System.out.println("Title Matched.....");
		}
		else
		{
			System.out.println("Title doesn't matched...");
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
