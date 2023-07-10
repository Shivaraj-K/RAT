package api.test;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker f;
	User u;
	public Logger l;
	@BeforeClass
	public void setupDate()
	{
		f=new Faker();
		u=new User();
		u.setFirstName(f.name().firstName());
		
		u.setLastName("Guttedar");
		u.setId(f.idNumber().hashCode());
		u.setEmail(f.internet().emailAddress());
		u.setPassword(f.internet().password());
		u.setPhone(f.phoneNumber().cellPhone());
		u.setUsername(f.name().username());
		
		l=LogManager.getLogger("UserTest");
	}
	
	@Test(priority=1)
	public void createUesrs()
	{
		l.info("Creating User");
		Response r=UserEndpoint.createUser(u);
		
		r.then().log().body();
		
		l.info("Created User");
	}
	
	@Test(priority=2)
	public void getUsers()
	{
//		l.info("Get the User");
		Response r=UserEndpoint.getUser(this.u.getUsername());
		
		r.then().log().all();
		
		Assert.assertEquals(r.getStatusCode(), 200);
		
		//l.info("Getting that User");
	}
	
	@Test(priority=3)
	public void UpdateUesrs()
	{
		//l.info("Update User");
        u.setFirstName(f.name().firstName());
		
		u.setLastName("S Guttedar");
		u.setId(f.idNumber().hashCode());
		
		Response r=UserEndpoint.updateUser(this.u.getUsername(), u);
		Response r1=UserEndpoint.getUser(this.u.getUsername());
		r1.then().log().body();
		
		//l.info("Updated User");
		
		
	}
	
	@Test(priority=4)
	public void deleteUsers()
	{
		//l.info("Delet the User");
		Response r=UserEndpoint.deleteUser(this.u.getUsername());
		
		r.then().log().all();
		
		Assert.assertEquals(r.getStatusCode(), 200);
		
		//l.info("Deleted the  User");
	}
}

