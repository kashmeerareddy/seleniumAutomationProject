package app.seleniumautomation.configuration;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserandURLConfiguration {
	static WebDriver driver = null;
	public static WebDriver BrowserandURLConfig(String BrowserName,String URL) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		return driver;
	}
}
