package com.googlerestApi.com.googleAPITesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonfileReading {
	
	public void readJSON() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
	 
	   Object obj = parser.parse(new FileReader("./JSONFile.json"));
	 
	   JSONObject jsonObject = (JSONObject) obj;
	 
	   String email = (String) jsonObject.get("email");
	   System.out.println("Name Of Country: "+email);
	 
	   long password = (Long) jsonObject.get("pwd");
	   System.out.println("Population: "+password);
	 
	}



	}
	 


