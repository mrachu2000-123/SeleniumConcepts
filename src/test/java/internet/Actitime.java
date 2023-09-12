package internet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Actitime {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver;
		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);	


		driver.get("https://demo.actitime.com/user/submit_tt.do");
		System.out.println("ActiTime is Opened");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("manager");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space()='Login']")).click();
		Thread.sleep(2000);
	 
       try
       {
           WebElement element1 = driver.findElement(By.xpath("(//*[contains(text(),'Nasa negotation')])"));
           element1.click();
           
           int r = driver.findElements(By.xpath("//tbody[@id='actualTTRows']/tr")).size();
   		System.out.println("Webtable row size =   "+r);
       }
    
       catch(Exception e) {
           WebElement element2 = driver.findElement(By.xpath("//*[@id='addTaskButtonId']"));
           element2.click();
           System.out.println("Creating a new task");
           Thread.sleep(2000);
           
           driver.findElement(By.xpath("(//div[@class='dropdownButton'])[5]")).click();
           Thread.sleep(3000);
           driver.findElement(By.xpath("//div[@class='searchItemList']//div[text()='Big Bang Company']")).click();
           System.out.println("New Customer is Selected");
           Thread.sleep(3000);
           driver.findElement(By.xpath("(//div[@class='dropdownButton'])[6]")).click();
           Thread.sleep(3000);
           driver.findElement(By.xpath("//div[@class='searchItemList']//div[text()='Flight operations']")).click();
           System.out.println("New Project is Selected");
           Thread.sleep(3000);
           
           WebElement crt = driver.findElement(By.xpath("(//*[@class='inputFieldWithPlaceholder'])[1]"));
           crt.click();
           crt.sendKeys("Nasa negotation");
           System.out.println("Task Name is Entered");
           Thread.sleep(3000);
           driver.findElement(By.xpath("//*[text()='Create Tasks']")).click();
           System.out.println("Task is Created");
           Thread.sleep(3000);
           
           int r = driver.findElements(By.xpath("//tbody[@id='actualTTRows']/tr")).size();
   		System.out.println("Webtable row size =   "+r);
           
           WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Nasa negotation')])"));
           element.click();
       }
       
       
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	

}
