package com.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;




public class SchemaValidation {
	
	
	@Test
	void schemaValidation() {
		
		
		given()
		
		.when()
			.get("https://dummyjson.com/products")
			
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data-container-JSON.json"));
		
		// For xml schema validation using a xsd schema file	
		//RestAssuredMatchers.matchesXsdInClasspath("");
	}
	

}
