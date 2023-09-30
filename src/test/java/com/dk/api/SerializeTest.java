package com.dk.api;

import org.testng.annotations.Test;

import com.dk.pojo.AddPlace;
import com.dk.pojo.Location;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
public class SerializeTest {

	@Test(priority = 1)
	public void SerializationTest() {
		RestAssured.baseURI="http://localhost:3000/google";
		
		AddPlace ap=new AddPlace();
		ap.setAccuracy(20);
		ap.setAddress("2nd floor above swastik gaugage, kharadi");
		ap.setLanguage("German");
		ap.setPhone_number("808080980");
		ap.setWebsite("https://www.abcdk.com");
		ap.setName("API Automation");
		List<String> myList=new ArrayList<String>();
		myList.add("Green Garden");
		myList.add("Shoping Mall");
		ap.setTypes(myList);
		Location l=new Location();
		l.setLan(73.912239);
		l.setLat(18.566526);
		ap.setLocation(l);
		
		Response res=given().log().all().queryParam("key", "dk0123")
				.body(ap)
				.when()
				.post("http://localhost:3000/google")
				.then().statusCode(201).extract().response();
				//.log().all();
		String response=res.asString();
		System.out.println(response);
		//Response is not getting
		
	}
	@Test(priority = 2)
	public void getdetails() {
		
		given()
		.when().get("http://localhost:3000/google")
		.then().statusCode(200)
		.log().all();
	}
}
