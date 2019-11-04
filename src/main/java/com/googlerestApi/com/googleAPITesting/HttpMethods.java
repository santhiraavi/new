package com.googlerestApi.com.googleAPITesting;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class HttpMethods {
		public static Response response;

	static String APIUrl = "http://52.175.215.113/monitor/api/auth/user";
	static String APIBody = "{ \"pwd\": \"1\", \"email\" : \"santhi@gmail.com\"}";

	static String example = "{ \"id \": \"1\", \"email\" : \"2\"}";
	static String publicApi = "http://api.zippopotam.us/us/90210";

		//Get
		@Test

		public void method1()
					{
			Response res=RestAssured.given().
			when().
			contentType(ContentType.JSON).
			get(APIUrl);
			System.out.println("response for the post \t"+
			res.asString());
					}

		//post
		
		
		@Test
		public void ownAPI()
		{
				Response res=RestAssured.given().
				body(APIBody).
				when().
				contentType(ContentType.JSON).
				post(APIUrl);
				System.out.println("response for the post"+res.asString());
		}
		
		
		
		@Test(enabled=false)
		public void method2()
		{
				Response res=RestAssured.given().
//				body(APIBody).
				body(example).
				when().
				contentType(ContentType.JSON).
				post(publicApi);
				System.out.println("response for the post"+res.asString());
		}
		
		
		
}



