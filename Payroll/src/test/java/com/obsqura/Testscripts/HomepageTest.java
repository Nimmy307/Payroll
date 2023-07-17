package com.obsqura.Testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class HomepageTest extends TestHelper{
	
	@Test
	
	public void Homepagesearchverification()  {
		LoginPage lp = new LoginPage(driver);
		Homepage hp = new Homepage (driver);
		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);
		
		String clientname = "Amala poo00";
		String clientID = "1";
		hp.clientsearch(clientname, clientID);
		
		
		Assert.assertEquals(hp.Idreceived(),clientID);
		
		}
	
	@Test
	public void searchverificationwithname() {
		LoginPage lp = new LoginPage(driver);
		Homepage hp = new Homepage (driver);
		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);
		
		String clientname = "Amala poo00";
		hp.searchwithname(clientname);
		
		Assert.assertEquals(hp.namereceived(), clientname);
			
	}

	}


