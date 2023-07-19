package com.obsqura.Testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.listeners.reportlisteners;
import com.obsqura.pages.*;
import com.obsqura.utilities.*;

@Listeners(reportlisteners.class)
public class LoginPageTest extends TestHelper {
	FileReaderUtility fr = new FileReaderUtility();

	@DataProvider(name = "Login")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "carol", "1q2w3e4r" }, };
	}

	@DataProvider(name = "InvalidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "car", "1q2w3" }, };
	}

	@Test(dataProvider = "Login")
	public void VerifyvalidLogin(String username, String password) {

		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);

		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.ishomepageloaded());
	}

	@Test(dataProvider = "InvalidLogin")
	public void VerifyinvalidLogin(String username, String password) {

		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);

		String invalidlogin = "Incorrect username or password.";

		Assert.assertTrue(lp.invalidlogin());
	}

}
