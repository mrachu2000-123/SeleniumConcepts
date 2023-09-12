package internet;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class countcourse {
	
	public static WebDriver driver;

	@Test
	public void count() throws InterruptedException {

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://courses.rahulshettyacademy.com/courses");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

		WebElement a = driver.findElement(By.id("search-courses"));
		a.click();
		a.sendKeys("Selenium");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		
		List<WebElement> listResult= driver.findElements(By.xpath("//*[@class='course-listing-title']"));
		System.out.println("Total search Count"+" --- "+listResult.size());
		System.out.println();
		
		//if you want to print matching results
		
		for(WebElement results: listResult)
		{
			String value= results.getText();
			System.out.println(value);
			System.out.println();
		}     

		driver.close();
		
	}

}
