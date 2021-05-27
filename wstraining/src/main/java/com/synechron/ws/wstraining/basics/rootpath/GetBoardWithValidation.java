package com.synechron.ws.wstraining.basics.rootpath;

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
	public void validateResponseInArray()
	{
		RestAssured.baseURI = baseurl;
		RestAssured.rootPath = "prefs.backgroundImageScaled";
		//RestAssured.reset();
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("width",hasItems(67));
	
	}
	
	
	@Test
	public void validateMultipleValuesInArray()
	{
		RestAssured.baseURI = baseurl;
		RestAssured.rootPath = "prefs.backgroundImageScaled";
		
		given().
			param("key", key).
			param("token", token).
		when().
			get("/1/boards/llt4bIbC"). 
		then(). 
			assertThat().statusCode(200).
			and().
				body("width",hasItems(67, 128, 320, 640)).log().body();
	
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
				body("findAll{it.width == 640 }", hasItems(hasEntry("height", 960)));
	
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
			body("size()", equalTo(12)). 
			body("size()", greaterThan(5)). 
			body("size()", lessThan(15)). 
			body("size()", greaterThanOrEqualTo(12)). 
			body("size()", lessThanOrEqualTo(12)); 
	
	}
	
	
	
}
