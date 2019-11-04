package com.googlerestApi.com.googleAPITesting;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClient {
	public static void main(String[] arg) throws IOException, JSONException
	{
String APIUrl = "http://52.175.215.113/monitor/api/auth/user";
String APIBody = "{ \"pwd\": \"123456\", \"email\" : \"rider@signpost.com\"}";
String header="b_authtok";



DefaultHttpClient httpClient = new DefaultHttpClient();
HttpPost httpRequest = new HttpPost(APIUrl);
httpRequest.setHeader("Content-Type", "application/json");
StringEntity xmlEntity = new StringEntity(APIBody);
httpRequest.setEntity(xmlEntity );
HttpResponse httpresponse = httpClient.execute(httpRequest);
System.out.println(httpresponse);

//JSONObject jsonResponse = new JSONObject(httpresponse.asString());



//String headerValue=jsonResponse.getString(header);

//System.out.println(headerValue);

//	HttpPost post = new HttpPost(APIUrl);	 
//
//post.setHeader("b_authtok", "747275650a31300a31310a340a313439373130363336343937330a7269646572407369676e706f73742e636f6d0a303a303a303a303a303a303a303a31"
//");
//	post.setHeader("Accept",
//             "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");


//	Assert.assertEquals(expectedValue, jo.getString(element));
}

}

