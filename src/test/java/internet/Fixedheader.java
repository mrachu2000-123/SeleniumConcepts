package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Fixedheader {
	
	public static WebDriver driver;

	@Test
	public void fixedheader() throws InterruptedException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//*[@class='tableFixHead']"));
		
		JavascriptExecutor jscm = (JavascriptExecutor) driver;
		((JavascriptExecutor)jscm).executeScript("window.scrollBy(0,730)", "");
		Thread.sleep(3000);
		
		jscm.executeScript("document.querySelector(\"body > div:nth-child(5) > div.right-align > fieldset:nth-child(2) > div.tableFixHead\").scrollTop=300");
		Thread.sleep(3000);
		
		System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//tr[4]")).getText()+" ");
		System.out.println();
		

		
	}

}
