import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;

public class interview_2026 {

	
	
	@Test(priority=1)
	void createUserDat()
	{
		HashMap map = new HashMap();
		map.put("id",1);
		map.put("title", "QA");
		map.put("location","siyana");
		
		String [] coursesArray = {"c","java","python"};
		map.put("courses", "coursesArray");
		
		given()
		 .contentType("application/json")
		 .body(map)
		
		.when()
		  .post("https://jsonplaceholder.typicode.com/posts")
		 
		 .then()
		   .statusCode(201)
		   .body("title",equalTo("QA"))
		   .header("Content-Type","application/json; charset=utf-8")
		   .log().headers();
		 
		
	}
	
	
	
	
	
	
	
	
}
