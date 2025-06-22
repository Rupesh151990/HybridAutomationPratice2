package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class Login_Page extends TestBase{

	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name =  "email")
	WebElement uemail;
	
	@FindBy(name ="password")
	WebElement upassword;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;
	
	
	public Home_Page getUserCredentails(String uname, String upwd) {
		uemail.sendKeys(uname);
		upassword.sendKeys(upwd);
		loginButton.click();
		
		return new Home_Page();
	}
}
