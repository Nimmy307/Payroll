package com.obsqura.Testscripts;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.obsqura.utilities.FileReaderUtility;

public class TestHelper {
	WebDriver driver;

	@BeforeMethod
	@Parameters("chromebrowser")
	public void BrowserLaunch(@Optional("chrome") String browser) {
		FileReaderUtility fr = new FileReaderUtility(); // object creation of file reader as the url is mentioned in confif file and that is taken through file reader
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", fr.getchromeDriverPath());
		driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", fr.getedgeDriverPath());
			driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		//cross browser create
		driver.get(fr.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
//@Test
public void test() {
	
	
}
	@AfterMethod
		public void screenShot(ITestResult result) {
			if (ITestResult.FAILURE == result.getStatus()) {
				try {
					TakesScreenshot screenshot = (TakesScreenshot) driver;
					File src = screenshot.getScreenshotAs(OutputType.FILE);
					String path = System.getProperty("user.dir");
					FileUtils.copyFile(src,new File(path+"\\target"+result.getName()+".png"));
					System.out.println("Successfully captured a screenshot");
				} catch (Exception e) {
					System.out.println("Exception while taking screenshot " + e.getMessage());
				}
			}
		driver.close();
		
	}

}
