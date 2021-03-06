package com.synechron.ws.wstraining.basics.download;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileDownloadDemo {
	
	@Test
	public void fileDownoladValidate()
	{
		File file = new File("downloaded/geckodriver-v0.29.1-win32.zip");
		
		int expectSize = (int)file.length();
		System.out.println("Expected length of the file " + expectSize + " bytes");
		
		byte[] actualValue = RestAssured.given()
			.when()
				.get("https://github.com/mozilla/geckodriver/releases/download/v0.29.1/geckodriver-v0.29.1-win32.zip")
			.then()
				.extract()
				.asByteArray();
		
		
		System.out.println("Actual length of the file " + actualValue.length + " bytes");
		
		Assert.assertEquals(expectSize, actualValue.length);
		
		
	}

}
