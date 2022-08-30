package pojo;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static WebDriver openBrowser() {
		ChromeOptions option = new ChromeOptions();//1
		option.addArguments("--disable-notifications");//2=zeodha login krne ke bad jo notification popup ata hai use disabled krne ke liye 1&2 step krte hai aur 14 n0.line (option)pass krte hai
	//	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		     WebDriverManager.chromedriver().setup();//agar hum 15 no.line nahi denge aur webdrivermanager ki dependency add krke 16no.line likhe to login successfully hota hai
			WebDriver driver =new ChromeDriver(option);
			driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));//implicit wait
			driver.navigate().to("https://kite.zerodha.com/");
			return driver;
	}
		
			}

