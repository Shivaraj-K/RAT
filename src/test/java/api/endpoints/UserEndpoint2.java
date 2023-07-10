package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//import org.testng.annotations.Test;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoint2 {

	
	public static ResourceBundle getURL()
	{
		ResourceBundle r= ResourceBundle.getBundle("routes");
		
		return r;
	}
	public static  Response createUser(User payload)
	{
		String url=getURL().getString("create_method");
		Response r=given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		
		.when()
		       .post(url);
		
		return r;
	}

	//@Test
	public static Response getUser(String userName)
	{
		String url=getURL().getString("update_methods");
		Response r=given()
			      .contentType(ContentType.JSON)
			      .accept(ContentType.JSON)
			      .pathParam("username", userName)
			
			.when()
			       .get(url);
			
			return r;
	}
	
	
	public static Response updateUser(String userName,User payload)
	{
		
		String url=getURL().getString("get_method");
		Response r=given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		      .pathParam("username", userName)
		
		.when()
		       .put(url);
		
		return r;
	}
	
	
	public static Response deleteUser(String userName)
	{
		
		String url=getURL().getString("delete_metod");
		Response r=given()
			      .pathParam("username", userName)
			
			.when()
			       .delete(url);
			
			return r;
	}
}
