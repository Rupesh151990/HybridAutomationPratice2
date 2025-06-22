package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashBoard_Page;
import com.qa.utilies.TestUtilies;

public class DashBoard_Test extends TestBase {

	DashBoard_Page dbpage;
	
	public DashBoard_Test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
	}
	
	
	@Test
	public void verify_DashBoardPage() {
		dbpage = new DashBoard_Page();
		dbpage.getLloginLink();
	}
	
	@AfterMethod
	public void tearDown() {
		TestUtilies.sync(4);
		driver.quit();
	}
}
