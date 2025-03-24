package com.orangehrm.test;

import org.testng.annotations.Test;

import com.orangehrm.pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void logout() {
		HomePage homepage = new HomePage();
		homepage.clickOnDirectory();
		homepage.logoutFromApp();
		
	}
}
