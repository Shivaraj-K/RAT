package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoint;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class UsersTest {

	@Test(priority=1,dataProvider="data",dataProviderClass=Dataproviders.class)
	public void CreateMethod(String userID,String UserName,String FirstName,String LastName,String email,String password,String phone)
	{
		User u=new User();
		System.out.println(u.getId()+" the id");
		u.setId(Integer.parseInt(userID));
		u.setUsername(UserName);
        u.setFirstName(FirstName);
		u.setLastName(LastName);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		
		System.out.println(u.getId()+" the id");
        Response r=UserEndpoint.createUser(u);
		
		r.then().log().body();
	}
	
	@Test(priority=2,dataProvider="userName",dataProviderClass=Dataproviders.class)
	public void deleteMethod(String UserName)
	{
		User u=new User();
       Response r=UserEndpoint.deleteUser(UserName);
		
		Assert.assertEquals(r.getStatusCode(), 200);
	}
}
