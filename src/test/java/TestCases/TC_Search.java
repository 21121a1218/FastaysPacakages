package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Search;

public class TC_Search extends BaseTestcase{
	@Test
void search() throws InterruptedException {
	Search sr=new Search(driver);
	//sr.Package();
	sr.Destination("Andhra");
	sr.persons("1");
	sr.search();
	Assert.assertTrue(sr.searchValidation(),"Test case Failed");
}
}
