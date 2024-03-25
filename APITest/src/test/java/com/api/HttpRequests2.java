package com.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class HttpRequests2 {
	
	
	//@Test(priority = 1)
	void createUserJSON()
	{
		JSONObject data = new JSONObject();
		
		//HashMap<String, String> data = new HashMap<String,String>();
		data.put("name", "Rock");
		data.put("job", "khali2");
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.body("name", equalTo("Rock"))
			.log().all();
			
	}

	//@Test(priority = 1)
	void createUserPOJO()
	{
		POJORequests data = new POJORequests();
		
		//HashMap<String, String> data = new HashMap<String,String>();
		data.setName("Rock99");
		data.setJob("khali299");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.body("name", equalTo("Rock99"))
			.log().all();
			
	}
	
	@Test(priority = 1)
	void createUserJSONFile() throws FileNotFoundException
	{
		
		File f = new File(".\\details.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("RayMan"))
			.log().all();
			
	}
}
