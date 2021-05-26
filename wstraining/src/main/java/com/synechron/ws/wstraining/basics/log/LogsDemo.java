package com.synechron.ws.wstraining.basics.log;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LogsDemo {

	
	public String baseurl = "https://api.trello.com";
	public String key = "c5f676759b86029624f7dcb31ccf655e";
	public String token = "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3";
	private Response response = null;

	@Test
	public void createValidataleResponseUsingJayway() {
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
	
}
