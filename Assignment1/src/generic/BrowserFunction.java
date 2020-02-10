package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrowserFunction {
	
static {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

protected WebDriver driver;


public void OpenBrowser(String url) 
{
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	
}


public void closeBrowser()
{
	driver.quit();

}


}
