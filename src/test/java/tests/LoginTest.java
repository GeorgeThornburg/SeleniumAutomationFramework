package tests;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.Thread;
import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\test_data\\TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];
		
		for (int i = 1 ; i < rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0); //username
			data[i-1][1] = ExcelUtils.getCellData(i, 1); //password
			
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	
	@DataProvider(name = "LoginData2")
	public Object[][] getData() {
		
		return new Object[][] {
			{"user1", "pass1"},
			{"user2", "pass2"},
			{"user3", "pass3"}
			
		};
		
	}
	
	
	
	

//	@Test(dataProvider = "LoginData2")
//	@Test
//	@Parameters({"username", "password"})
	public void testValidLogin(String username, String password){
		
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test with Invalid Credintials - " + username);
		
		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigated to Login Page");
		
		Log.info("Adding credentials");
//		loginPage.enterUserName("admin1234@yourstore.com");
//		loginPage.enterPassword("admin");
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		test.info("Clicking on Login Button");
		
		
		System.out.println("Title of the page is :" + driver.getTitle());
		test.info("Verifying Page Title");
		Log.info("Verifying page title.");
		Assert.assertEquals(driver.getTitle(), "Just a moment..."); 
		test.pass("Login Successful"); 
	}
		
		
	@Test
	public void testLoginWithInvalidCredintials() {
		
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test with Invalid Credintials");
		
		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigated to Login Page");
		
		Log.info("Adding credentials");
		loginPage.enterUserName("admin1234@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		test.info("Clicking on Login Button");
		
		
		System.out.println("Title of the page is :" + driver.getTitle());
		test.info("Verifying Page Title");
		Log.info("Verifying page title.");
		Assert.assertEquals(driver.getTitle(), "Just a moment...1"); 
		test.pass("Login Successful"); 
	}		
		


	
}
