package com.obsqura.utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageUtility{
	
	/*
	 * public PageUtility(WebDriver driver) { this.driver = driver;
	 * PageFactory.initElements(driver, this); }
	 */

	//clear and enter text method

public String getPageUrl(WebDriver driver) {

	return(driver.getCurrentUrl());

}

public void dropdown(WebElement dropdown, String opt) {
	 
	   Select dp = new Select(dropdown);
	   
	   dp.selectByIndex(0);
	    dp.selectByValue(opt);
	    //dp.selectByVisibleText(opt); 
	    }


public String getPageTitle(WebDriver driver) {

	return(driver.getTitle());

}


public boolean columnsearchcheck(String column1,String column1value, WebDriver driver) {

String header,xpathval;
int i=1,col;
	
	List<WebElement> colnames1=driver.findElements(By.xpath("//table/thead/tr/th"));
	Iterator<WebElement> itr1=colnames1.iterator();
	while(itr1.hasNext()) {
		header=itr1.next().getText();
		if(header.equalsIgnoreCase(column1)) {
		break;	
		}
		++i;
	}
	col=i; //till here column 
	
	System.out.println("Name..column no:"+col);
	xpathval="//tbody/tr/td["+col+"]";//generating xpath with col
	
	
	List<WebElement> names=driver.findElements(By.xpath(xpathval));
		Iterator<WebElement> itr2=names.iterator();
		while(itr2.hasNext()) {
			header=itr2.next().getText();
			if(header.contains(column1value)) {
			continue;	
			}
			return false;	
		}
		return true;
}

}
