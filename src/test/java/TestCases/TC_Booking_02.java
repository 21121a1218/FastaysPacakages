package TestCases;

import org.testng.annotations.Test;

import PageObjects.Booking;
import PageObjects.Login;
import PageObjects.Search;

public class TC_Booking_02 extends BaseTestcase{
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
		sr.persons("2");
		sr.search();
		 Booking bk=new Booking(driver);
		 bk.seeavilability();
		 bk.proceed();
		 bk.title();
		 bk.fs("remo");
		 bk.ls("raja");
		 bk.age("23");
		 bk.email("calveensai@gmail.com");
		 bk.number("6300370135");
		 bk.addanother();
		 bk.Title();
		 bk.fl("rao");
		 bk.ll("raja");
		 bk.Age("24");
		 bk.Email("calveensai@gmail.com");
		 bk.Number("6300370135");
		 bk.payproceed();
		 bk.payproceed();
		 bk.payvalidation1(driver);
}
}