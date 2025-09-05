package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends Baseclass{
	WebDriverWait wait;
	public Search(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	}


@FindBy(xpath="//button[normalize-space()='Book a Package']") WebElement bookAPackage;

@FindBy(xpath="//input[@placeholder='Search for Destination...']") WebElement searchForDestination;

@FindBy(xpath="//input[@placeholder='Search City']") WebElement searchCity;

@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/form/div/div[1]/div/div/div/div[2]") WebElement andhraPradesh;

@FindBy(xpath="//input[@placeholder='Enter No. of person']") WebElement enterNoOfPerson;

@FindBy(xpath="//button[normalize-space()='Search']") WebElement search;

@FindBy(xpath="//p[contains(@class,'text-lg font-semibold text-foreground')]") WebElement showing1SearchResults;
public void Package()
{
	wait.until(ExpectedConditions.visibilityOf(bookAPackage)).click();
}
public void Destination(String dest) throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOf(searchForDestination)).click();
	wait.until(ExpectedConditions.visibilityOf(searchCity)).sendKeys(dest);
	wait.until(ExpectedConditions.visibilityOf(andhraPradesh)).click();
}
public void persons(String num)
{
	wait.until(ExpectedConditions.visibilityOf(enterNoOfPerson)).sendKeys(num);
}
public void search()
{
	wait.until(ExpectedConditions.visibilityOf(search)).click();
}
public boolean searchValidation()
{
	if(!wait.until(ExpectedConditions.visibilityOf(showing1SearchResults)).getText().contains("Search Results"))
	{
		return false;
	}
    return true;
	}
}



