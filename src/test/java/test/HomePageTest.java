package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parameterization;

public class HomePageTest {

	WebDriver driver;

	   @BeforeMethod
	   public void launchBrowser() throws EncryptedDocumentException, IOException  {
		   driver=LaunchBrowser.openBrowser();
		   ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
			 String user =  Parameterization.getData("Credentials", 0, 1);
			 String pass =  Parameterization.getData("Credentials", 1, 1);
			 String pin  = Parameterization.getData("Credentials", 2, 1);
			   zerodhaLoginPage.enterUserName(user);
			   zerodhaLoginPage.enterPassWord(pass);
			   zerodhaLoginPage.clickOnSubmit();
			   zerodhaLoginPage.enterPin(pin,driver);
			   zerodhaLoginPage.clickOnContinue();
		   }
	 
	   @Test
	   
	   public void SearchStockTest() {
		   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		   zerodhaHomePage.searchStock("Reliance", driver);
		   int number = zerodhaHomePage.getSearchStockResultNumber();
		   Assert.assertTrue(number >0);
	   }
	   
	   @Test
	   
	   public void SearchStockAndClickOnBuy() {
		   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		   zerodhaHomePage.searchStock("Tata", driver);
		   zerodhaHomePage.searchAndSelectDesiredStock(driver,"TATAPOWER");
		   zerodhaHomePage.clickOnSearchResultBuy();
	   }
	   
	   @Test
	   public void SearchStockAndClickOnSell() {
		   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		   zerodhaHomePage.searchStock("Tata", driver);
		   zerodhaHomePage.searchAndSelectDesiredStock(driver,"TATACOFFEE");
		   zerodhaHomePage.clickOnSearchResultSell();
	   
	}
	   @Test
	   public void SearchStockAndClickOnMarketDepth() {
		   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		   zerodhaHomePage.searchStock("Hdfc", driver);
		   zerodhaHomePage.searchAndSelectDesiredStock(driver,"HDFCBANK");
		   zerodhaHomePage.clickOnSearchResultMarketDepth();
	   }
	   
		 @Test   
	   public void SearchStockAndClickOnChart() {
		   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		   zerodhaHomePage.searchStock("Hinda", driver);
		   zerodhaHomePage.searchAndSelectDesiredStock(driver,"HINDALCO");
		   zerodhaHomePage.clickOnSearchResultChart();
	   }
	   
		 @Test
	   public void SearchStockAndClickOnAddToWatchlist() {
		   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		   zerodhaHomePage.searchStock("Vol", driver);
		   zerodhaHomePage.searchAndSelectDesiredStock(driver,"VOLTAS");
		   zerodhaHomePage.clickOnSearchResultAddToWatchlist();
		   
	   }
		 @Test
		 public void SearchStockAndClickOnDeleteToWatchlist() {
			   ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
			   zerodhaHomePage.searchStock("Mrf", driver);
			   zerodhaHomePage.searchAndSelectDesiredStock(driver,"MRF");
			   zerodhaHomePage.clickOnSearchResultDeleteToWatchlist();
}
}