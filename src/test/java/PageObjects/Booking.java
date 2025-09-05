package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking extends Baseclass{
	WebDriverWait wait;
  public Booking(WebDriver driver)
  {
	  super(driver);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
  }

@FindBy(xpath="//button[normalize-space()='See Availability']") WebElement seeAvailability;

@FindBy(xpath="//p[normalize-space()='Wellness Deluxe Retreat Package']") WebElement wellnessDeluxeRetreatPackag;

@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div[2]/div[2]/div/div[1]/div/div[3]/label/p[1]") WebElement premiumCouplesHoneymoonDel;

@FindBy(xpath="//p[normalize-space()='Standard Package']") WebElement standardPackage;

@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div[2]/div[2]/div/div[2]/div/div[1]/span[2]/span") WebElement price;

@FindBy(xpath="//button[normalize-space()='PROCEED TO PASSENGER DETAILS']") WebElement pROCEEDTOPASSENGERDETAILS;

@FindBy(xpath="//select[@name='customerDetails[0].title']") WebElement selectTitleMrMsMrsDrProf;

@FindBy(xpath="//input[@placeholder='Enter First & Middle Name']") WebElement enterFirstMiddleName;

@FindBy(xpath="//input[@placeholder='Enter Last Name']") WebElement enterLastName;

@FindBy(xpath="//input[@placeholder='Enter Age']") WebElement enterAge;

@FindBy(xpath="//input[@placeholder='Enter Email Address']") WebElement enterEmailAddress;

@FindBy(xpath="//input[@placeholder='Enter Phone Number']") WebElement enterPhoneNumber;

@FindBy(xpath="//button[normalize-space()='PROCEED TO PAYMENT']") WebElement pROCEEDTOPAYMENT;

@FindBy(xpath="//div[@class='text-red-400 text-xs']") WebElement titleIsRequired;

@FindBy(xpath="//div[normalize-space()='First & Middle Name is required']") WebElement firstMiddleNameIsRequire;

@FindBy(xpath="//div[normalize-space()='Last Name is required']") WebElement lastNameIsRequired;

@FindBy(xpath="//div[normalize-space()='Age is required']") WebElement ageIsRequired;

@FindBy(xpath="//div[normalize-space()='email and phone number is required']") WebElement emailAndPhoneNumberIsRequ;

@FindBy(xpath="//div[@class='text-red-500 text-xs']") List<WebElement> validation;

@FindBy(xpath="//button[normalize-space()='+ Add Another Traveller']") WebElement AddAnotherTraveller;

@FindBy(xpath="//select[contains(@name,'customerDetails[1].title')]") WebElement selectTitleMrMsMrs;
@FindBy(xpath="//input[@name='customerDetails[1].firstName']") WebElement enterFirstmiddleName;
@FindBy(xpath="//input[@name='customerDetails[1].lastName']") WebElement enterlastName;
@FindBy(xpath="//input[@name='customerDetails[1].age.value']") WebElement enterage;
@FindBy(xpath="//input[@name='customerDetails[1].email']") WebElement enterEmailaddress;
@FindBy(xpath="//input[@name='customerDetails[1].phone']") WebElement enterPhonenumber;

public void seeavilability()
{
  wait.until(ExpectedConditions.visibilityOf(seeAvailability)).click();	
}
public void standard()
{
	wait.until(ExpectedConditions.visibilityOf(standardPackage)).click();
}
public void deluxe()
{
wait.until(ExpectedConditions.visibilityOf(wellnessDeluxeRetreatPackag)).click();
	}
public void premiumCouplesHoneymoonDel()
{
	wait.until(ExpectedConditions.visibilityOf(premiumCouplesHoneymoonDel)).click();
}
public void pricevalidforstandard()
{
	wait.until(ExpectedConditions.visibilityOf(price)).getText().contains("20000");
}
public void pricevalidfordeluxe()
{
	wait.until(ExpectedConditions.visibilityOf(price)).getText().contains("30000");
}
public void pricevalidforpremium()
{
	wait.until(ExpectedConditions.visibilityOf(price)).getText().contains("40000");
}
public void proceed()
{
	wait.until(ExpectedConditions.visibilityOf(pROCEEDTOPASSENGERDETAILS)).click();
}
public void payproceed()
{
	wait.until(ExpectedConditions.visibilityOf(pROCEEDTOPAYMENT)).click();
}
public boolean payvalidation1(WebDriver driver)
{
	WebElement seee = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe"))); 
	if(!seee.isDisplayed())
	{
		return false;
	}
	return true;
}
public boolean payvalidation2(WebDriver driver)
{
    for (int i=0;i<validation.size();i++)
    {
        if (!validation.get(i).isDisplayed())
        {
            return false;
        }
    }
    return true; 
}

public void title()
{
	Select tit=new Select(selectTitleMrMsMrsDrProf);
	tit.selectByContainsVisibleText("Mr");
}
public void fs(String fs)
{
	wait.until(ExpectedConditions.visibilityOf(enterFirstMiddleName)).sendKeys(fs);
}
public void ls(String ls)
{
	wait.until(ExpectedConditions.visibilityOf(enterLastName)).sendKeys(ls);
}
public void age(String age)
{
	wait.until(ExpectedConditions.visibilityOf(enterAge)).sendKeys(age);
}
public void email(String mail)
{
	wait.until(ExpectedConditions.visibilityOf(enterEmailAddress)).sendKeys(mail);
}
public void number(String num)
{
	wait.until(ExpectedConditions.visibilityOf(enterPhoneNumber)).sendKeys(num);
}
public void Title()
{
	Select tit=new Select(selectTitleMrMsMrs);
	tit.selectByContainsVisibleText("Mr");
}
public void fl(String fs)
{
	wait.until(ExpectedConditions.visibilityOf(enterFirstmiddleName)).sendKeys(fs);
}
public void ll(String ls)
{
	wait.until(ExpectedConditions.visibilityOf(enterlastName)).sendKeys(ls);
}
public void Age(String age)
{
	wait.until(ExpectedConditions.visibilityOf(enterage)).sendKeys(age);
}
public void Email(String mail)
{
	wait.until(ExpectedConditions.visibilityOf(enterEmailaddress)).sendKeys(mail);
}
public void Number(String num)
{
	wait.until(ExpectedConditions.visibilityOf(enterPhonenumber)).sendKeys(num);
}
public void invaliidlname()
{
	wait.until(ExpectedConditions.visibilityOf(lastNameIsRequired)).getText();
}
public void invaliidfname()
{
	wait.until(ExpectedConditions.visibilityOf(firstMiddleNameIsRequire)).getText();
}
public void invaliidage()
{
	wait.until(ExpectedConditions.visibilityOf(ageIsRequired)).getText();
}
public void invaliidemail()
{
	wait.until(ExpectedConditions.visibilityOf(emailAndPhoneNumberIsRequ)).getText();
}
public void addanother()
{
wait.until(ExpectedConditions.visibilityOf(AddAnotherTraveller)).click();
}
}
