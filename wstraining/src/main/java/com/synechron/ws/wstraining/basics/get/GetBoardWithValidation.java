package com.synechron.ws.wstraining.basics.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.io.File;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class GetBoardWithValidation {

	public String baseurl = "https://api.trello.com";
	public String key = "c5f676759b86029624f7dcb31ccf655e";
	public String token = "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3";
	
	ExtentReports reports =null;
	ExtentTest test = null;
	
	
	@BeforeClass
	public void getGeport() {
		
		reports = new ExtentReports("reports/Execution_Report_" +new Date().toString().replace(" ", "_").replace(":", "_") + ".html");
		
		
	}
	
	@AfterClass
	public void saveReports()
	{
		reports.flush();
	}
	
	@Test
	public void validateBodyInGet()
	{
		test = reports.startTest("validateBodyInGet");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and(). 
				contentType(ContentType.JSON). 
			and().
				body("id", equalTo("60ac71721dceec66fea94ff9")).
			and().
				body("name", equalTo("myAutomationBoard"));
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	
	}
	
	@Test
	public void validateResponseHeaderInGet()
	{
		test = reports.startTest("validateBodyInGet");
	
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
	
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and(). 
				contentType(ContentType.JSON). 
			and().
				header("Content-Type", "application/json; charset=utf-8"). 
			and(). 
				header("Expires", "Thu, 01 Jan 1970 00:00:00"). 
			and(). 
				body("id", equalTo("60ac71721dceec66fea94ff9")).
			and().
				body("name", equalTo("myAutomationBoard"));
		
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	
	}
	@Test
	public void validateResponseInArray()
	{
		test = reports.startTest("validateBodyInGet");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("name", equalTo("myAutomationBoard")). 
				body("prefs.backgroundImageScaled[0].width",equalTo(67));
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	}
	
	@Test
	public void validateMultipleValuesInArray()
	{
		test = reports.startTest("validateMultipleValuesInArray");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("name", equalTo("myAutomationBoard")). 
				body("prefs.backgroundImageScaled.width",hasItems(67, 128, 320, 640));
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	
	}
	@Test
	public void validateKeyExist()
	{
		test = reports.startTest("validateKeyExist");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("name", equalTo("myAutomationBoard")).and().
				body("prefs.backgroundImageScaled[0]",hasKey("width")).and(). 
				body("prefs.backgroundImageScaled[0]",hasKey("height")).and(). 
				body("prefs.backgroundImageScaled[0]",hasKey("url"));
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
				reports.endTest(test);
	
	}
	@Test
	public void printAllArrayElements()
	{
		test = reports.startTest("printAllArrayElements");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("name", equalTo("myAutomationBoard")).and().
				body("prefs.backgroundImageScaled[0]",hasKey("width")).and(). 
				body("prefs.backgroundImageScaled[0]",hasKey("height")).and(). 
				body("prefs.backgroundImageScaled[0]",hasKey("url")).and(). 
				body("prefs.backgroundImageScaled.size()", equalTo(9));
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	
	}
	
	@Test
	public void verifyPerticularValue()
	{
		test = reports.startTest("verifyPerticularValue");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("prefs.backgroundImageScaled.findAll{it.width == 640 }", hasItems(hasEntry("height", 960)));
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	
	}
	@Test
	public void multipleAssertions()
	{
		test = reports.startTest("multipleAssertions");
		
		test.log(LogStatus.INFO	, "Starting the API Test Execution ");
		
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
			body("prefs.backgroundImageScaled.size()", equalTo(9)). 
			body("prefs.backgroundImageScaled.size()", greaterThan(5)). 
			body("prefs.backgroundImageScaled.size()", lessThan(10)). 
			body("prefs.backgroundImageScaled.size()", greaterThanOrEqualTo(9)). 
			body("prefs.backgroundImageScaled.size()", lessThanOrEqualTo(9)); 
		test.log(LogStatus.PASS, "Valdiated id of the board 60ac71721dceec66fea94ff9");
		reports.endTest(test);
	
	}
	
	
	
}
