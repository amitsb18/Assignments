package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPriceFromAmazonPage {

	public FindPriceFromAmazonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaring elements using @FindBy annotation
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchProduct;

	@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	private WebElement selectFirstProduct;

	@FindBy(xpath = "(//td[contains(.,'Price')])[2]/../td[2]/span[1]")
	private WebElement getProductPrice;

	// Declaring methods to perform actions on elements
	public void searchProduct(String productname) {
		searchProduct.sendKeys(productname);
		searchProduct.sendKeys(Keys.ENTER);
	}

	public void selectFirstProduct() {
		selectFirstProduct.click();

	}

	public float getProductPrice() {
		String amzonInitalPrice = getProductPrice.getText();
		String amazonsortPrice = amzonInitalPrice.replace("₹", "").replace(",", "");
		float amazonPrice = Float.parseFloat(amazonsortPrice);
		return amazonPrice;
	}
}
