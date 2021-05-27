package com.synechron.ws.wstraining.basics.delete;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRepo {

	
	String baseurl = "https://api.github.com";
	String barrierToken = "Bearer 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";
	String projectName = "AravindaHB/Kourtney";
	
	@Test
	public void deleteRepositoryName()
	{
		RestAssured.baseURI = baseurl;
		RestAssured.given()
						.headers("Authorization", barrierToken)
						.headers("Content-type", "application/json")
						.when()
							.delete("/repos/" + projectName)
						.then()
							.assertThat().statusCode(204);
	}
}
