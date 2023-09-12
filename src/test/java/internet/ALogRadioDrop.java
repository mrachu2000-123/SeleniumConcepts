package internet;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ALogRadioDrop {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
	}

	@BeforeClass
	public void Openbrowser() throws InterruptedException, AWTException {

		driver.get("https://demo.guru99.com/test/newtours/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		Thread.sleep(5000);

		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		jsc.executeScript("window.scrollTo(0,200)");
		Thread.sleep(5000);

		System.out.println("zooming");

		Robot robot = new Robot();
		System.out.println("About to zoom in");
		for (int i = 0; i < 3; i++) {			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void login() throws InterruptedException, AWTException {
		System.out.println("Enter the Valid Username");

		driver.findElement(By.name("userName")).sendKeys("Admin");
		Thread.sleep(3000);

		System.out.println("Enter the Valid Password");

		driver.findElement(By.name("password")).sendKeys("Admin");
		Thread.sleep(3000);

		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		Thread.sleep(3000);

		driver.findElement(By.name("submit")).click();

		Thread.sleep(3000);
	}

	@Test
	public void Verifytitle() throws InterruptedException{
		String expResult = "Login Successfully";

		String actResult = driver.findElement(By.xpath("//*[contains(text(),'Login Successfully')]")).getText();

		if(expResult.equals(actResult)) {

			System.out.println("Login Successful");
		}
		else {

			System.out.println("Login Failed");

		}

		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(3000);
	}

	@Test
	public void dropdown() throws InterruptedException{

		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
		System.out.println("Radio Button is Selected");
		Thread.sleep(3000);

		WebElement drp= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select"));
		Select se = new Select(drp);
		List <WebElement> alloption = se.getOptions();

		for(WebElement option:alloption) {

			if(option.getText().equals("4")) {
				option.click();
				break;
			}
		}

		System.out.println("Dropdown is Done");
		Thread.sleep(3000);

		WebElement drp1= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select"));
		Select se1 = new Select(drp1);
		List <WebElement> alloption1 = se1.getOptions();

		for(WebElement option:alloption1) {

			if(option.getText().equals("Paris")) {
				option.click();
				break;
			}
		}

		System.out.println("Dropdown1 is Done");
		Thread.sleep(3000);

		WebElement drp2= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[1]"));
		Select se2 = new Select(drp2);
		List <WebElement> alloption2 = se2.getOptions();

		for(WebElement option:alloption2) {

			if(option.getText().equals("August")) {
				option.click();
				break;
			}
		}

		System.out.println("Dropdown2 is Done");
		Thread.sleep(3000);

		WebElement drp3= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select"));
		Select se3 = new Select(drp3);
		List <WebElement> alloption3 = se3.getOptions();

		for(WebElement option:alloption3) {

			if(option.getText().equals("Unified Airlines")) {
				option.click();
				break;
			}
		}

		System.out.println("Dropdown3 is Done");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		Thread.sleep(3000);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
