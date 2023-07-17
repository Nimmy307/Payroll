package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class Clientpage extends PageUtility{
	WebDriver driver;

	@FindBy(linkText= "Clients")
	WebElement clients;
	
	@FindBy (xpath = "//section/div/div/div[1]/ul/li[2]/a")
	WebElement createclient;
	
	
	@FindBy(xpath = "//*[@id='client-client_name']")
	WebElement clientname;
	
	@FindBy (xpath = "//*[@id= 'client-client_address']")
	WebElement Address;
	
	@FindBy (xpath = "//*[@id= 'client-postcode']")
	WebElement Postcode;
	
	@FindBy (xpath = "//*[@id= 'client-invoice_contact']")
	WebElement Invoicecontact;
	
	@FindBy (xpath = "//*[@id= 'client-phone']")
	WebElement Phone;
	
	@FindBy(xpath = "//*[@id= 'client-email']")
	WebElement Email;
	
	@FindBy(xpath = "//*[@id= 'clientsearch-client_name']")
	WebElement enterclientname;
	
	@FindBy (xpath ="//*[@id= 'client-company_reg']")
	WebElement Companyreg;
	
	@FindBy (xpath ="//*[@id= 'client-settilement_days']")
	WebElement Days;
	
	@FindBy (xpath = "//*[@id= 'client-branch_id']")
	WebElement dropdown1;
	
	@FindBy (xpath ="//*[@id= 'client-division_id']")
	WebElement dropdown2;
	
	@FindBy (xpath = "//*[@id='client-invoice_order']") 
	WebElement dropdown3;
		
	@FindBy (xpath = "//*[@id='client-invoice_delivery_method']")
	WebElement dropdown4;
	
	@FindBy (xpath ="//*[@id='client-master_document']")
	WebElement dropdown5;
	
	@FindBy (xpath = "//*[@id= 'client-vat_rate']")
	WebElement dropdown6;
	
	@FindBy (xpath = "//*[@id=\"w0\"]/div[4]/div/button")
	WebElement save;
	
	@FindBy(xpath = "//*[@id=\"w0\"]/div[3]/button[1]")
	WebElement search;
	
	@FindBy(xpath = "//*[@id= 'w1']/table/tbody/tr/td[2]")
	WebElement receivedname;
	
	@FindBy (xpath = "//*[@id= 'w1']/table/tbody/tr[1]/td[6]/a[1]")
	WebElement view;
	
	@FindBy (xpath ="//*[@id='w0']/tbody/tr[6]/td")
	WebElement receivedpostcode;
	
	@FindBy (xpath = "//*[@id='w1']/table/tbody/tr[2]/td[6]/a[2]")
	WebElement edit;
	
	@FindBy (xpath = "//*[@id='client-invoice_contact']")
	WebElement editablefield;
	
	@FindBy (xpath = "//*[@id='client-invoice_contact']")
	WebElement editedfield;
	
	WaitUtility wu;
		
	public Clientpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createclient(String name, String address, String postcode,String invoicecontact, String phone,String email, String companyreg, String days) {
	
		wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(clients);
	
		clients.click();
		createclient.click();
		clientname.sendKeys(name);
		Address.sendKeys(address);
		Postcode.sendKeys(postcode);
		Invoicecontact.sendKeys(invoicecontact);
		Phone.sendKeys(phone);
		Email.sendKeys(email);
		Companyreg.sendKeys(companyreg);
		Days.sendKeys(days);
		
		Select value1 = new Select(dropdown1);
		value1.selectByIndex(1);
		
		Select value2 = new Select(dropdown2);
		value2.selectByIndex(1);
		
		Select value3 = new Select(dropdown3);
		value3.selectByIndex(1);
		
		Select value4 = new Select(dropdown4);
		value4.selectByIndex(1);
		
		Select value5 = new Select(dropdown5);
		value5.selectByIndex(1);
		
		Select value6 = new Select(dropdown6);
		value6.selectByIndex(1);
		
		driver.manage().window().maximize();
		wu.waitforelementtobepresent(save);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click()", save);
	}
	
	public boolean isclientcreated(String name) {
		WaitUtility wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(clients);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", clients );
		clients.click();
	
		wu.waitforelementtobepresent(enterclientname);
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", enterclientname );
		enterclientname.sendKeys(name);
		search.click();
		if (receivedname.isDisplayed()) {
		return true;
	}
	return false;
	}
	
	public void view() {
		
		wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(clients);
	
		clients.click();
		view.click();	
	}
	
	public String viewcheck() {
		return receivedpostcode.getText();
	}
	
	public void edit() {
		wu = new WaitUtility(driver);
		wu.waitforelementtobepresent(clients);
	
		clients.click();
		
		wu.waitforelementtobepresent(edit);
		edit.click();
		wu.waitforelementtobepresent(editablefield);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", editablefield);
		editablefield.clear();
		wu.waitforelementtobepresent(editablefield);
		editablefield.sendKeys("305467");
	}
	
	public boolean isproperlyedited() {
		if (editablefield.getText()!=editedfield.getText()) {
			return true;
		}
		return false;
		}
			
	}

