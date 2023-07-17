package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class Homepage {
	WebDriver driver;

	@FindBy(linkText = "Clients")
	WebElement clients;

	@FindBy(xpath = "/html/body/section/div/div/div/p[1]")
	WebElement welcome;

	@FindBy(xpath = "/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/a")
	WebElement profile;

	@FindBy(xpath = "//*[@id=\"clientsearch-client_name\"]")
	WebElement enterclientname;

	@FindBy(xpath = "//*[@id=\"clientsearch-id\"]")
	WebElement enterclientid;

	@FindBy(xpath = "//*[@id=\"w0\"]/div[3]/button[1]")
	WebElement search;

	@FindBy(xpath = "//*[@id= 'w1']/table/tbody/tr/td[2]")
	WebElement receivedname;

	@FindBy(xpath = "//*[@id= 'w1']/table/tbody/tr/td[1]")
	WebElement receivedid;

   WaitUtility wu;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean ishomepageloaded() {
		if (profile.isDisplayed() && welcome.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void clientsearch(String clientname, String clientID) {
		wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(clients);
		clients.click();

		wu.waitforelementtobepresent(enterclientname);
		enterclientname.sendKeys(clientname);

		wu.waitforelementtobepresent(enterclientid);
		enterclientid.sendKeys(clientID);

		search.click();
	}
//for assertion
		public String namereceived() {
		wu.waitforelementtobepresent(receivedname);
			  System.out.println(receivedname.getText()); 
			  return receivedname.getText();
			  
			  }
		public String Idreceived() {
			System.out.println(receivedid.getText());
			return receivedid.getText()	;
		}
			 
   public void searchwithname(String clientname) {
   
	   wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(clients);
		clients.click();

		wu.waitforelementtobepresent(enterclientname);
		enterclientname.sendKeys(clientname);
		
		search.click();
   }
   
   public boolean isnamedisplayedproperly(String clientname) {
	   
	   wu = new WaitUtility(driver);
	   wu.waitforelementtobepresent(receivedname);
	   
	   if (receivedname.getText()==clientname) {
		  return true;
	   }
	   return false;
   }
   
}

