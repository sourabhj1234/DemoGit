package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {

	public static void screen(WebDriver driver) throws IOException {
	
		
		TakesScreenshot sc = ((TakesScreenshot)driver);//upcast driver to TakesScreenshot
		
		File source =sc.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\Admin\\Pictures\\Screenshots\\KZ.jpg");
				
		FileHandler.copy(source, destination);		
	




	}
	}


