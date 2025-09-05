package PageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class History extends Baseclass{
	WebDriver driver;
	   public History(WebDriver driver)
	   {
		   super(driver);
	   }


@FindBy(xpath="//h1[normalize-space()='Hi, Traveller']") WebElement hiTraveller;

@FindBy(xpath="//h2[normalize-space()='My Bookings']") WebElement myBookings;

@FindBy(xpath="//select[contains(@class,'block w-full px-3 py-2 text-sm text-center text-white bg-black rounded-md outline-none md:w-1/3')]") WebElement allFlightsHotelsBuses;

@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div[1]/div/div[3]/button[2]") List <WebElement> viewpackageDetails;

@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div[2]/div/div[2]/button") WebElement cancelBooking;

@FindBy(xpath="//div//form//label//input") List <WebElement> Reason;

@FindBy(xpath="//button[normalize-space()='Next']") WebElement next;

@FindBy(xpath="//button[normalize-space()='Confirm']") WebElement confirm;

@FindBy(xpath="//button[normalize-space()='Back']") WebElement back;

@FindBy(xpath="//h2[normalize-space()='Booking Cancelled']") WebElement Cancellationmessage;

@FindBy(xpath="//button[normalize-space()='Upcoming']") WebElement upcoming;

@FindBy(xpath="//button[normalize-space()='PastBooking']") WebElement pastBooking;

@FindBy(xpath="//button[normalize-space()='Cancelled']") WebElement cancelled;

@FindBy(xpath="//input[@name='fromDate']") WebElement fromDate;

@FindBy(xpath="//input[@name='toDate']") WebElement toDate;

@FindBy(xpath="//button[normalize-space()='Reset']") WebElement reset;

@FindBy(xpath="//button[normalize-space()='Search']") WebElement search;

@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/div[2]/div[2]/div[1]/span[1]") List <WebElement> bookingdate;

@FindBy(xpath="//p[contains(.,'Cancelled')]") List <WebElement> cancelhistory;

public void details()
{
	hiTraveller.click();
}
public void myBookings()
{
	myBookings.click();
}
public void All()
{	
	Select hot=new Select(allFlightsHotelsBuses);
	hot.selectByContainsVisibleText("Packages");
}
public void bus()
{
	viewpackageDetails.get(0).click();
}
public void cancell()
{
	cancelBooking.click();
}
public void reason()
{
	Reason.get(1).click();
}
public void next()
{
	next.click();
}
public void back()
{
	back.click();
}
public void confirm()
{
	confirm.click();
}
public boolean cofirmcancel()
{
	if(!Cancellationmessage.getText().contains("Booking Cancelled"))
	{
		return false;
	}
	return true;
}
public void upcoming()
{
	upcoming.click();
}
public void pastBooking()
{
	pastBooking.click();
}
public void cancelled()
{
	cancelled.click();
}
public void reset()
{
	reset.click();
}
public boolean validateUpcomingBookings() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    LocalDate currentDate = LocalDate.now();

    for (WebElement checkIn : bookingdate) {
        String fullText = checkIn.getText().trim(); // e.g., "May 31, 2025"

        try {
            LocalDate bookingDate = LocalDate.parse(fullText, formatter);

            if (!bookingDate.isAfter(currentDate)) {
                System.out.println("Invalid upcoming booking found: " + fullText);
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Date parsing failed for: " + fullText);
            e.printStackTrace();
            return false;
        }
    }
    return true;
}
public boolean validatepastBookings() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    LocalDate currentDate = LocalDate.now();

    for (WebElement checkIn : bookingdate) {
        String fullText = checkIn.getText().trim(); // e.g., "May 31, 2025"

        try {
            LocalDate bookingDate = LocalDate.parse(fullText, formatter);

            if (!bookingDate.isBefore(currentDate)) {
                System.out.println("Invalid upcoming booking found: " + fullText);
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Date parsing failed for: " + fullText);
            e.printStackTrace();
            return false;
        }
    }
    return true;
}
public boolean Cancelled()
{
	for (WebElement cancelled : cancelhistory) {
		if(!cancelled.getText().contains("Cancelled"))
		{
			return false;
		}
	}
	return true;
}

}