package internet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Alerts {
	
	public static WebDriver driver;

    @Test
        public void differntalert() throws InterruptedException{
    	
    	System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	
    	ChromeDriver driver = new ChromeDriver(options);

    	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    	Thread.sleep(2000);
    	driver.manage().window().maximize();
    	System.out.println("Window is Maximized");
    	Thread.sleep(3000);
    	
    	//Normal Alert
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
    	Thread.sleep(3000);
    	driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println("Normal Alert");

		//Confirmation Alert
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		System.out.println("Confirmation Alert");

		//Prompt Alert
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Thread.sleep(3000);
		Alert a = driver.switchTo().alert();
		Thread.sleep(3000);
		a.sendKeys("Selenium");
		Thread.sleep(3000);
		a.accept();
		Thread.sleep(3000);
		System.out.println("Confirmation Alert");

		Thread.sleep(3000);
		driver.close();
    	
    }
}
