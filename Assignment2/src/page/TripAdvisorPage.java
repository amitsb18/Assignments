package page;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BrowserFunction;

public class TripAdvisorPage extends BrowserFunction {

	Actions actions = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public TripAdvisorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaring elements using @FindBY annotation
	@FindBy(xpath = "//form[@class='R1IsnpX3']/input")
	private WebElement searchTextbox;

	// search for search textbox if first search textbox is not availabe
	@FindBy(xpath = "(//input[@type='search' and @title='Search'])[2]")
	private List<WebElement> searchAlternativeTextbox;

	@FindBy(xpath = "//input[@id= 'mainSearch']")
	private WebElement searchTrip;

	@FindBy(xpath = "//div[@class = 'ui_columns is-mobile result-content-columns']")
	private WebElement selectFirstResult;

	@FindBy(xpath = "//a[@class='ui_button primary' and text()='Write a review']")
	@CacheLookup
	private WebElement clickOnWritereviewButton;

	@FindBy(xpath = "//div[@class ='easyClear bigRatingParent']/span")
	private WebElement overallRating;

	@FindBy(xpath = "//input[@type= 'text']")
	private WebElement reviewTitle;

	@FindBy(xpath = "//div[@class = 'labelHeader' and text()='Hotel Ratings']")
	private List<WebElement> hotelRating;

	@FindBy(xpath = "//span[@id= 'qid12_bubbles']")
	private WebElement serviceRating;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement selectYourReviewCheckbox;

	// Declaring methods to perform actions on elements

	// Search for Club Mahindra in search textbox
	public void clickSearchTextbox() {
		if (searchAlternativeTextbox.size() > 0) {
			searchAlternativeTextbox.get(0).click();
			searchAlternativeTextbox.get(0).sendKeys("Club Mahindra");
			searchAlternativeTextbox.get(0).sendKeys(Keys.ENTER);
		} else {
			searchTextbox.click();
			searchTextbox.sendKeys("Club Mahindra");
			searchTextbox.sendKeys(Keys.ENTER);
		}
	}

	public void searchTrip(String text) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchTrip));
		searchTrip.sendKeys(text);
		Thread.sleep(2000);
		searchTrip.sendKeys(Keys.ENTER);
	}

	public void selectFirstResult() {
		selectFirstResult.click();
	}

	public void clickOnWritereviewButton() {
		actions.moveToElement(clickOnWritereviewButton).click().perform();
		;
	}

	// select 5 ratings by hovering the mouse
	public void overallRating() {
		wait.until(ExpectedConditions.visibilityOf(overallRating));
		actions.moveToElement(overallRating, 50, 0).click().perform();
	}

	// Enter review title
	public void enterReviewTitle() {
		reviewTitle.sendKeys("This is title review section");
	}

	// Select 5 start for hotel rating only if hotel rating section is available
	public void hotelRating() throws InterruptedException {
		if (hotelRating.size() > 0) {
			wait.until(ExpectedConditions.visibilityOf(serviceRating));
			actions.moveToElement(serviceRating, 50, 0).click().perform();
			Thread.sleep(3000);
		}
	}

	// Click on submit your review checkbox
	public void clickSubmitYourReviewCheckbox() throws InterruptedException {
		actions.moveToElement(selectYourReviewCheckbox).click().perform();
		Thread.sleep(5000);
	}

}
