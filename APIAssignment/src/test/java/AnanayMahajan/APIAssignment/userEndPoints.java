package AnanayMahajan.APIAssignment;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class userEndPoints {
	
	@Test
	public void getBookDetails() {
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void postBookDetails() {
		String book="Harry Potter";
		given()
			.contentType(ContentType.JSON)
			.body(book)
		.when()
			.post(Routes.get_url)
		.then()
			.statusCode(400);
	}
}