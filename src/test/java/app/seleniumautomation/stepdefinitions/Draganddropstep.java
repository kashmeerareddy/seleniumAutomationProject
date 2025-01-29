package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void navigate_to_drag_and_drop_link_in_the_url() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I drag sourceelement and drop at targetelemnt$")
	public void i_drag_sourceelement_and_drop_at_targetelement() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement draganddrop = driver.findElement(By.linkText(prop2.getProperty("draganddrop")));
		ActionsClass.clickWebElement(driver,draganddrop);

		
		WebElement source = driver.findElement(By.id(prop2.getProperty("source")));
		
		WebElement target= driver.findElement(By.id(prop2.getProperty("target")));
		ActionsClass.draganddrop(driver, source, target);
		//Actions actions=new Actions(driver);
	     //  actions.dragAndDrop(source, target).perform();
		
	}

	@Then("^validate drag and drop functionality$")
	public void validate_drag_and_drop_functionality() throws InterruptedException {
		
		boolean issourceelementintarget = driver.findElement(By.id(prop2.getProperty("target"))).isDisplayed();
        boolean issourceelementmoved = driver.findElement(By.id(prop2.getProperty("source"))).isDisplayed();
    	Thread.sleep(5000);
    	 System.out.println(driver.findElement(By.id(prop2.getProperty("source"))).getText());
         System.out.println(driver.findElement(By.id(prop2.getProperty("target"))).getText());
        driver.quit();

	

	}
}


