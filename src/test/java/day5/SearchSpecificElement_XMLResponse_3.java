package day5;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

// We will not add XML dependencies in POM.xml as these will come by default with REST ASSURED

public class SearchSpecificElement_XMLResponse_3 {
	
	
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
		
		
		// Performing other validations on xml response
		
		XmlPath xp = new XmlPath(res.asString());
		
		
     /* Finding total number/ list of child tags/nodes ( CD ) under parent tag ( CATALOG ) using 
        List Collection	 */
		
		List<String> cd_nodes =   xp.getList("CATALOG.CD");
		
		 System.out.println(cd_nodes.size());  //26
		
		Assert.assertEquals(cd_nodes.size(), 26);
		
		// Searching specific ARTIST value in xml response - If order of display for value is dynamic
		
		// NOTE : First find total ARTISTS enteries present in child node in XML response
		
		List<String> total_artists =   xp.getList("CATALOG.CD.ARTIST");
		
		boolean status = false;
		
		for(String Artist : total_artists)
		{
			if(Artist.equals("Bob Dylan"))
			{
				status=true;
				break;
				
			}
			
		}
		
		Assert.assertEquals(status, true);
		
		
		
		
		
		
		
	/*	.then()
		 .statusCode(200)
		 .header("Content-Type","text/xml")
		 .body("CATALOG.CD[0].COMPANY", equalTo("Columbia"));
		 .body("CATALOG.CD[4].ARTIST" , equalTo("Eros Ramazzotti"));
		
	*/	
		
		
	}
	
	
	
	
	
	
	

}
