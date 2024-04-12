package com.api;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XMLParsing {
	
	
	@Test(priority = 1)
	void xmlparsing() {
		
		Response res = 
				given()		
					
				.when()
					.get("https://mocktarget.apigee.net/xml");
		
		XmlPath xml = new XmlPath(res.asString());
		
		List<String> li = xml.getList("root.city");
		System.out.println(li);
 		
		
	}

}
