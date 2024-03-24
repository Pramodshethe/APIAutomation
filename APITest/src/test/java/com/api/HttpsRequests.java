package com.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class HttpsRequests {
	
	int id;
	
	@Test(priority = 2)
	void listAllUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("total", equalTo(12))
			.log().all();
	}
	
	
	@Test(priority = 1)
	void createUser()
	{
		HashMap<String, String> data = new HashMap<String,String>();
		data.put("name", "Pramod");
		data.put("job", "khali");
		
	id=	given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
	}
	
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap<String, String> data = new HashMap<String,String>();
		data.put("name", "Pramod");
		data.put("job", "Enilla");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(200)
			.log().all();
	}

	
	@Test(priority = 4)
	void deleteUser()
	{
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}

}






