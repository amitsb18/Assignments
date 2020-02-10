package generic;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFunction {
	
static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

public static WebDriver driver;


public void OpenBrowser(String url) 
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
}


public void closeBrowser()
{
	driver.quit();
}


}
