package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class LoginPage{
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='loginform-username']") 
	WebElement username;
	
	@FindBy(xpath = "//*[@id='loginform-password']") 
	WebElement password;
	
	
	@FindBy(xpath = "//*[@id='login-form']/div[5]/button") 
	WebElement loginbutton;
	
	@FindBy (xpath = "//*[@id=\"login-form\"]/div[2]/p")
	WebElement incorrectlogin;
	
	WebElement we;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void login(String user_name,String pass_word) {
    enterusername(user_name);
    System.out.println(username);
	enterpassword(pass_word);
	clickloginbutton();
	
}
	
	public void enterusername(String user_name) {
	username.sendKeys(user_name);
	}
		
	public void enterpassword(String pass_word) {
			password.sendKeys(pass_word);
	}
	public void clickloginbutton() {
			loginbutton.click();
	}
	
	public boolean invalidlogin() {
		WaitUtility wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(incorrectlogin);
		if(incorrectlogin.isDisplayed()) {
			return true;
		}
		return false;
	}
}
 
