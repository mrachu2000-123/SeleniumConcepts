package internet;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchCount {

	public static WebDriver driver;

	@Test
	public void count() throws InterruptedException, IOException {

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("http://www.google.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("IBM");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		Thread.sleep(1000);
		List<WebElement> listResult= driver.findElements(By.xpath("//h3[contains(text(),'IBM')]"));
		System.out.println(listResult.size());
		//if you want to print matching results
		for(WebElement results: listResult)
		{
			String value= results.getText();
			System.out.println(value);
		}     

	}

}

