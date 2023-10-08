package demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import pojo.Api;
import pojo.Courses;
import pojo.GetCourse;
import pojo.WebAutomation;


public class test1 {

	public static void main(String[] args) throws InterruptedException {	
		
		GetCourse g=new GetCourse();
		String response =
                given().expect().defaultParser(Parser.JSON)  
                        
                        //.queryParams("https://rahulshettyacademy.com/getCourse.php")
                        .when()
                        .post("http://localhost:3000/dkcourse").asString();
			String r2=    given().expect().defaultParser(Parser.JSON)
				 //queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
				 .when()
           .get("http://localhost:3000/dkcourse")
		.asString();
		System.out.println(r2);
		RequestSpecification resSpec=RestAssured.given();
		resSpec.baseUri("http://localhost:3000/dkcourse");
		Response res=resSpec.post();
		res.prettyPrint();
		//Assert.assertEquals(res.statusCode(),200,"check " );
		ResponseBody responsebody=res.getBody();
		JsonPath js=responsebody.jsonPath();
		List<Api> c=js.getList("courses",Api.class);
		//for(int i=0;i<c.size();i++) {
//			System.out.println(c.get(i).getCourseTitle().toString());	
		for(Api a : c) {
			System.out.println(a.getCourseTitle());
		}
	}
		
//		
//		System.out.println(js.getList(r2));
//		List<Api> webautomation=g.getCourses().getApi();
//		System.out.println(g.getInstructor());
//		for(int i=0;i<webautomation.size();i++) {
//			System.out.println(g.getCourses().getWebAutomation().get(i).getCourseTitle());
//			String text=webautomation.get(i).getCourseTitle();
//			System.out.println(text);
//			}
//		

	
	
	
}
