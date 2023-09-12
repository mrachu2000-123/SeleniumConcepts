package internet;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NewTab {

	public static WebDriver driver;

	@Test
	public void newlink() throws InterruptedException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='opentab']")).click();
		System.out.println("New Tab is Opened");

		// Window Handling
		String parent1=driver.getWindowHandle();

		Set<String>s1=driver.getWindowHandles();

		Iterator<String> I2= s1.iterator();

		while(I2.hasNext())
		{

			String child1_window=I2.next();

			if(!parent1.equals(child1_window))
			{
				// Switch to New Tab from Parent Tab
				driver.switchTo().window(child1_window);

				driver.switchTo().window(child1_window);

				Thread.sleep(5000);

				// Scrolling the Child Window
				JavascriptExecutor jsc = (JavascriptExecutor) driver;
				jsc.executeScript("window.scrollTo(0,2950)");
				Thread.sleep(5000);
				WebElement link = driver.findElement(By.xpath("//*[@id=\"courses-block\"]/div[11]/div/div[1]/a"));
				link.click();
				Thread.sleep(3000);
				jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(3000);
				System.out.println("Title of the page is "+driver.getTitle());
				Thread.sleep(3000);
				driver.close();
				Thread.sleep(3000);

			}
		}
		
		driver.switchTo().window(parent1);
        Thread.sleep(3000);
		driver.close();

	}
}
