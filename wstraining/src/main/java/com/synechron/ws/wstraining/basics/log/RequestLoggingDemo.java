package com.synechron.ws.wstraining.basics.log;

import static io.restassured.RestAssured.given;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class RequestLoggingDemo {

	public String baseurl = "https://api.trello.com";
	public String key = "c5f676759b86029624f7dcb31ccf655e";
	public String token = "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3";
	private Response response = null;

	public StringWriter requestWriter;
	public PrintStream reqPS;
	
	public StringWriter resWriter;
	public PrintStream resPS;
	
	
	@Test
	public void requestWithoutFilters() {
		RestAssured.baseURI = baseurl;

		 response = given()
				 		.param("key", key)
				 		.param("token", token).log().params()
			 		.when()
			 			.get("/1/boards/llt4bIbC")
		 			.then()
		 				.assertThat().statusCode(200).log().body()
	 				.extract()
	 					.response();

	}
	
	
	@Test
	public void requestWithFilters() {
		
		requestWriter = new StringWriter();
		reqPS = new PrintStream(new WriterOutputStream(requestWriter),true);
		
		resWriter = new StringWriter();
		resPS = new PrintStream(new WriterOutputStream(resWriter),true);
		
		
		RestAssured.baseURI = baseurl;

		 response = given()
				 		.param("key", key)
				 		.param("token", token)
				 		.filter(new RequestLoggingFilter(reqPS))
				 		.filter(new RequestLoggingFilter(resPS))
				 		
			 		.when()
			 			.get("/1/boards/llt4bIbC")
		 			.then()
		 				.assertThat().statusCode(200).log().body()
	 				.extract()
	 					.response();
		 
		 System.err.println(requestWriter.toString());
		 System.err.println(resWriter.toString());

	}
	
}
