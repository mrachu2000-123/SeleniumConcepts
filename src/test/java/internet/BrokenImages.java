package internet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrokenImages {
	
	public static WebDriver driver;

    @Test
        public void brokeimg() throws InterruptedException, IOException {
    	
    	System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	
    	ChromeDriver driver = new ChromeDriver(options);

    	driver.get("https://the-internet.herokuapp.com/broken_images");
    	Thread.sleep(2000);
    	driver.manage().window().maximize();
    	System.out.println("Window is Maximized");

    	System.out.println("Find whether the Image is broken or not");
        
    	List<WebElement> images = driver.findElements(By.tagName("img"));
    	System.out.println(images.size());
    	
    	for(WebElement image : images) {
    		String imagesrc = image.getAttribute("src");
    		
    		URL url = new URL(imagesrc);
    		
    		URLConnection urlconn = url.openConnection();
    		
    		HttpURLConnection httpURLConnection = (HttpURLConnection) urlconn;
    		
    		httpURLConnection.setConnectTimeout(5000);
    		httpURLConnection.connect();
    		
    		if(httpURLConnection.getResponseCode()==200) {
    			System.out.println(imagesrc+"--"+httpURLConnection.getResponseCode()
    			+"--"+httpURLConnection.getResponseMessage());
    			System.out.println();
    		}
    		else {
    			System.out.println("BrokenImage");
    			System.out.println(imagesrc+"--"+httpURLConnection.getResponseCode()
    			+"--"+httpURLConnection.getResponseMessage());
    			System.out.println();
    		}
    		
    		httpURLConnection.disconnect();
    		
    	}
    	driver.close();
    }

}
