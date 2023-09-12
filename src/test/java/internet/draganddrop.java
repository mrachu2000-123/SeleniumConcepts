package internet;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class draganddrop {

	
	public static WebDriver driver;

    @Test
        public void dd() throws InterruptedException, AWTException{
    	
    	System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	
    	ChromeDriver driver = new ChromeDriver(options);

    	driver.get("https://demoqa.com/droppable/");
    	Thread.sleep(2000);
    	driver.manage().window().maximize();
    	System.out.println("Window is Maximized");
    	Thread.sleep(3000);
    	
    	JavascriptExecutor jscm = (JavascriptExecutor) driver;
		((JavascriptExecutor)jscm).executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
    	
    	WebElement from = driver.findElement(By.xpath("//*[@id='draggable']"));
    	WebElement to = driver.findElement(By.xpath("//*[@id='droppable']"));

    	System.out.println("zooming");

		Robot robot = new Robot();
		System.out.println("About to zoom in");
		for (int i = 0; i < 2; i++) {			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(5000);
    	
    	Actions act = new Actions(driver);
    	act.dragAndDrop(from, to).build().perform();
        //act.clickAndHold(src).moveToElement(tgt).release().build().perform();
        Thread.sleep(2000);
        
        System.out.println("Simple Drag And Drop Action is Performed");    
     
        
        driver.findElement(By.xpath("//*[@id=\"droppableExample-tab-accept\"]")).click();
        
        WebElement s1 = driver.findElement(By.xpath("//*[@id=\"acceptable\"]"));
        WebElement s2 = driver.findElement(By.xpath("(//*[@id=\"droppable\"])[2]"));
        
        Actions builder  = new Actions(driver);
        Action work = builder.clickAndHold(s1).moveToElement(s2).build();
        //.moveToElement(from)
        //.click()
        //.dragAndDrop(from, to)
        
        work.perform();
    	
       // driver.close();
       
    }
}
