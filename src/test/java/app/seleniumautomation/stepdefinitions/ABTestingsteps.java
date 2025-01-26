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
   @When("^I click on AB Testing then Elemental Selenium$")
   public void i_click_on_ab_testing_then_elemental_selenium() throws IOException, InterruptedException {
	   prop2=Utilities.readPropertiesFile("./locators.properties");
	   Thread.sleep(5000);
	   WebElement ABTestinglink=driver.findElement(By.xpath(prop2.getProperty("A_B_Testing_link")));
	   ActionsClass.clickWebElement(driver,ABTestinglink);
	   System.out.println("A_B test variation 1 and ElementalSeleniumlink should be display");
   }
   @Then("^validate Elemental Selenium$")
   public void validate_Elemental_Selenium() {
	   WebElement ElementalSeleniumlink=driver.findElement(By.linkText(prop2.getProperty("ElementalSeleniumlink")));
	   boolean ElementalSelenium=ActionsClass.checkElementDisplayed(ElementalSeleniumlink);
	   assertTrue("Elemental Selenium", ElementalSelenium);
	   driver.quit();
   }
}
