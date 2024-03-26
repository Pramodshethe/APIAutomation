package com.api;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.*;
import org.testng.annotations.Test;

public class CookiesAndHeaders {
	
	@Test(priority = 1)
	void cookie()
	{
		Response res = given()
			
		
		.when()
			.get("https://www.google.com");
		
		
		Map<String, String> str = res.getCookies();
		
		for(String k: str.keySet()) {
			String cookie = res.getCookie(k);
			System.out.println(k+"   "+cookie);
		}
		
		
	}
	

}
