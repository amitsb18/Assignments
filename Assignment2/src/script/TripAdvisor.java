package script;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import page.TripAdvisorPage;
import generic.BrowserFunction;

public class TripAdvisor extends BrowserFunction{
	

	@Test
	public void tripAdvisor() throws InterruptedException {
		
		OpenBrowser("https://www.tripadvisor.in");
		
		TripAdvisorPage trip = new TripAdvisorPage(driver);
		trip.clickSearchTextbox();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		trip.searchTrip("Club Mahindra");
		trip.selectFirstResult();
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
	    
	    trip.clickOnWritereviewButton();
	    
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(2));
	    
	    trip.overallRating();
	    
	    trip.enterReviewTitle();
	    
	    trip.hotelRating();
	    
	    trip.submitYourReviewCheckbox();
	    
	    
		
	}
	

}
