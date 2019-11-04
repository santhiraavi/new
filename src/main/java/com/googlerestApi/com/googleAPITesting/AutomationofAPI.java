package com.googlerestApi.com.googleAPITesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AutomationofAPI {
	public static Response response,response1;
    public static String jsonAsString;
    public String header="b_authtok";
    public static String headerVlaue="";
    public static JSONObject jsonResponse;
    
//	static String APIUrl = "http://52.175.215.113/monitor/api/auth/user";
//	static String APIBody = "{ \"pwd\": \"123456\", \"email\" : \"rider@signpost.com\"}";
//	public static String ApiWithHeader="http://52.175.215.113/monitor/api/mo/sites/list";
	
	@SuppressWarnings("deprecation")
	@DataProvider
	public Object[][] extractDataFromExcel() throws EncryptedDocumentException, InvalidFormatException, IOException 

			{
		
				Object[][] obj=new Object[2][3];
				FileInputStream fin=new FileInputStream("./RestAPI.xlsx");  
				  
				Workbook wb=WorkbookFactory.create(fin);
		
				Sheet sh=wb.getSheet("Sheet1");
				
				int rowcount=0;
		
		       
				Iterator<Row> rowiterator=sh.iterator();
	

				while(rowiterator.hasNext())
					{
					Row row=rowiterator.next();
					int cellcount=0;	
					
						if(row.getRowNum()==0)
						{
					
						}
				
						else
						{
	
					Iterator<Cell> celliterator=row.iterator();
	
					while(celliterator.hasNext())
					{
						Cell cell=celliterator.next();
						obj[rowcount][cellcount]=cell.getStringCellValue();
						
//						System.out.println(cell.getStringCellValue());
						
//						if(obj[rowcount][cellcount].)
				
						cellcount++;

					}		
							rowcount++;
						}	
		
					}
				return  obj;

			}



	@Test(dataProvider="extractDataFromExcel")
	public void method(String apiurl,String method,String reqBody) throws JSONException
	{
		if(method.equals("post"))
		{
		System.out.println("Api calling with " +method+ " method");
		response=RestAssured.given().
				body(reqBody).
				when().
				contentType(ContentType.JSON).
				post(apiurl);
				jsonResponse = new JSONObject(response.asString());	
				headerVlaue=jsonResponse.getString(header);
				System.out.println(headerVlaue);
		}
		else if(method.equals("get"))
		{
			System.out.println("Api calling with " +method+ " method");

			response=RestAssured.given().
		            header(header, headerVlaue).
					when().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					get(apiurl);
					System.out.println("response for the post \t"+
					response.asString());

		}
		
		else
		{
			System.exit(0);
		}
	}
  

}


