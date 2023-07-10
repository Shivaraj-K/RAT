package api.endpoints;

/*
 * Swagger UI
 * Base Url = https://petstore.swagger.io/v2
 *  Create method= https://petstore.swagger.io/v2/user
 *  Update methods = https://petstore.swagger.io/v2/user/{username}
 *  Retrive method = https://petstore.swagger.io/v2/user/{username}
 *  Dlete metod  =  https://petstore.swagger.io/v2/user/{username}
 */
public class Router {

	// Router class basically only for URL
	public static String base_url="https://petstore.swagger.io/v2";
	
	public static String create_url=base_url+"/user";
	public static String retrive_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
}
