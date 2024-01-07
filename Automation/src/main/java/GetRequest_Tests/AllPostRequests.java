package GetRequest_Tests;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Base_Testng;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AllPostRequests extends Base_Testng {
	
	
	@Test (dataProvider ="createuser",  description = "Create USERS")
	public void Lisfofuser(String filenname) throws IOException
	{
		
		RestAssured.baseURI=globalProp.getProperty("baseURI");
		test = report.startTest("Create User...");
		
		String reqbody=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//payload//"+filenname),StandardCharsets.UTF_8);
		Response res=	reuseablecomponents.executePostAPI(globalProp.getProperty("CREATEUSER"), reqbody,globalProp, test);
		test.assignCategory(this.getClass().getCanonicalName());
		
		
		Assert.assertEquals(Integer.toString(res.statusCode()), "201");
		
		reuseablecomponents.validateStatusCode(Integer.toString(res.statusCode()), "200", test);
		report.endTest(test);
		
		
		
	}
	
	@DataProvider(name="createuser")
	public Object[][] createuser()
	{
		
		return new Object[] [] {{"createuser.json"}};
	}
	/*
	 * @Test (description = "SINGLE USER") public void SingleUser() throws
	 * UnsupportedEncodingException {
	 * 
	 * RestAssured.baseURI=globalProp.getProperty("baseURI"); test=
	 * report.startTest("SINGLE USER");
	 * test.assignCategory(this.getClass().getCanonicalName());
	 * 
	 * Response
	 * res=reuseablecomponents.executeGetAPI(globalProp.getProperty("SINGLEUSER"),
	 * globalProp, test); //test.assignCategory(this.getClass().getSimpleName());
	 * reuseablecomponents.validateStatusCode(Integer.toString(res.statusCode()),
	 * "200", test);
	 * 
	 * Assert.assertEquals(Integer.toString(res.statusCode()), "200");
	 * 
	 * report.endTest(test);
	 * 
	 * 
	 * 
	 * }
	 */


}
