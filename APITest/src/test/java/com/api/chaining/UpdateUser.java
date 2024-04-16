package com.api.chaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.ITestContext;

public class UpdateUser {
	
	@Test
	void updateUser(ITestContext context)
	{
		
		int id = (int) context.getAttribute("User_ID");
		
		HashMap<String, String> data = new HashMap<String,String>();
		data.put("name", "Pramod");
		data.put("job", "Enilla");
		
		given()
			.contentType("application/json")
			.pathParam("id", data)
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
