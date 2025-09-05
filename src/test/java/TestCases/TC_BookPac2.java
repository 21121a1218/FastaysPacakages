package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Booking;
import PageObjects.Login;
import PageObjects.Payment;
import PageObjects.Search;

public class TC_BookPac2 extends BaseTestcase{
	@Test
	 void book() throws InterruptedException
	 {  
		 Login lg=new Login(driver);
		 lg.login();
			lg.phonenumber();
			lg.continueb();
			lg.submit();
		Search sr=new Search(driver);
		//sr.Package();
		sr.Destination("Kerala");
		sr.persons("1");
		sr.search();
		 Booking bk=new Booking(driver);
		 bk.seeavilability();
		 bk.premiumCouplesHoneymoonDel();
		 bk.proceed();
		 bk.title();
		 bk.fs("remo");
		 bk.ls("raja");
		 bk.age("23");
		 bk.email("calveensai@gmail.com");
		 bk.number("6300370135");
		 bk.payproceed();
		 Payment py=new Payment(driver);
		 py.bankpayment(driver);
		 Assert.assertTrue(py.home(), "Payment Failed");
}
}
