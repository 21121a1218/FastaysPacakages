package TestCases;

import org.testng.annotations.Test;

import org.testng.Assert;

import PageObjects.Booking;
import PageObjects.Login;
import PageObjects.Search;
import Utilities.DataProviders;

public class TC_FormValidations extends BaseTestcase{
	@Test(dataProvider = "FormData", dataProviderClass = DataProviders.class)
    public void form_validations(String Firstname,String Lastname,String age,String email,String Number,String exp) throws InterruptedException
    {
    	Login lg=new Login(driver);
    	lg.login();
    	lg.phonenumber();
    	lg.continueb();
    	lg.submit();
    	Thread.sleep(4000);
    	Search sr=new Search(driver);
    	//sr.Package();
    	sr.Destination("Kerala");
    	sr.persons("1");
    	sr.search();
    	 Booking bk=new Booking(driver);
    	 bk.seeavilability();
    	 bk.proceed();
    	 bk.title();
    	 bk.fs(Firstname);
    	 bk.ls(Lastname);
    	 bk.age(age);
    	 bk.email(email);
    	 bk.number(Number);
    	 bk.payproceed();
        if (exp.equalsIgnoreCase("Valid")) {
		    if (bk.payvalidation1(driver)) {
		        Assert.assertTrue(true, "Valid input accepted as expected.");
		    } else {
		        Assert.fail("Valid input was rejected!");
		    }
		} else if (exp.equalsIgnoreCase("InValid")) {
			 if (bk.payvalidation2(driver)) {
				 Assert.assertTrue(true, "Invalid input rejected as expected.");
	            } else {
	            	 Assert.fail("Invalid input was accepted!");
	            }
		    }
        
		}
}
