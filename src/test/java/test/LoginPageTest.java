package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.Parameterization;
import utility.Screenshot;

public class LoginPageTest {
WebDriver driver;

   @BeforeMethod
   public void launchBrowser() {
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
	  // Thread.sleep(2000);//bina thread sleep ke login nahi hota
	   zerodhaLoginPage.enterPin(pin,driver);
	   zerodhaLoginPage.clickOnContinue();
	   Screenshot.screen(driver);//screenshot ke liye lagya hai
   }
}
