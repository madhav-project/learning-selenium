package mvpautomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	RemoteWebDriver driver;

	@Test
	@Parameters({ "username", "password" })
	public void loginApp(String username, String password) throws MalformedURLException {

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-maddyp238-281af");
		sauceOptions.put("accessKey", "e4ebaee2-5d36-4ce2-b999-b02b5df2e40b");
		sauceOptions.put("build", "mvp-selenium-test");
		sauceOptions.put("name", "Sanity Test");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new RemoteWebDriver(url, browserOptions);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	@Test(dependsOnMethods = "loginApp")
	@Parameters({ "empname" })
	public void clickDirectory(String empname) {

		driver.findElement(By.xpath("//a/child::span[text()='Directory']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'hints')]")).sendKeys(empname);

	}

//	@Ignore
	@Test(dependsOnMethods = "loginApp")
	public void logout() {

		driver.findElement(By.xpath("//li/span/p[contains(@class,'userdropdown-name')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Logout")).click();

	}

	@Test(dependsOnMethods = "logout")
	public void closeBrowser() {
		driver.quit();

	}

}
