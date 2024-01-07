package GetRequest_Tests;

import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Base_Testng;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AllGetRequests extends Base_Testng {
	
	
	@Test (description = "LIST USERS")
	public void Lisfofuser() throws UnsupportedEncodingException
	{
		
		RestAssured.baseURI=globalProp.getProperty("baseURI");
		test = report.startTest("LIST USERS of users");
		
		Response res=	reuseablecomponents.executeGetAPI(globalProp.getProperty("LISTUSERS"), globalProp, test);
		test.assignCategory(this.getClass().getCanonicalName());
		
		
		Assert.assertEquals(Integer.toString(res.statusCode()), "200");
		
		reuseablecomponents.validateStatusCode(Integer.toString(res.statusCode()), "200", test);
		report.endTest(test);
		
		
		
	}
	
	
	@Test (description = "SINGLE USER")
	public void SingleUser() throws UnsupportedEncodingException
	{
		
		RestAssured.baseURI=globalProp.getProperty("baseURI");
		test= report.startTest("SINGLE USER");
		test.assignCategory(this.getClass().getCanonicalName());
		
		Response res=reuseablecomponents.executeGetAPI(globalProp.getProperty("SINGLEUSER"), globalProp, test);
		//test.assignCategory(this.getClass().getSimpleName());
		reuseablecomponents.validateStatusCode(Integer.toString(res.statusCode()), "200", test);
		
		Assert.assertEquals(Integer.toString(res.statusCode()), "200");
		
		report.endTest(test);
		
		
		
	}

}
