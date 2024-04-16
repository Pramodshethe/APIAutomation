package com.api.chaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.ITestContext;

public class CreateUser {
	
	@Test
	void createUser(ITestContext context)
	{
		HashMap<String, String> data = new HashMap<String,String>();
		data.put("name", "Pramod");
		data.put("job", "khali");
		
	int id =	given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
	
	context.setAttribute("User_ID", id);
	
	}

}
