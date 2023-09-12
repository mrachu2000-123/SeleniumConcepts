package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FileDownload {

	public static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
	}

	@Test
	public void openBrowser() throws InterruptedException {

		// Open the URL Window
		driver.get("https://the-internet.herokuapp.com/download");
		System.out.println("URL is Opened");

		// Maximize the Window
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void scrolldown() throws InterruptedException {

		driver.findElement(By.xpath("(//*[@href='download/example.json'])")).click();
		Thread.sleep(3000);
		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		jsc.executeScript("window.scrollTo(0, 900)");
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void download() throws InterruptedException {

		System.out.println("MouseOver Action");
		Actions act = new Actions(driver);
		WebElement mover = driver.findElement(By.xpath("(//*[@href='download/sample.png'])"));
		Thread.sleep(3000);
		act.moveToElement(mover).click().build().perform();
		Thread.sleep(3000);

	}
	
	@AfterSuite
	public void close() throws InterruptedException {

		driver.close();
	}	
}
