package page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FindPriceFromFlipkartPage {
	
	public FindPriceFromFlipkartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	
		// Declaring elements using @FindBY annotation
		@FindBy(xpath = "//button[.='✕']")
		private List<WebElement> clickclosebutton;
		
		@FindBy(xpath = "//input[@type='text']")
		private WebElement FlipkartSearch;
		
		@FindBy(xpath ="//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]")
		private WebElement SelectProduct;
		
		@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]/../../../div[3]/div[1]/div[1]/div[1]")
		private WebElement GetProductPrice;
		
		
		// Declaring methods to perform actions on elements
		public void closepopup() {
			
			if(clickclosebutton.size() > 0) {
				clickclosebutton.get(0).click();
			}
		}
		
		public void SearchProduct(String productname) {
			FlipkartSearch.sendKeys(productname);
			FlipkartSearch.sendKeys(Keys.ENTER);
		}
		
		public void SelectProduct() {
			SelectProduct.click();
		}
		
		public float GetProductPrice() {
			String flipkartInitalPrice = GetProductPrice.getText();
			String flipkartsortPrice = flipkartInitalPrice.replace("₹", "").replace(",","");
			float flipkartPrice = Float.parseFloat(flipkartsortPrice);
			return flipkartPrice;
		}
		

}
