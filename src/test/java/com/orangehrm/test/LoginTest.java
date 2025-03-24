package com.orangehrm.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.unitlity.PropertiesUtility;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginWithValidUsernameAndPassword() throws InvalidFormatException, IOException {
		LoginPage loginpage = new LoginPage();
		loginpage.loginToApp(PropertiesUtility.getData("username"),PropertiesUtility.getData("password"));
	}

}
