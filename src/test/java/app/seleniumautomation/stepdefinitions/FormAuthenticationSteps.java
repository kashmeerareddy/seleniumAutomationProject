package app.seleniumautomation.stepdefinitions;
import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationSteps {
	public WebDriver driver;	
	public static Properties prop1,prop2;
	@Given("^I navigate to the form authentication link in the url$")
	public void navigate_to_form_authentication() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click on form authentication and enter username and password$")
	public void i_click_on_form_authentication_and_enter_credentials() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath(prop2.getProperty("form_authentication_link")));
		ActionsClass.clickWebElement(element);
		
		WebElement username = driver.findElement(By.id(prop2.getProperty("form_authentication_username")));
		ActionsClass.enterTextWebElement(username, prop1.getProperty("username"));
		
		WebElement password = driver.findElement(By.id(prop2.getProperty("form_authentication_password")));
		ActionsClass.enterTextWebElement(password, prop1.getProperty("password"));
		
		WebElement loginbutton = driver.findElement(By.xpath(prop2.getProperty("form_authentication_login_button")));
		ActionsClass.clickWebElement(loginbutton);
	}
	@Then("^validate login successful$")
	public void validate_login_successful() {
		WebElement logout = driver.findElement(By.linkText(prop2.getProperty("form_authentication_logout")));
		boolean loginSuccessful = ActionsClass.checkElementDisplayed(logout);
		assertTrue("Login was successful", loginSuccessful);
		driver.quit();
	}
}
