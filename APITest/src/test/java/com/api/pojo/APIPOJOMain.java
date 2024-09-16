package com.api.pojo;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class APIPOJOMain {
	
	public static void main(String args[]) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
	String response = given()
			.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.formParam("grant_type", "client_credentials")
			.formParam("scope", "trust")
			
		.when()
			.log().all()
			.post("oauthapi/oauth2/resourceOwner/token")
			.jsonPath().getString("access_token");
			
		//JsonPath path = new JsonPath(response);
		//String accesstoken = path.getString("access_token");
		
		System.out.println(response);
		
		
	GetCourse gc = given()
			.queryParams("access_token", response)
							
		.when()
			.log().all()
			.get("oauthapi/getCourseDetails").as(GetCourse.class);
	
	
		System.out.println("Instructor: "+gc.getInstructor());
		
		
	}

}
