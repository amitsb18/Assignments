package script;
import java.util.ArrayList;
import org.testng.annotations.Test;
import generic.BrowserFunction;
import page.FindPriceFromAmazonPage;
import page.FindPriceFromFlipkartPage;


public class GetPrice extends BrowserFunction {
	
	float flipkartPrice ;
	float amazonPrice;
	
	@Test
	public float AmazonPrice() throws InterruptedException {

		OpenBrowser("https://www.amazon.in./");
		FindPriceFromAmazonPage amazon = new FindPriceFromAmazonPage(driver);
		amazon.SearchProduct("iPhone XR (64GB) - Yellow"); 
		amazon.SelectProduct();
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
		
	    float amazonPrice = amazon.GetProductPrice();
	
		System.out.println("iPhone XR (64GB) - Yellow(Amazon Price): "+amazonPrice);
		
		closeBrowser();
		
		return amazonPrice;
		
	}
	
	@Test
	public float FlipkartPrice() throws InterruptedException {
			
		OpenBrowser("https://www.flipkart.com");
		FindPriceFromFlipkartPage flipkart = new FindPriceFromFlipkartPage(driver);
		flipkart.closepopup();
		flipkart.SearchProduct("iPhone XR (64GB) - Yellow");
		Thread.sleep(3000);
	    flipkart.SelectProduct();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		
		float flipkartPrice = flipkart.GetProductPrice();
		
		System.out.println("iPhone XR (64GB) - Yellow(Flipkart Price): "+flipkartPrice);
		
		closeBrowser();
		
		return flipkartPrice;
		
	}
	
	@Test(priority = 1)
	public void ComparePrice() throws InterruptedException {
		
		amazonPrice = AmazonPrice();
		flipkartPrice= FlipkartPrice();
		
		if(flipkartPrice < amazonPrice ) {
		
			System.out.println("Flipkart has "+flipkartPrice+" price for \"iPhone XR (64GB) - Yellow\" which is lesser than Amazon price "+amazonPrice+"");
		}
		else {
			System.out.println("Amazon has "+amazonPrice+" price for \"iPhone XR (64GB) - Yellow\" which is lesser than Flipkart price "+flipkartPrice+"");
		}
		
	}
}

	
