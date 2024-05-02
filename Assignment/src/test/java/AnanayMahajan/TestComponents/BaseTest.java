package AnanayMahajan.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import AnanayMahajan.PageObjects.Page1;


public class BaseTest {

	public WebDriver driver;
	public Page1 locator;
	
	
	
	public WebDriver initialization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	@BeforeMethod
	public Page1 launchapplication() {
		driver = initialization();
		locator = new Page1(driver);
		driver.get("https://www.worldometers.info/world-population/");
		return locator;
		
		
	}
}
