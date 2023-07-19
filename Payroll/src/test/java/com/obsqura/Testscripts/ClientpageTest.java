package com.obsqura.Testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.Clientpage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.Workerspage;

public class ClientpageTest extends TestHelper {
	@Test
	public void clientpagecreateclientverification() {

		LoginPage lp = new LoginPage(driver);
		Homepage hp = new Homepage(driver);
		Clientpage cp = new Clientpage(driver);

		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);

		String name = "Maria";
		String address = "abc Apartment, chennai";
		String postcode = "1256";
		String invoicecontact = "345";
		String phone = "934567898";
		String email = "123@gmail.com";
		String companyreg = "2ab";
		String days = "15";

		cp.createclient(name, address, postcode, invoicecontact, phone, email, companyreg, days);
		Assert.assertTrue(cp.isclientcreated(name));

	}

	@Test

	public void viewverification() {
		LoginPage lp = new LoginPage(driver);
		Clientpage cp = new Clientpage(driver);

		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);
		cp.view();

		String actualnum = "1000034566";
		Assert.assertEquals(cp.viewcheck(), actualnum);
	}

}
