package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment extends Baseclass{
  WebDriverWait wait;
	public Payment(WebDriver driver) {
		super(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	 @FindBy(xpath="//input[@placeholder='Card Number']") WebElement cardnumber;
	   @FindBy(xpath="//input[@placeholder='MM / YY']") WebElement exp;
	   @FindBy(xpath="//input[@placeholder='CVV']") WebElement cvv;
	   @FindBy(xpath="//input[@placeholder='Enter name on card']") WebElement name;
	   @FindBy(xpath="//input[@placeholder='Enter Email']") WebElement email;
	   @FindBy(xpath="//input[@name='save']") WebElement check;
	   @FindBy(xpath="//button[normalize-space(text())='Continue']") WebElement Continue;
	   @FindBy(xpath="//button[normalize-space(text())='Skip OTP']") WebElement skip;
	   @FindBy(xpath="//*[@id=\"overlay-backdrop\"]/div/div/div[2]/div/div/form/div[3]/button") WebElement bankpage;
	   @FindBy(xpath="/html/body/form/button[1]") WebElement success;
	   @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/button") WebElement home;
	   @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/h2[2]") WebElement paysuccess;
	   @FindBy(xpath="//*[@id=\"nav-sidebar\"]/div[1]/label[2]/div/div") WebElement netbanking;
	   @FindBy(xpath="//*[@id=\"main-stack-container\"]/div/div/div/div/div[2]/div/div/form[1]/div/label[1]/div/div/div/div/span") WebElement bod;
	   //@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/h2[2]") WebElement ;
	   /*@FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/h2[2]") WebElement paysuccess;
	   @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/h2[2]") WebElement paysuccess;
	   @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/div/div/h2[2]") WebElement paysuccess;*/
	   public void cardpayment(WebDriver driver) throws InterruptedException
	   {
		   WebElement seee = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe"))); 
		   driver.switchTo().frame(seee);
		   Thread.sleep(5000);
		   cardnumber.sendKeys("4111111111111111");
		   exp.sendKeys("12/28");
		   cvv.sendKeys("123");
		   name.sendKeys("garin");
		   email.sendKeys("calu@gmail.com");
		   check.click();
		   Continue.click();
		   skip.click();
		   Thread.sleep(5000);
		   bankpage.click();
		   Thread.sleep(3000);
		   String mainWindow = driver.getWindowHandle();
		    for (String windowHandle : driver.getWindowHandles()) {
		        if (!windowHandle.equals(mainWindow)) {
		            driver.switchTo().window(windowHandle);
		            break;}
		    }
		   success.click();
		   driver.switchTo().window(mainWindow); 
		 
	   }
	   public void bankpayment(WebDriver driver) throws InterruptedException
	   {
		   WebElement seee = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe"))); 
		   driver.switchTo().frame(seee);
		   Thread.sleep(5000);
		   netbanking.click();
		   bod.click();
		   Thread.sleep(3000);
		   String mainWindow = driver.getWindowHandle();
		    for (String windowHandle : driver.getWindowHandles()) {
		        if (!windowHandle.equals(mainWindow)) {
		            driver.switchTo().window(windowHandle);
		            break;}
		    }
		   success.click();
		   driver.switchTo().window(mainWindow); 
	   }
	   public boolean home() throws InterruptedException
	   {
		   Thread.sleep(10000);
		      if(!paysuccess.getText().equals("Payment Successful"))
		      {
		    	  return false;
		      }
		      home.click();
		      return true;
	   }

}
