package internet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebHandle {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		//navigate to the web page
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		//maximize the web page
		driver.manage().window().maximize();

	}
	@Test
	public void tc1() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 400)", "");

	}

	//Web table handling
	//*[@id="customers"]/tbody/tr[2]/td[1]
	//*[@id="customers"]/tbody/tr[3]/td[1]
	//*[@id="customers"]/tbody/tr[4]/td[1]
	@Test
	public void tc2() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\'customers\']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("number of rows present in table : " + rowCount);

		String beforeXpath = "//*[@id=\'customers\']/tbody/tr[";
		String afterXpath = "]/td[1]";

		for(int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());

			if(element.getText().equals("Island Trading")) {
				System.out.println("Company name:" + element.getText() + " is found at " + (i-1));
				break;
			}
		}

		System.out.println("**************");

		String afterXpathContact = "]/td[2]";
		for(int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpathContact;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());

		}

		System.out.println("*****************");

		String afterXpathCountry = "]/td[3]";
		for(int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpathCountry;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());

		}
		System.out.println("*****************");
	}



	//handle web table columns
	//*[@id="customers"]/tbody/tr[1]/th[1]
	//*[@id="customers"]/tbody/tr[1]/th[2]
	//*[@id="customers"]/tbody/tr[1]/th[3]
	@Test
	public void tc3() {
		String colBeforeXpath = "//*[@id=\'customers\']/tbody/tr[1]/th[";
		String colAfterXpath = "]";

		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
		int colCount = columns.size();
		System.out.println("Number of columns present in the table : " + colCount);

		for(int i=1; i<=colCount; i++) {
			String colActualXpath = colBeforeXpath + i + colAfterXpath ;
			WebElement element = driver.findElement(By.xpath(colActualXpath));
			System.out.println(element.getText());
		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}