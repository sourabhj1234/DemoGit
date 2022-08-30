package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {

	@FindBy (xpath ="//input[@type='text']") private WebElement search;
	@FindBy (xpath = "//span[@class='tradingsymbol']") private List<WebElement> searchResult;//tatapower search krne ke bad usko inspect krne ke bad ye xpath ata hai
    @FindBy (xpath = "//button[@data-balloon=\"Buy\"]") private WebElement searchBuy;
    @FindBy (xpath = "//button[@class='button-orange']") private WebElement searchSell;
    @FindBy (xpath ="//span[@class='icon icon-align-center']") private WebElement marketDepth;
    @FindBy (xpath ="//span[@class='icon icon-trending-up']") private WebElement chart;
    @FindBy (xpath = "//span[@class='icon icon-plus']") private WebElement addWatchlist;
    @FindBy (xpath = "//span[@class='icon icon-trash']") private WebElement deleteWatchlist;
    
    public ZerodhaHomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

    public void searchStock(String stock, WebDriver driver) {
   	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
    	wait.until(ExpectedConditions.visibilityOf(search));
    	search.sendKeys(stock);//explicit wait lagane per hi search click hoga
    }
    
    public int getSearchStockResultNumber() {
    	int listSize = searchResult.size();
    	return listSize;
    }
    
    public void searchAndSelectDesiredStock(WebDriver driver,String RequiredStock) {
    	for(int a =0; a < searchResult.size();a++)
    	{
    		WebElement s = searchResult.get(a);
    		String StockName = s.getText();
    		
    		if(StockName.equals(RequiredStock)) 
    		{
    			Actions actions = new Actions(driver);
    			actions.moveToElement(s);
    			actions.perform();
    			break;	
    		}
    	}
    }
    
    public void clickOnSearchResultBuy() {
    	searchBuy.click();
    }
    
    public void clickOnSearchResultSell() {
    	searchSell.click();

 }
    public void clickOnSearchResultMarketDepth() {
       marketDepth.click();
 }
    
    public void clickOnSearchResultChart() {
    	chart.click();
    }
    
    public void clickOnSearchResultAddToWatchlist() {
    	addWatchlist.click();
    }
    
    public void clickOnSearchResultDeleteToWatchlist() {
    	deleteWatchlist.click();
}
    
}  
    