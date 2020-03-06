package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserFunctions {

	static String browser;
	static WebDriver driver;

	@Test(priority = 1)
	public void browser() {
		browser = "chrome";
	}

	@Test(priority = 2)
	public void openBrowser() {
		if (browser.contains("chrome")){
			WebDriverManager.chromedriver().version("80.0.3987.16").setup();
			driver = new ChromeDriver();
			
		} else if (browser == "firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}

	@Test(priority = 3)
	public void getCoordinatesValues() {
		driver.get("http://automationpractice.com/");
	}
}
