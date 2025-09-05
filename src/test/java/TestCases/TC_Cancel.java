package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.History;
import PageObjects.Login;

public class TC_Cancel extends BaseTestcase{
	@Test  
void cancel() throws InterruptedException
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
	hr.bus();
	hr.cancell();
	hr.reason();
	hr.next();
	hr.confirm();
	Assert.assertTrue(hr.cofirmcancel(), "Cancellation Failed");
}
}
