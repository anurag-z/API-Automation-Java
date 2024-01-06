package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Base_Testng;
import io.restassured.RestAssured;

public class Test1 extends Base_Testng {
	
	
	@Test (description = "Testing")
	public void testing()
	{
		try {
		RestAssured.baseURI="https://reqres.in";
		 test= report.startTest("Inside test");
		
		reuseablecomponents.executeGetAPI(globalProp.getProperty("endpoint"), globalProp, test);
		test.log(LogStatus.INFO, globalProp.getProperty("base"));
		Assert.assertEquals(false, false);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
