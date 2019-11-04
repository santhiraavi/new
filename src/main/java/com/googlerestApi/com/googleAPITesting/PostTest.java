package com.googlerestApi.com.googleAPITesting;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class PostTest {
	
	static Response response;
	@Test
	public void httpPost() throws JSONException,InterruptedException {
			
		//Initializing Rest API's URL
		String APIUrl = "http://52.175.215.113/monitor/api/auth/user/";
			
		//Initializing payload or API body
		String APIBody = "{ \"pwd \": \"my test password\", \"email\" : \"a@b.c\"}";
		//e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"
					
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		builder.setBody(APIBody);
			
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");
			
		RequestSpecification requestSpec = builder.build();
		System.out.println("bye");

		while(true)
		{
		try
		{

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = RestAssured.given().auth().preemptive().basic("", "")
					.spec(requestSpec).when().post(APIUrl);
		
		System.out.println("hai");

		JSONObject JSONResponseBody = new JSONObject(response.body().asString());

		//Fetching the desired value of a parameter
		String result = JSONResponseBody.getString("msg");
			
		//Asserting that result of Norway is Oslo
		Assert.assertEquals(result, "Permission denied.");
		
		System.out.println(result);
		break;

}
catch(Exception e)

{
	e.printStackTrace();
}

		}

	

}
}