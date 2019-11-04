package com.googlerestApi.com.googleAPITesting;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPIGetAndPost {
	public static Response response;
    public static String jsonAsString;
    public String header="b_authtok";
    public static String headerValue="";
	static String APIUrl = "http://52.175.215.113/monitor/api/auth/user";
	static String APIBody = "{ \"pwd\": \"123456\", \"email\" : \"rider@signpost.com\"}";
	public static String ApiWithHeader="http://52.175.215.113/monitor/api/mo/sites/list";

	
	
			@Test
			public void ownAPI() throws JSONException
			{
		

						response=RestAssured.given().
						body(APIBody).
						when().
						contentType(ContentType.JSON).
						post(APIUrl);

						JSONObject jsonResponse = new JSONObject(response.asString());

//						System.out.println(jsonResponse);
						
						headerValue=jsonResponse.getString(header);
						
						System.out.println(headerValue);
						


				
						response=RestAssured.given().
			            header(header, headerValue).
						when().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						get(ApiWithHeader);
						System.out.println("response for the post \t"+
						response.asString());
//
//						
//						System.out.println("header for the API \t"+headerValue);
								
								
//						JSONObject JSONResponseBody = new JSONObject(response.asString());
//
//						//Fetching the desired value of a parameter
//						String result = JSONResponseBody.getString("msg");
//									
//						//Asserting that result of Norway is Oslo
//						Assert.assertEquals(result, "Permission denied.");
//								
//						System.out.println(result);
//					
//						System.out.println(response.asString());

				    }



	}

