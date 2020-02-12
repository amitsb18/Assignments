package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BrowserFunction;

public class FindPriceFromAmazonPage extends BrowserFunction {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public FindPriceFromAmazonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaring elements using @FindBy annotation
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchProduct;

	@FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']/img")
	private WebElement selectFirstProduct;

	@FindBy(xpath = "(//td[contains(.,'Price')])[2]/../td[2]/span[1]")
	private WebElement getProductPrice;

	// Declaring methods to perform actions on elements
	public void searchProduct(String productname) {
		searchProduct.sendKeys(productname);
		searchProduct.sendKeys(Keys.ENTER);
	}

	public void selectFirstProduct() {
		wait.until(ExpectedConditions.visibilityOf(selectFirstProduct));
		selectFirstProduct.click();

	}

	public float getProductPrice() {
		String amzonInitalPrice = getProductPrice.getText();
		String amazonsortPrice = amzonInitalPrice.replace("₹ ", "").replace(",", "");
		float amazonPrice = Float.parseFloat(amazonsortPrice);
		return amazonPrice;
	}
}
