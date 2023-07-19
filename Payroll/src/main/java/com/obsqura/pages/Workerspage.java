package com.obsqura.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

import net.bytebuddy.asm.Advice.Enter;

public class Workerspage extends PageUtility {
	int i = 1, row, col;

	String xpathval, EmploymentType;

	WebDriver driver;

	@FindBy(linkText = "Workers")
	WebElement Worker;

	@FindBy(xpath = "//*[@id= 'workersearch-first_name']")
	WebElement firstname;

	@FindBy(xpath = "//*[@id= 'w0']/div[5]/button[1]")
	WebElement search;

	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td")
	List<WebElement> Names;

	@FindBy(xpath = "//*[@id=\"w1\"]/table/thead/tr/th")
	List<WebElement> headers;

	@FindBy(xpath = "//*[@id= 'w1']/table/tbody/tr[2]/td[8]/a[1]")
	WebElement view;

	@FindBy(xpath = "//*[@id=\"worker-address1\"]")
	WebElement fieldeditable;

	@FindBy(xpath = "//*[@id=\"worker-address1\"]")
	WebElement editedfield;

	@FindBy(xpath = "//*[@id='w1']/table/tbody/tr[2]/td[8]/a[2]")
	WebElement edit;

	@FindBy(xpath = "//*[@id='w0']/tbody/tr[20]/td")
	WebElement receivednum;

	@FindBy(xpath = "//*[@id='w1']/table/tbody/tr[2]/td[7]")
	WebElement actualnum;

	@FindBy(xpath = "//*[@id= 'workersearch-postcode']")
	WebElement postcode;

	@FindBy(xpath = "//*[@id= 'w1']/table/tbody/tr[1]/td[8]/a[3]")
	WebElement deleteentry;

	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td[2]")
	WebElement deletedentry;

	public Workerspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void workersclick() {
		Worker.click();
	}

	public boolean isworkerspageloaded() {
		if (Worker.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void search(String First_name) {

		Worker.click();
		firstname.sendKeys(First_name);
		search.click();
	}

	public boolean isserchcorrect(String column1, String column1value) {
		return columnsearchcheck(column1, column1value, driver);
	}

	public void view() {
		Worker.click();
		view.click();
	}

	public String checkview() {
		return receivednum.getText();
	}

	public void edit() {
		Worker.click();
		edit.click();
		fieldeditable.click();
		fieldeditable.clear();
		fieldeditable.sendKeys("Kottayam");
	}

	public boolean isproperlyedited() {

		if (fieldeditable.getText() != editedfield.getText()) {
			return true;
		}
		return false;
	}

}