package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFunction {

	static {
		// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriverManager.chromedriver().version("80.0.3987.16").setup();
	}

	public static WebDriver driver;

	// Open chrome browser and enter url
	public void openBrowser(String url) {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
	}

	// close browser
	public void closeBrowser() {
		driver.quit();
	}

}
