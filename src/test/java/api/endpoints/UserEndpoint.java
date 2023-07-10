package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoint {

	
	public static  Response createUser(User payload)
	{
		
		Response r=given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		
		.when()
		       .post(Router.create_url);
		
		return r;
	}

	//@Test
	public static Response getUser(String userName)
	{
		Response r=given()
			      .contentType(ContentType.JSON)
			      .accept(ContentType.JSON)
			      .pathParam("username", userName)
			
			.when()
			       .get(Router.retrive_url);
			
			return r;
	}
	
	
	public static Response updateUser(String userName,User payload)
	{
		
		Response r=given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		      .pathParam("username", userName)
		
		.when()
		       .put(Router.update_url);
		
		return r;
	}
	
	
	public static Response deleteUser(String userName)
	{
		Response r=given()
			      .pathParam("username", userName)
			
			.when()
			       .delete(Router.delete_url);
			
			return r;
	}
}
