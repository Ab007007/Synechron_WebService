package com.synechron.ws.wstraining.basics.auth;

import org.springframework.web.reactive.result.condition.ParamsRequestCondition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class PayPalTokenGenerator {
	
	
	
	
	public final String clientID = "AUwGyg0pfq7plhQGzIRgp1JTHFaNHDaXf_calPdO4wygrhtSN5xSH6wYo0_uSB6ru1-Gg9pggpyd8jPU";
	public final String secretKey = "EDFr7gcXOFXROXzK-1yDZBDyn0c02enttxw2ZJFatKcmuFyGEYzeAKFh-5bxZEtB8Gx6lyfu0qVDGkwy";
	
	String token = null;
	
	@BeforeClass
	public void getTokenTest()
	{
		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";
		RestAssured.basePath = "/v1";
		//v1
		token = given(). 
					params("grant_type", "client_credentials")
						.auth().preemptive().basic(clientID, secretKey)
				.when()
					.post("/oauth2/token")
				.then()
					.log().all()
				.extract()
					.path("access_token");
				
	}
	

}
