package com.obsqura.Testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.Workerspage;

public class WorkersTest extends TestHelper {

	@Test
	public void isworkerspageproperlyloaded() {

		LoginPage lp = new LoginPage(driver);
		Workerspage wp = new Workerspage(driver);

		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);
		wp.workersclick();
		Assert.assertTrue(wp.isworkerspageloaded());

	}

	//@Test
	public void searchverificationdynamically() {

		LoginPage lp = new LoginPage(driver);
		Workerspage wp = new Workerspage(driver);

		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);

		wp.search("Jose");

		Assert.assertTrue(wp.isserchcorrect("column1", "column1value"));
	}

	@Test

	public void viewverification() {
		LoginPage lp = new LoginPage(driver);
		Workerspage wp = new Workerspage(driver);

		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);
		wp.view();
		String actualnum = "695581";
		Assert.assertEquals(wp.checkview(), actualnum);
	}

	@Test

	public void editverification() {

		LoginPage lp = new LoginPage(driver);
		Workerspage wp = new Workerspage(driver);

		String username = "carol";
		String password = "1q2w3e4r";
		lp.login(username, password);
		wp.edit();

		Assert.assertTrue(wp.isproperlyedited());
	}

}
