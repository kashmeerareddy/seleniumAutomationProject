package app.seleniumautomation.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ABTestingsteps {
   public WebDriver driver;
   public static Properties prop1, prop2;
 
   @Given("^I navigate to the AB Testing link in the url$")
   public void i_navigate_to_the_AB_Testing_link_in_the_url() throws IOException {
	   prop1=Utilities.readPropertiesFile("./TestData.properties");
	   driver=BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
   }
   @When("^I click on AB Testing then A/B Test Variation 1 and Elemental Selenium$")
   public void i_click_on_AB_Testing() throws IOException {
	   prop2=Utilities.readPropertiesFile("./locators.properties");
	   WebElement ABTestinglink=driver.findElement(By.linkText("A/BTestinglink"));
	   ActionsClass.clickWebElement(ABTestinglink);
	   System.out.println("A/B test variation 1 and ElementalSeleniumlink should be display");
   }
   @Then("^validate Elemental Selenium link$")
   public void validate_Elemental_Selenium_link() {
	   WebElement ElementalSeleniumlink=driver.findElement(By.linkText("ElementalSeleniumlink"));
	   boolean ElementalSelenium=ActionsClass.checkElementDisplayed(ElementalSeleniumlink);
	   assertTrue("Elemental Selenium", ElementalSelenium);
	   driver.quit();
   }
}
