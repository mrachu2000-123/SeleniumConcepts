package internet;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class calender {

	public static WebDriver driver;

	@Test
	public void cal() throws InterruptedException, AWTException{

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(3000);

		JavascriptExecutor jscm = (JavascriptExecutor) driver;
		((JavascriptExecutor)jscm).executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='first_date_picker']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a")).click();
		Thread.sleep(2000);
		System.out.println("First date is selected");

		driver.findElement(By.xpath("//*[@id='second_date_picker']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a")).click();
		Thread.sleep(2000);
		System.out.println("Second date is selected");

		driver.findElement(By.xpath("//*[@id='third_date_picker']")).click();
		Thread.sleep(2000);
		for(int i = 3; i>=1; i--) {

			driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			Thread.sleep(2000);

			String m = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]/option["+i+"]")).getText();
			System.out.println(m);

			if(m.equals("Feb")) {
				driver.findElement(By.linkText("6")).click();
				break;
			}

		}
		System.out.println("Third date is selected");
	
		driver.findElement(By.xpath("//*[@id='fourth_date_picker']")).click();
		Thread.sleep(2000);

		Select y = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));
		y.selectByVisibleText("2025");


		for(int i = 11; i>=1; i--) {
			
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			Thread.sleep(2000);
				
			String m = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]/option["+i+"]")).getText();
			System.out.println(m);

			if(m.equals("Aug")) {
				driver.findElement(By.linkText("20")).click();
				break;
			}
		}
		System.out.println("Fourth date is selected");

		driver.findElement(By.xpath("//*[@id='fifth_date_picker']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a")).click();
		Thread.sleep(2000);
		System.out.println("Fifth date is selected");



		driver.findElement(By.xpath("//*[@id='sixth_date_picker']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(2000);

		for(int i = 3; i>=1; i--) {

			driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			Thread.sleep(2000);

			String m = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			System.out.println(m);

			if(m.equals("January")) {
				driver.findElement(By.linkText("20")).click();
				break;
			}
		}
		System.out.println("Sixth date is selected");
		driver.close();
	}

}
