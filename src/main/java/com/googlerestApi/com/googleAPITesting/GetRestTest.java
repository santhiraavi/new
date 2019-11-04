package com.googlerestApi.com.googleAPITesting;





import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;




public class GetRestTest {

	@Test
	public void getRequestFindCapital() throws JSONException {
		
		//make get request to fetch capital of norway
		Response resp = RestAssured.given().get("http://restcountries.eu/rest/v1/name/norway");
		
		//Fetching response in JSON
		JSONArray jsonResponse = new JSONArray(resp.asString());
		
		//Fetching value of capital parameter
		String capital = jsonResponse.getJSONObject(0).getString("capital");
		
		//Asserting that capital of Norway is Oslo
		Assert.assertEquals(capital, "Oslo");
		System.out.println(capital);
	}
	
}