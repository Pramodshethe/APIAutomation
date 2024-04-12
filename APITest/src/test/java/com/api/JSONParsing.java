package com.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;



public class JSONParsing {
	
	@Test(priority = 1)
	void jsonParcingTest() {
		
		Response res =
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://dummyjson.com/products");
		
		
		JSONObject jo = new JSONObject(res.asString());
		boolean status = false;
		
		for (int i=0; i<jo.getJSONArray("products").length();i++) 
		{
			
			String value = jo.getJSONArray("products").getJSONObject(i).get("title").toString();
		
			System.out.println(value);
			
			if (value.equals("Samsung Galaxy Book")) {
				
				status = true;
				break;
			}
		
		}
		
		Assert.assertEquals(status, true);
		
	}
				

}
