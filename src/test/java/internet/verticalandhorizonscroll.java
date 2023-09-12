package internet;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class verticalandhorizonscroll {
	
	public static WebDriver driver;

	@Test
	public void vhs() throws InterruptedException, AWTException, IOException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.album.alexflueras.ro/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(10000,500)");
	    Thread.sleep(3000);
	    System.out.println("Horizontal and Vertical Sliding is Done");
		driver.close();
		
	}
}
