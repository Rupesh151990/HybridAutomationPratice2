package com.qa.testcases;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashBoard_Page;
import com.qa.pages.Login_Page;
import com.qa.utilies.TestUtilies;

public class Login_Test extends TestBase {

	DashBoard_Page dbpage;
	Login_Page lgPage;
	String sheetName = "loginCredentails";

	public Login_Test() {
		super();
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = TestUtilies.getTestData(sheetName);
		return data;
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		dbpage = new DashBoard_Page();
		dbpage.getLloginLink();

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		String parentWindow = iterator.next();
		System.out.println(parentWindow);
		String childWindow = iterator.next();

		driver.switchTo().window(childWindow);

	}

	@Test(dataProvider = "getLoginTestData")
	public void verify_LoginTest(String username, String password) {

		lgPage = new Login_Page();
		lgPage.getUserCredentails(username, password);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
