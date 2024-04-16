package com.api.chaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;

public class DeleteUser {
	
	@Test
	void deleteUser(ITestContext context)
	{
		int id = (int) context.getAttribute("User_ID");
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}

}
