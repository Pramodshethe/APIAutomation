package com.api.chaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;

public class GetUser {
	
	@Test
	void listUser(ITestContext context)
	{
		
		int id = (int) context.getAttribute("User_ID");
		//for suit level access
		//int id = (int) context.getSuite().getAttribute("User_ID");
		
		
		given()
			.pathParam("id",id )
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("total", equalTo(12))
			.log().all();
	}

}
