package com.api;

import io.restassured.path.json.JsonPath;

public class TC01 {
	
	public static void main(String args[]) {
	JsonPath js = new JsonPath(CommonMethods.jsonMock());
	
	System.out.println(js.getInt("courses.size()"));
	
	System.out.println(js.getInt("dashboard.purchaseAmount"));
	
	System.out.println(js.getString("courses[0].title"));
	
	for (int i=0; i<js.getInt("courses.size()");i++) {
		
		System.out.println(js.getString("courses["+i+"].title") +" "+js.getInt("courses["+i+"].price"));
	}

}
}