package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Baseclass{
	WebDriver driver;
	   public Login (WebDriver driver)
	   {
		   super(driver);
	   }

@FindBy(xpath="//a[normalize-space()='Sign In / Register']") WebElement signIn;

@FindBy(xpath="//input[@placeholder='Enter your number']") WebElement enterYourNumber;

@FindBy(xpath="//button[normalize-space()='Continue']") WebElement continueb;

@FindBy(xpath="//*[@id=\"root\"]/div/div/header/nav/div/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/button") WebElement submit;

@FindBy(xpath="//input[@placeholder='Enter your full name']") WebElement enterYourFullName;

@FindBy(xpath="//input[@placeholder='Enter email']") WebElement enterEmail;

@FindBy(xpath="//button[normalize-space()='SAVE AND CONTINUE']") WebElement sAVEANDCONTINUE;

@FindBy(xpath="//button[normalize-space()='SKIP']") WebElement sKIP;
public void login()
{
	signIn.click();
}
public void phonenumber()
{
	enterYourNumber.sendKeys("6300370135");
}
public void continueb() throws InterruptedException
{
	continueb.click();
	Thread.sleep(15000);
}
public void submit()
{
	submit.click();
}
public void skip()
{
	sKIP.click();
}
}
