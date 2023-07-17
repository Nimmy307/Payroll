package com.obsqura.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	
	public WaitUtility(WebDriver driver) {
		this.driver = driver;
		
	}
	
	  public void waitforelementtobepresent(WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	  wait.until(ExpectedConditions.visibilityOf(element));
	  }
	 

}