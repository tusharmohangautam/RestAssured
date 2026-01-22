package day4;     // Website : https://jsonplaceholder.typicode.com/


import static io.restassured.RestAssured.given;



import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class JSONResponse_SearchingSpecificElement_3 {
	
	
	@Test(priority=1)
	void testJSONResponseBody()
	{
		
	Response res = 
	given()
	
	 .contentType("application/json")
         //	.contentType("ContentType.JSON")   
	
	
	.when()
	.get("https://dummyjson.com/products"); 
	
	  
	Assert.assertEquals(res.getStatusCode(),200);
	Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
	
	String expTitle = res.jsonPath().get("products[0].title").toString();
	
	Assert.assertEquals(expTitle,"Essence Mascara Lash Princess");
	

	// In jSON response we have so many objects -> And in all we have name/username/email etc...
	/* Suppose I want to capture any ->name/username/email etc... from all the object
	and I want to check that specific name/username/email is present in all those objets or 
	not */
	
	
  // To traverse through json response we have to convert the response in String form first
	
		JSONObject jo = new JSONObject(res.asString()); // Always needed this (res.asString())
		
		boolean status = false;
	
		// Finding a title
		
	for(int i=0; i<jo.getJSONArray("products").length(); i++) 
		
		// In double quotes we mention Array name (i.e. "products")
		
	{	 		
	String exp_title = jo.getJSONArray("products").getJSONObject(i).get("title").toString();
	
	// System.out.println(exp_title);
	
	  if(exp_title.equals("Essence Mascara Lash Princess"))
	  {	
		status=true;
		break;
		
	  }
    }	
	
	if(status==true)
	{
		System.out.println("title found....");


	}
	else
	{
		System.out.println("Title not found....");
		
	}
	
		
		// Finding total price of all the objects from response JSON array
	    double totalprice = 0;
		
		for(int i=0; i<jo.getJSONArray("products").length(); i++) 
			
			// In double quotes we mention Array name (i.e. "products")
			
		{	 		
		String price = jo.getJSONArray("products").getJSONObject(i).get("price").toString();
		
		totalprice = totalprice + Double.parseDouble(price);
		
		 
	    }	
		System.out.println("Total price is :" + totalprice);
		
		Assert.assertEquals(totalprice ,6577.499999999995);
	
	  
	}
	
	
}
