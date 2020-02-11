package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFunction {

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

	protected WebDriver driver;

	// Open chrome browser and enter url
	public void openBrowser(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	// close browser
	public void closeBrowser() {
		driver.quit();
	}

}
