package internet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyPresses {
	
	public static WebDriver driver;

	@Test
	public void key() throws InterruptedException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://the-internet.herokuapp.com/key_presses");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);
		
		act.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		
		act.sendKeys(Keys.SPACE).perform();
		Thread.sleep(3000);
		
		driver.close();
		
	}
}
