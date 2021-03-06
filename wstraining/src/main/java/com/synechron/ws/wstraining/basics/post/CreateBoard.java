package com.synechron.ws.wstraining.basics.post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateBoard 
{
	
	public String baseurl = "https://api.trello.com";
	public String key = "c5f676759b86029624f7dcb31ccf655e";
	public String token = "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3";
	
	
	@Test
	public void createBoard() {
		RestAssured.baseURI = baseurl;

				given()
				 		.queryParam("key", key)
				 		.queryParam("token", token)
				 		.queryParam("name", "My-AutomationCreated-Board")
				 		.headers("Content-type","application/json")
			 		.when()
			 			.post("/1/boards")
		 			.then()
		 				.assertThat().statusCode(200);
	}

}
