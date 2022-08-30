package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parameterization;

@Listeners(utility.Listeners.class)

public class LoginPageTest2 extends BaseTest {

	   @BeforeMethod
	   public void launchBrowser()   {
		   driver=LaunchBrowser.openBrowser();
	   }
	   
	   @Test
	   
	   public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		   ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		 String user =  Parameterization.getData("Credentials", 0, 1);
		 String pass =  Parameterization.getData("Credentials", 1, 1);
		 String pin  = Parameterization.getData("Credentials", 2, 1);
		   zerodhaLoginPage.enterUserName(user);
		   zerodhaLoginPage.enterPassWord(pass);
		   zerodhaLoginPage.clickOnSubmit();
		  // Thread.sleep(2000);//bina thread sleep ke login nahi hota lekin explicit wait lagya hai isliye login hoga
		   zerodhaLoginPage.enterPin(pin,driver);
		   zerodhaLoginPage.clickOnContinue();
		  Assert.assertTrue(false);//login fail krne ke liye lagaya hai
	   }
	  
	   @Test
	   public void validateZeodhaForgotLink() throws InterruptedException {
		   ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		   zerodhaLoginPage.clickOnForgot();
		  // Thread.sleep(2000);
		   driver.findElement(By.xpath("(//from//label)[2]")).click();
	   }
	  
	}

