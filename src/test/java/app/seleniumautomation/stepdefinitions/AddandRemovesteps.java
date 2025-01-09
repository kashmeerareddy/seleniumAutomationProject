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

public class AddandRemovesteps {
	public WebDriver driver;	
	public static Properties prop1,prop2;
	@Given("^I navigate to the AddandRemove link in the url$")
	public void navigate_to_the_AddandRemove() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click addelement button then delete button should display$")
	public void i_click_addelement_button_then_delete_button_should_display() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.linkText(prop2.getProperty("AddRemoveElementslink")));
		ActionsClass.clickWebElement(element);
		
		WebElement AddElementbutton = driver.findElement(By.xpath(prop2.getProperty("//button[@onclick='addElement()']")));
		ActionsClass.clickWebElement(AddElementbutton);
		System.out.println("Delete button displayed");
	}
	@And("^I click on delete button then delete button should disappear$")
	public void i_click_on_delete_button_then_delete_button_should_disappear()  {
		WebElement Deletebutton = driver.findElement(By.xpath(prop2.getProperty("//button[@class='added-manually']")));
		ActionsClass.clickWebElement(Deletebutton);
		System.out.println("Delete button disappeared");
		
	}
	@Then("^validate Elemental Selenium link$")
	public void validate_Elemental_Selenium_link() {
		WebElement ElementalSeleniumlink = driver.findElement(By.linkText(prop2.getProperty("Elemental Selenium")));
		boolean ElementalSelenium = ActionsClass.checkElementDisplayed(ElementalSeleniumlink);
		assertTrue("Elemental Selenium", ElementalSelenium);
		driver.quit();
	}
}


