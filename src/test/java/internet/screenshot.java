package internet;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class screenshot {
	
	public static WebDriver driver;

	@Test
	public void ss() throws InterruptedException, AWTException, IOException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(3000);
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f,new File(".//screenshot/sc2.png"));
		
		System.out.println("Screenshot is Taken");
		
		driver.close();

	}

}
