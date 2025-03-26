package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.test.BaseTest;

public class HomePage {
	
	@FindBy(xpath = "//a/child::span[text()='Directory']")
	WebElement directoryLink;
	
	@FindBy(xpath = "//li/span/p[contains(@class,'userdropdown-name')]")
	WebElement profileMenu;
	
	@FindBy(linkText = "Logout")
	WebElement logoutText;
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickOnDirectory() {
		directoryLink.click();
	}
	
	public void logoutFromApp() {
		profileMenu.click();
		logoutText.click();
	}

}
