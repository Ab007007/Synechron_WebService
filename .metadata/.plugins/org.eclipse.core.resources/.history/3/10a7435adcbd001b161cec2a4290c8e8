package com.synechron.ws.wstraining.basics.get;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.ResponseSpecificationImpl.HamcrestAssertionClosure;

import static io.restassured.RestAssured.*;

public class GetBoardWithValidation {

	public String baseurl = "https://api.trello.com";
	public String key = "c5f676759b86029624f7dcb31ccf655e";
	public String token = "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3";
	
	@Test
	public void validateBodyInGet()
	{
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
	
	}
	
	
	@Test
	public void validateResponseHeaderInGet()
	{
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
	
	}
	
	@Test
	public void validateResponseInArray()
	{
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
	
	}
	
	
	@Test
	public void validateMultipleValuesInArray()
	{
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
	
	}
	
	@Test
	public void validateKeyExist()
	{
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
				
	
	}
	
	@Test
	public void printAllArrayElements()
	{
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
	
	}
	
	
	@Test
	public void verifyPerticularValue()
	{
		RestAssured.baseURI = baseurl;
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("prefs.backgroundImageScaled.findAll{it.width == 640 }", hasItems(hasEntry("width", 640)));
	
	}
	
	@Test
	public void multipleAssertions()
	{
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
	
	}
	
	
	
}
