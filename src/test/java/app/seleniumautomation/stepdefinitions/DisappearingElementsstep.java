package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisappearingElementsstep {
	public WebDriver driver;	
	public static Properties prop1,prop2;
	@Given("^I navigate to the Disappearing Elements link in the url$")
	public void navigate_to_the_Disappearing_Elements_link_in_the_url() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click on Home link$")
	public void i_click_on_Home_link() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement disappearingelements = driver.findElement(By.xpath(prop2.getProperty("disappearingelements_link")));
		ActionsClass.clickWebElement(driver,disappearingelements);
		
		WebElement home=driver.findElement(By.xpath(prop2.getProperty("home_link")));
		ActionsClass.clickWebElement(driver,home);
		System.out.println("navigate to  the home page");
	 }
    /* @And("^I click on About and Contact Us and Portfolio and Gallery link")
     public void click_on_About_and_Contact_Us_and_Portfolio_and_Gallery_link() {
    	 WebElement about=driver.findElement(By.linkText(prop2.getProperty("about_link")));
		ActionsClass.clickWebElement(driver,about);
		System.out.println("navigate to the https://the-internet.herokuapp.com/about/");
		driver.navigate().back();
		WebElement contactus=driver.findElement(By.xpath(prop2.getProperty("contact_us_link")));
		ActionsClass.clickWebElement(driver,contactus);
		System.out.println("navigate to the https://the-internet.herokuapp.com/contact-us/");
		driver.navigate().back();
		WebElement portfolio=driver.findElement(By.xpath(prop2.getProperty("portfolio_link")));
		ActionsClass.clickWebElement(driver,portfolio);
		System.out.println("navigate to the https://the-internet.herokuapp.com/portfolio/");
		driver.navigate().back();
		WebElement gallery=driver.findElement(By.xpath(prop2.getProperty("gallery_link")));
		ActionsClass.clickWebElement(driver,gallery);
		System.out.println("navigate to the https://the-internet.herokuapp.com/gallery/");
	}*/
	@Then("^validate the navigate page$")
	public void validate_the_navigate_page() {
		WebElement welcome = driver.findElement(By.xpath(prop2.getProperty("Welcometothe-internet")));
		boolean Welcometotheinternet = ActionsClass.checkElementDisplayed(welcome);
		assertTrue("Welcome to the-internet is not displayed", Welcometotheinternet);
		driver.navigate().back();
		WebElement disappearingElements = driver.findElement(By.xpath(prop2.getProperty("DisappearingElements")));
	    System.out.println(disappearingElements.getText());
		//System.out.println(driver.findElement(By.xpath(prop2.getProperty("DisappearingElements"))));
	   
	    driver.quit();
		
	}

}
