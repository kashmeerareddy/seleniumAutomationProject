package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DigestAuthenticationsteps {
	public WebDriver driver;	
	public static Properties prop1,prop2;
	 WebDriverWait wait;
	@Given("^I navigate to the digest authentication link in the url$")
	public void navigate_to_digest_authentication() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
		
	}
	@When("^I click on digest authentication and enter username and password and signin$")
	public void i_click_on_digest_authentication_and_enter_credentials() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
	}
	@Then("^validate digest auth$")
	public void validate_digest_auth() {
		WebElement digestauth = driver.findElement(By.xpath(prop2.getProperty("digest_auth_text")));
		boolean congratulations = ActionsClass.checkElementDisplayed(digestauth);
		assertTrue("Congratulations! You must have the proper credentials.", congratulations);
		driver.quit();
	}
}

