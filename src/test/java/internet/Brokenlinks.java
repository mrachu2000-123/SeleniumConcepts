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

public class Brokenlinks {

	public static WebDriver driver;
	
	@Test
	public void brokelinks() throws InterruptedException, IOException {

		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

	   driver = new ChromeDriver(options);

		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

		System.out.println("Find whether the links is broken or not");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for(WebElement link : links) {

			String linkURL = link.getAttribute("href");

			URL url = new URL(linkURL);

			URLConnection urlconn = url.openConnection();

			HttpURLConnection httpURLConnection = (HttpURLConnection) urlconn;

			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();

			if(httpURLConnection.getResponseCode()>=400) {
				System.out.println("Broken Links");
				System.out.println(linkURL+"--"+httpURLConnection.getResponseCode()+"--"+httpURLConnection.getResponseMessage());
				System.out.println();
			}
			else {
				System.out.println(linkURL+"--"+httpURLConnection.getResponseCode()+"--"+httpURLConnection.getResponseMessage());
				System.out.println();
			}

			httpURLConnection.disconnect();

		}

		driver.close();
	}


}
