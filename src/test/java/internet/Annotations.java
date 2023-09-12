package internet;

import org.testng.annotations.*;

public class Annotations {
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("setup chrome, setpath for drivers");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("openchrome,chrome is invoked");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Open the Website");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Sign In");
	}
	
	@Test
	public void test() {
		System.out.println("Search for Product");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("Sign out");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("Close the website");
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("Close the browser and chrome");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("clean cookies and send report");
	}

}
