package script;

import java.util.ArrayList;
import org.testng.annotations.Test;
import generic.BrowserFunction;
import page.FindPriceFromAmazonPage;
import page.FindPriceFromFlipkartPage;

public class GetPrice extends BrowserFunction {

	float flipkartPrice;
	float amazonPrice;

	@Test
	public float getProductPriceFromAmazon() throws InterruptedException {

		openBrowser("https://www.amazon.in./");
		FindPriceFromAmazonPage amazon = new FindPriceFromAmazonPage(driver);
		amazon.searchProduct("iPhone XR (64GB) - Yellow");
		amazon.selectFirstProduct();

		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));

		float amazonPrice = amazon.getProductPrice();

		System.out.println("iPhone XR (64GB) - Yellow(Amazon Price): " + amazonPrice);

		closeBrowser();

		return amazonPrice;

	}

	@Test
	public float getProductPriceFromFlipkart() throws InterruptedException {

		openBrowser("https://www.flipkart.com");
		FindPriceFromFlipkartPage flipkart = new FindPriceFromFlipkartPage(driver);
		flipkart.closeLoginPopup();
		flipkart.searchProduct("iPhone XR (64GB) - Yellow");
		Thread.sleep(3000);
		flipkart.selectProduct();

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		float flipkartPrice = flipkart.getProductPrice();

		System.out.println("iPhone XR (64GB) - Yellow(Flipkart Price): " + flipkartPrice);

		closeBrowser();

		return flipkartPrice;

	}

	// Get product price from Amazon and Flipkart and return the product lowest
	// price
	@Test(priority = 1)
	public void comparePrice() throws InterruptedException {

		amazonPrice = getProductPriceFromAmazon();
		flipkartPrice = getProductPriceFromFlipkart();

		if (flipkartPrice < amazonPrice) {

			System.out.println("Flipkart has " + flipkartPrice
					+ " price for \"iPhone XR (64GB) - Yellow\" which is lesser than Amazon price " + amazonPrice + "");
		} else {
			System.out.println("Amazon has " + amazonPrice
					+ " price for \"iPhone XR (64GB) - Yellow\" which is lesser than Flipkart price " + flipkartPrice
					+ "");
		}

	}
}
