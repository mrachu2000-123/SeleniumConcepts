package internet;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FileUpload {
	
	public static WebDriver driver;

	@Test
	public void upload() throws InterruptedException, AWTException, IOException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://the-internet.herokuapp.com/upload");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='dz-success-mark dz-clickable']")).click();
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		//Put the path address in the clipboard
		StringSelection ss = new StringSelection("C:\\Users\\rachanam\\Desktop\\upload\\selenium_img.jpg");
		rb.delay(2000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		rb.delay(2000);
		//paste the path
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		//Enter key will be pressed
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
		driver.close();
		
		
	}

}
