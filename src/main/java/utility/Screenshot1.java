package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot1 {

	public static void takeScreenshot(WebDriver driver, String name) throws IOException {
	
		
		TakesScreenshot sj = ((TakesScreenshot)driver);//upcast driver to TakesScreenshot
		
		File source =sj.getScreenshotAs(OutputType.FILE);
	
		File destination = new File("C:\\Users\\Admin\\eclipse-workspace\\ZerodhaAutomation\\Screenshot\\"+name+".jpg");
		
		FileHandler.copy(source, destination);	
}}
