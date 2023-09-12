package TestNG1.TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Practice1 {
	
	public static WebDriver driver;
	
	@Test
	public void loginUrl(){
		System.setProperty("webdriver.chromedriver","drivers.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		// Open the URL Window
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("URL is Opened");
	}

}
