package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("Title of the page is :" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment..."); }
		
		
		
		
		
	@Test
	public void testInvalidLogin() throws InterruptedException {
	    LoginPage loginPage = new LoginPage(driver);

	    Thread.sleep(5000);
	    loginPage.enterUserName("admin@yourstore.com");

	    Thread.sleep(5000);
	    loginPage.enterPassword("admin1asdf");

	    Thread.sleep(5000);
	    loginPage.clickLogin();

	    Thread.sleep(5000);
	    loginPage.clickHumanBox();

	    System.out.println("Title of the page is :" + driver.getTitle());
	    Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}

	
}
