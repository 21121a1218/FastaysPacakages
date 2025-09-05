package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.History;
import PageObjects.Login;
import freemarker.core.ParseException;

public class TC_History_Upcomming extends BaseTestcase{
@Test
	void History() throws InterruptedException, ParseException
{
	Login lg=new Login(driver);
	lg.login();
	lg.phonenumber();
	lg.continueb();
	lg.submit();
    History hr=new History(driver);
    hr.details();
	hr.myBookings();
	hr.All();
    hr.upcoming();
    Assert.assertTrue(hr.validateUpcomingBookings(),"Failed");
}
}
