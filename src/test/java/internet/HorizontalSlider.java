package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HorizontalSlider {
	
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
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		System.out.println("URL is Opened");

		// Maximize the Window
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void slider() throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath("//input[@type='range']"));
		element.sendKeys(Keys.END);
		Thread.sleep(2000);
		driver.close();
		
	}

}
