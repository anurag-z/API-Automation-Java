package base;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reuseablelibrary.Reuseablecomponents;


public class Base_Testng {

	public static ExtentReports report;
	public static ExtentTest test;
	public static Properties globalProp;
	public Reuseablecomponents reuseablecomponents= new Reuseablecomponents();
	
	
	@BeforeSuite(alwaysRun = true)
	public void starttest(ITestContext testContext) throws IOException
	{
		
		Date date= Calendar.getInstance().getTime();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		String strdate= df.format(date);
		String path=System.getProperty("user.dir");
		readglobal();
		File reportfile= new File(path+"//extent"+strdate+".html");
		
		if(!reportfile.exists())
		{
			reportfile.createNewFile();
			
		}
		
		report= new ExtentReports(path+"//extent"+strdate+".html",true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void stoptest()
	{
		report.endTest(test);
		report.flush();
		
	}
	
	
	public void readglobal() throws IOException
	{
		String path=System.getProperty("user.dir");
		FileReader fr= new FileReader(path+"//Globalproperty.properties");
		Properties prop= new Properties();
		prop.load(fr);
		globalProp=prop;
		
		
	}
	
}
