package com.dk.api;

import org.testng.annotations.Test;

import com.dk.pojo.AddPlace;
import com.dk.pojo.Location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
public class SpecBuilderTest {

	@Test(priority = 1)
	public void SerializationTest() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
				//"http://localhost:3000/google";
		
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
	RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		RequestSpecification res=given().spec(req)
				.body(ap);
			Response response=res.when()
				.post("/maps/api/place/add/json")
				.then().spec(resspec).extract().response();
				//.log().all();
		String responseString=response.asString();
		System.out.println(responseString);
		//Response is not getting
		
	}
//	@Test(priority = 2)
//	public void getdetails() {
//		
//		given()
//		.when().get(basePath)
//		.then().statusCode(200)
//		.log().all();
//	}
}
