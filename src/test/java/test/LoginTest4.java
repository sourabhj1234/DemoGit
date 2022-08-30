package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parameterization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class LoginTest4 extends BaseTest {
	
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void addReports() {
		reports = Reports.generateRepoerts();
	}

		   @BeforeMethod
		   public void launchBrowser()   {
			   driver=LaunchBrowser.openBrowser();
		   }
		   
		   @Test
		   
		   public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
			   test = reports.createTest("ZerodhaLoginTest");
			   ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
			 String user =  Parameterization.getData("Credentials", 0, 1);
			 String pass =  Parameterization.getData("Credentials", 1, 1);
			 String pin  = Parameterization.getData("Credentials", 2, 1);
			   zerodhaLoginPage.enterUserName(user);
			   zerodhaLoginPage.enterPassWord(pass);
			   zerodhaLoginPage.clickOnSubmit();
			   zerodhaLoginPage.enterPin(pin,driver);
			   zerodhaLoginPage.clickOnContinue();
			//  Assert.assertTrue(false);//login fail krne ke liye lagaya hai
		   }
		   
		   @DataProvider(name= "DataForTest")
		   public Object[] [] data(){
			   return new Object[] [] {{5,10,"Velocity"},{40,2,"Katraj"},{50,5,"Pune"}};
			   
		   }
		   
		   @Test(dataProvider = "DataForTest")
		   public void data(int a,int b,String s) {
			   test=reports.createTest("Data");
			   System.out.println(a+b);
			   System.out.println(s);
		   }
		  
		   @Test
		   public void validateZeodhaForgotLink() throws InterruptedException {
			   test = reports.createTest("validateZeodhaForgotLink");
			   ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
			   zerodhaLoginPage.clickOnForgot();
			 //  driver.findElement(By.xpath("(//from//label)[2]")).click();
		   }
		   
		   @AfterMethod
		   public void postTest(ITestResult result) {
			   if(result.getStatus() == ITestResult.FAILURE)
			   {
				   test.log(Status.FAIL,result.getName());
			   }
			   else if(result.getStatus() == ITestResult.SUCCESS) 
			   {
				   test.log(Status.PASS,result.getName());
			   }
			   else
			   {
				   test.log(Status.SKIP, result.getName());
			   }
		   }
		   
		   @AfterTest
		   public void flushReport() {
			   reports.flush();
		   }
		  

}
