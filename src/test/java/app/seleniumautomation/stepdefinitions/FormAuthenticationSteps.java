package app.seleniumautomation.stepdefinitions;
import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormAuthenticationSteps {
	public WebDriver driver;	
	public static Properties prop1,prop2,prop3;
	/*@Given("^I navigate to the form authentication link in the url$")
	public void navigate_to_form_authentication() throws IOException{
	
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	      
	}
	@When("^I click on form authentication and enter username and password$")
	public void i_click_on_form_authentication_and_enter_credentials() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath(prop2.getProperty("form_authentication_link")));
		ActionsClass.clickWebElement(driver, element);
		
		WebElement username = driver.findElement(By.id(prop2.getProperty("form_authentication_username")));
		ActionsClass.enterTextWebElement(username, prop1.getProperty("username"));
		
		WebElement password = driver.findElement(By.id(prop2.getProperty("form_authentication_password")));
		ActionsClass.enterTextWebElement(password, prop1.getProperty("password"));
		
		WebElement loginbutton = driver.findElement(By.xpath(prop2.getProperty("form_authentication_login_button")));
		ActionsClass.clickWebElement(driver,loginbutton);
	}
	@Then("^validate login successful$")
	public void validate_login_successful() {
		WebElement logout = driver.findElement(By.linkText(prop2.getProperty("form_authentication_logout")));
		boolean loginSuccessful = ActionsClass.checkElementDisplayed(logout);
		assertTrue("Login was successful", loginSuccessful);
		driver.quit();
	}*/
	//this is for negative and positive test 
	@Given("^I navigate to the form authentication link in the (.*)$")
	public void navigate_to_form_authentication(String url) throws IOException{
		
	prop1 = Utilities.readPropertiesFile("./TestData.properties");
	//driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"),("url"));
	String browserName = prop1.getProperty("browsername");
    driver = BrowserandURLConfiguration.BrowserandURLConfig(browserName, url);  
	}
	@When("^I click on form authentication and enter (.*) and (.*)$")
	public void i_click_on_form_authentication_and_enter_credentials(String username, String password) throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath(prop2.getProperty("form_authentication_link")));
		ActionsClass.clickWebElement(driver, element);
		
		WebElement usernamefield = driver.findElement(By.id("username"));
		usernamefield.sendKeys(username);
		
		WebElement passwordfield = driver.findElement(By.id("password"));
		passwordfield.sendKeys(password);
		
		WebElement loginbutton = driver.findElement(By.xpath(prop2.getProperty("form_authentication_login_button")));
		ActionsClass.clickWebElement(driver,loginbutton);
		
	}
	@Then("^validate login successful$")
	public void validate_login_successful()  {
		try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(prop2.getProperty("form_authentication_logout"))));
		//boolean loginSuccessful = ActionsClass.checkElementDisplayed(logout)q;
		//assertTrue("Login was successful", loginSuccessful);
		if(logout.isDisplayed()) {
			System.out.println("You logged into a secure area!");
		}
		}catch (Exception e) {
			System.out.println("Login failed. Checking error messages...");
		//try {
			WebElement errormessage=driver.findElement(By.xpath(prop2.getProperty("form_authentication_error_message")));
		if (errormessage.isDisplayed()) {
			System.out.println("errormessage:" +errormessage.getText());
		//}
		//}catch (NoSuchElementException ex)  {
			//System.out.println("errormessage is not displayed");
		}
		}
		finally {
		driver.quit();
	}
		}
	//this for giving multiple users and passwords in testdataproperties
	/*@Given("^I navigate to the form authentication link in the url$")
	public void navigate_to_form_authentication() throws IOException{
		//FileInputStream fis = new FileInputStream("./config.properties");
      // prop3=Utilities.readPropertiesFile("./config.properties");
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	      
	}
	@When("^I click on form authentication and enter username and password$")
	public void i_click_on_form_authentication_and_enter_credentials() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath(prop2.getProperty("form_authentication_link")));
		ActionsClass.clickWebElement(driver, element);
		
		WebElement username = driver.findElement(By.id(prop2.getProperty("form_authentication_username")));
		ActionsClass.enterTextWebElement(username, prop1.getProperty("username"));
		
		WebElement password = driver.findElement(By.id(prop2.getProperty("form_authentication_password")));
		ActionsClass.enterTextWebElement(password, prop1.getProperty("password"));
		
		WebElement loginbutton = driver.findElement(By.xpath(prop2.getProperty("form_authentication_login_button")));
		ActionsClass.clickWebElement(driver,loginbutton);
	}
	@Then("^validate login successful$")
	public void validate_login_successful() {
		try {
			 
			prop1=Utilities.readPropertiesFile("./TestData.properties");
			String usernames = prop1.getProperty("username");
			String passwords = prop1.getProperty("password");
			 String[] usernameArray = usernames.split(",");
	            String[] passwordArray = passwords.split(",");
			for (int i = 0; i < usernameArray.length; i++) {
				 String username = usernameArray[i].trim();  // Remove any extra spaces
	                String password = passwordArray[i].trim();  // Remove any extra spaces
	               // performLogin(username, password);
	                System.out.println();
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(prop2.getProperty("form_authentication_logout"))));
			if(logout.isDisplayed()) {
				System.out.println("You logged into a secure area!");
			}
	}catch (Exception e) {
		System.out.println("Login failed. Checking error messages...");
		WebElement errormessage=driver.findElement(By.xpath(prop2.getProperty("form_authentication_error_message")));
		if (errormessage.isDisplayed()) {
			System.out.println("errormessage:" +errormessage.getText());
			}return;
	}finally {
		driver.quit();}
		//return;*/
//}
	
		
	}




