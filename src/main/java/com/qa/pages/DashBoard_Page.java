package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DashBoard_Page extends TestBase {

	public DashBoard_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;

	public Login_Page getLloginLink() {
		loginLink.click();

		return new Login_Page();
	}
}
