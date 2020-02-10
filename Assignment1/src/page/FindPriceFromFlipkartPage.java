package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FindPriceFromFlipkartPage {
		
		@FindBy(xpath = "//button[.='✕']")
		private WebElement clickclosebutton;
		
		public FindPriceFromFlipkartPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void closepopup() {
			boolean result = clickclosebutton.isDisplayed();
			if(result == true) {
				clickclosebutton.click();
			}
		}
		
		@FindBy(xpath = "//input[@type='text']")
		private WebElement FlipkartSearch;
		
		public void SearchProduct(String productname) {
			FlipkartSearch.sendKeys(productname);
			FlipkartSearch.sendKeys(Keys.ENTER);
		}
		
		@FindBy(xpath ="//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]")
		private WebElement SelectProduct;

		public void SelectProduct() {
			SelectProduct.click();
		}
		
		@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]/../../../div[3]/div[1]/div[1]/div[1]")
		private WebElement GetProductPrice;

		public float GetProductPrice() {
			String flipkartInitalPrice = GetProductPrice.getText();
			String flipkartsortPrice = flipkartInitalPrice.replace("₹", "").replace(",","");
			float flipkartPrice = Float.parseFloat(flipkartsortPrice);
			return flipkartPrice;
		}
		

}
