package TestCases;

import org.testng.annotations.Test;

import PageObjects.Login;

public class TC_Login extends BaseTestcase{
@Test
void login() throws InterruptedException
{  
	Login lg=new Login(driver);
	lg.login();
	lg.phonenumber();
	lg.continueb();
	lg.submit();
}
}
