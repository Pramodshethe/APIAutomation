package com.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Authentication {
	
	
	@Test(priority = 1)
	void basicAuth() {
		
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	@Test(priority = 2)
	void digestAuth() {
		
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	@Test(priority = 3)
	void BearertAuth() {
		
		String BearerToken = "";
		
		given()
			.headers("Authorization", "Bearer "+ BearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority = 4)
	void oauth1Auth() {
		
		
		given()
			.auth().oauth(DEFAULT_URI, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		.when()
			.get("url")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority = 5)
	void oauth2Auth() {
		
		
		given()
			.auth().oauth2("")
		.when()
			.get("url")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
