package AnanayMahajan.APIAssignment;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AnanayMahajan.Payload.users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class userEndPoints2 {
	String id;
	@Test(priority=1)
	public void postRequestUsingPojoClass() {
		users newUser=new users("Ananay Mahajan","Software Engineer");
//		 given()
//			.contentType(ContentType.JSON)
//			.body(newUser)
//		.when()
//			.post(Routes.post_url)
//		.then()
//			.statusCode(201).log().all();
		Response response=  given()
				.contentType(ContentType.JSON)
				.body(newUser)
			.when()
				.post(Routes.post_url);
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(),201);	
		ResponseBody resBody = response.getBody();

    // split the String by a comma 
    String parts[] = resBody.asString().split(","); 

    // iterate the parts and add them to a HashMap 
    for (String part : parts) { 
 
        String data[] = part.split(":"); 
        if(data[0].trim().contains("id"))
        	id=data[1];
    } 
		 
	}
	
	@Test
	public void postRequestUsingMap() {
		HashMap<String,String> data=new HashMap<String, String>();
		data.put("name", "john doe");
		data.put("job", "designer");
		users newUser=new users(data.get("name"),data.get("job"));
		 given()
			.contentType(ContentType.JSON)
			.body(newUser)
		.when()
			.post(Routes.post_url)
		.then()
			.statusCode(201);
	}
	
	@Test
	public void postRequestUsingJson() throws IOException {
		String jsonContent = 	FileUtils.readFileToString(new File("C:\\Users\\ananmaha\\eclipse-workspace2\\APIAssignment\\src\\test\\java\\AnanayMahajan\\Payload\\user.json"),
				StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		
		HashMap<String, String> data = mapper.readValue(jsonContent, new TypeReference<HashMap<String, String>>() {
	      });	


		users newUser=new users(data.get("name"), data.get("job") );
		 given()
			.contentType(ContentType.JSON)
			.body(newUser)
		.when()
			.post(Routes.post_url)
		.then()
			.statusCode(201);
	}
	
	@Test(dependsOnMethods= {"postRequestUsingPojoClass"})
	public void getReq() {
		String id1=id;
		id1 = id1.replace("\"", "");
		 int id2=Integer.parseInt(id1);
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url2 + id2)
		.then()
			.statusCode(404)
			.log().all();
	}
	
	@Test(dependsOnMethods= {"postRequestUsingPojoClass","updateReq","getReq"})
	public void deleteReq() {
		String id1=id;
		id1 = id1.replace("\"", "");
		 int id2=Integer.parseInt(id1);
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.delete(Routes.get_url2 + id2)
		.then()
			.statusCode(204);
	}
	
	@Test(dependsOnMethods= {"postRequestUsingPojoClass"})
	public void updateReq() {
		String id1=id;
		id1 = id1.replace("\"", "");
		 int id2=Integer.parseInt(id1);
		HashMap<String,String> data=new HashMap<String, String>();
		data.put("name", "john doe");
		data.put("job", "designer");
		users newUser=new users(data.get("name"),data.get("job"));
		given()
			.contentType(ContentType.JSON)
			.body(newUser)
		.when()
			.put(Routes.get_url2 + id2)
		.then()
			.statusCode(200);
	}
}