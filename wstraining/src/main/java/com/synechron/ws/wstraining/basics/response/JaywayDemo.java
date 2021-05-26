package com.synechron.ws.wstraining.basics.response;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JaywayDemo {
	
	public String baseurl = "https://api.trello.com";
	public String key = "c5f676759b86029624f7dcb31ccf655e";
	public String token = "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3";
	private Response response = null;

	@Test
	public void createValidataleResponseUsingJayway() {
		RestAssured.baseURI = baseurl;

		 response = given()
				 		.param("key", key)
				 		.param("token", token)
			 		.when()
			 			.get("/1/boards/llt4bIbC")
		 			.then()
		 				.assertThat().statusCode(200)
	 				.extract()
	 					.response();

	}
	
	@Test(dependsOnMethods = "createValidataleResponseUsingJayway")
	public void getID()
	{
		String id = JsonPath.read(response.asString(), "$.id");
		System.out.println("ID using jayway : " + id);
	} 
	
	
	@Test(dependsOnMethods = "createValidataleResponseUsingJayway")
	public void getArray()
	{
		List<Map<String,String>>prefsArray = JsonPath.read(response.asString(), "$.prefs.backgroundImageScaled");
		
		
		//printing using for each
		for (Map<String, String> map : prefsArray) {
			Reporter.log(map.toString());
		}
		
//		//print using for loop
//		for (int i = 0; i < prefsArray.size(); i++)
//		{
//			 Map<String, String> map = prefsArray.get(i);
//			 
//			 for (int j = 0; j < map.size(); j++) 
//			 {
//				//map.get
//			}
//			
//		}
	} 
	
	
	@Test(dependsOnMethods = "createValidataleResponseUsingJayway")
	public void getAllUtlFromArray()
	{
		System.out.println("---Printing all url------");
		List<String>urls = JsonPath.read(response.asString(), "$.prefs.backgroundImageScaled[*].url");
		
		for (String url : urls) {
			Reporter.log(url + "<br>");
		}
	}
	
	@Test(dependsOnMethods = "createValidataleResponseUsingJayway")
	public void getAllUtlInResponse()
	{
		System.out.println("---Printing all url------");
		List<String>urls = JsonPath.read(response.asString(), "$..url");
		
		for (String url : urls) {
			Reporter.log(url + "<br>");
		}
	}
	
	@Test(dependsOnMethods = "createValidataleResponseUsingJayway")
	public void jaywayFiltersTest()
	{
		System.out.println("---Printing urls whose width is less than 640 ------");
		List<String>urls = JsonPath.read(response.asString(), "$.prefs.backgroundImageScaled.[?(@.width < 640)].url");
		
		for (String url : urls) {
			Reporter.log(url + "<br>");
		}
	}
	

}
