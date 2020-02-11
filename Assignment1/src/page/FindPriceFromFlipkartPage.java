package page;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BrowserFunction;

public class FindPriceFromFlipkartPage extends BrowserFunction {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public FindPriceFromFlipkartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaring elements using @FindBY annotation
	@FindBy(xpath = "//button[.='✕']")
	private List<WebElement> clickCloseButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchProduct;

	@FindBy(xpath = "//div[@class='_3SQWE6']")
	private WebElement selectProduct;

	@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]/../../../div[3]/div[1]/div[1]/div[1]")
	private WebElement getProductPrice;

	// Declaring methods to perform actions on elements
	public void closeLoginPopup() {

		if (clickCloseButton.size() > 0) {
			clickCloseButton.get(0).click();
		}
	}

	public void searchProduct(String productname) {
		wait.until(ExpectedConditions.visibilityOf(searchProduct));
		searchProduct.sendKeys(productname);
		searchProduct.sendKeys(Keys.ENTER);
	}

	public void selectProduct() {
		wait.until(ExpectedConditions.visibilityOf(selectProduct));
		selectProduct.click();
	}

	public float getProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(getProductPrice));
		String flipkartInitalPrice = getProductPrice.getText();
		String flipkartsortPrice = flipkartInitalPrice.replace("₹", "").replace(",", "");
		float flipkartPrice = Float.parseFloat(flipkartsortPrice);
		return flipkartPrice;
	}

}
