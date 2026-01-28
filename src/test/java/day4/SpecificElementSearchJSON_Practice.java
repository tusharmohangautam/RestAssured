package day4;

import static io.restassured.RestAssured.given;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SpecificElementSearchJSON_Practice
{

	@Test
	void testSpecificELement()
	{
		
		Response res=
		given()
		  .contentType("ContentType.JSON")
		
		.when()
		 .get("https://dummyjson.com/products");
		
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean status = false;
		
		for(int i=0; i<jo.getJSONArray("products").length();i++)
	{
		String title =	 jo.getJSONArray("products").getJSONObject(i).get("title").toString();
		
		if(title.equals("Eyeshadow Palette with Mirror"))
		{
	       status = true;
	       break;
			
		}
			
	}
		
		if(status==true)
		{
			System.out.println("Title matched ............" );
		}
		
		else
		{
			System.out.println("Title not found....");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
