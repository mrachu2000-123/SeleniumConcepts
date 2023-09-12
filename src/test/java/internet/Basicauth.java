package internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basicauth {
	
	 WebDriver driver;

    @BeforeTest
        public void basicauthentication() throws InterruptedException {
    	
    	System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	
        driver = new ChromeDriver(options);

    	driver.get("https://the-internet.herokuapp.com/basic_auth");
    	Thread.sleep(2000);
    	driver.manage().window().maximize();
    	System.out.println("Window is Maximized");
    }
    @Test
    public void adc() throws InterruptedException {
    	System.out.println("Enter the Valid Credentials");
    	driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    	Thread.sleep(3000);
    	System.out.println("Logged In Successfully");
    	
    }
    @AfterTest
    public void adcs() {
    	driver.close();
    }
}
