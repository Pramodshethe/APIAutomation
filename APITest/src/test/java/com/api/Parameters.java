package com.api;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Parameters {
	

	@Test(priority = 1)
	void listAllUsers()
	{
		given()
			.pathParam("apipath", "users")
			.queryParam("page", 2)
		
		.when()
			.get("https://reqres.in/api/{apipath}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
