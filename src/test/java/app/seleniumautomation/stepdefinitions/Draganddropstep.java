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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Draganddropstep {
	public WebDriver driver;	
	public static Properties prop1,prop2;
	@Given("^I navigate to the Drag and Drop link in the url$")
	public void navigate_to_drag_and_drop() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I drag sourceelement and drop at targetelemnt$")
	public void i_drag_sourceelement_and_drop_at_targetelement() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement draganddrop = driver.findElement(By.linkText(prop2.getProperty("draganddrop")));
		ActionsClass.clickWebElement(driver,draganddrop);
		
		WebElement sourceelement = driver.findElement(By.id(prop2.getProperty("sourceelement")));
		
		WebElement targetelement = driver.findElement(By.id(prop2.getProperty("targetelemt")));
		ActionsClass.draganddrop(driver,sourceelement, targetelement);
		
		
		
	}
	@Then("^validate sourceelement text and targetelement text$")
	public void validate_text() {
		boolean issourceelemnt = driver.findElement(By.id(prop2.getProperty("targetelemt"))).isDisplayed();
        boolean istargetelement = driver.findElement(By.id(prop2.getProperty("sourceelement"))).isDisplayed();

      System.out.println(driver.findElement(By.id(prop2.getProperty("sourceelement"))).getText());
      System.out.println(driver.findElement(By.id(prop2.getProperty("targetelemt"))).getText());
       		driver.quit();
	}
}


