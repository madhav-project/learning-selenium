package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.test.BaseTest;
import com.reports.ExtentReportUtils;
public class LoginPage {
	
	// username, password, login button
	@FindBy(name = "username")
	WebElement userNameTextbox;
	
	@FindBy(name = "password")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;
	
	public LoginPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void loginToApp(String username, String password) {
		userNameTextbox.sendKeys(username);
		ExtentReportUtils.addStep("Username is entered");
		
		passwordTextbox.sendKeys(password);
		ExtentReportUtils.addStep("Password is entered");
		
		submitBtn.click();
		ExtentReportUtils.addStep("Login button is clicked");
	}
	
}
