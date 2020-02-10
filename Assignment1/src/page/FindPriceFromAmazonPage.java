package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPriceFromAmazonPage {
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement AmazonSearch;
	
	public FindPriceFromAmazonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchProduct(String productname) {
		AmazonSearch.sendKeys(productname);
		AmazonSearch.sendKeys(Keys.ENTER);
	}
	
	@FindBy(xpath ="//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	private WebElement SelectProduct;
	
	
	public void SelectProduct() {
		SelectProduct.click();
	}
	
	@FindBy(xpath = "//td[.='Price:']/../td[2]/span[1]")
	private WebElement GetProductPrice;
	

	public float GetProductPrice() {
		String amzonInitalPrice = GetProductPrice.getText();
		String amazonsortPrice = amzonInitalPrice.replace("₹", "").replace(",","");
		float amazonPrice = Float.parseFloat(amazonsortPrice);
		return amazonPrice;
	}
}
