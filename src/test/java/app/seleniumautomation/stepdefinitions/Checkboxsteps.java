package app.seleniumautomation.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.IOException;
//import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;


	public class Checkboxsteps {
		
		public WebDriver driver;	
		public static Properties prop1,prop2;
		@Given("^I navigate to the checkbox link in the url$")
		public void navigate_to_the_checkbox() throws IOException {
			prop1 = Utilities.readPropertiesFile("./TestData.properties");
			driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
		}
		@When("^checkbox is selected$")
		public void checkbox_is_selected() throws InterruptedException, IOException {
			prop2 = Utilities.readPropertiesFile("./locators.properties");
			Thread.sleep(5000);
			
			WebElement checkbox = driver.findElement(By.xpath(prop2.getProperty("checkbox_link")));
			ActionsClass.clickWebElement(driver,checkbox);
			
			if(driver.findElement(By.xpath(prop2.getProperty("checkbox1"))).isSelected()) {
				System.out.println("Checkbox is already selected");
			}
			else {
				WebElement checkbox1=driver.findElement(By.xpath(prop2.getProperty("checkbox1")));
				ActionsClass.clickWebElement(driver,checkbox1);
				System.out.println(driver.findElement(By.xpath(prop2.getProperty("checkbox1"))).isSelected());
				System.out.println("After click Checkbox1 is selected");
				}
		 }
	     @And("^unselect the selected checkbox")
	     public void unselect_the_selected_checkbox() {
	    	 if(driver.findElement(By.xpath(prop2.getProperty("checkbox2"))).isSelected()) {
					System.out.println("Before performing click operation for Checkbox2");
					System.out.println("Checkbox 2 is already selected");
					WebElement checkbox2=driver.findElement(By.xpath(prop2.getProperty("checkbox2")));
					ActionsClass.clickWebElement(driver,checkbox2);
					System.out.println("After performing click operation for Checkbox2");
					System.out.println("Checkbox2 is unselected");
				}
				else {
					System.out.println("Checkbox 2 is already unchecked.");
				}

			
		}
		@Then("^validate the checkbox is enable or disable$")
		public void validate_the_checkbox_is_enable_or_disable() {
			boolean isCheckbox1Enabled = driver.findElement(By.xpath(prop2.getProperty("checkbox1"))).isEnabled();
	        boolean isCheckbox2Enabled = driver.findElement(By.xpath(prop2.getProperty("checkbox2"))).isEnabled();

	        System.out.println("Checkbox 1 is enabled: " + isCheckbox1Enabled);
	        System.out.println("Checkbox 2 is enabled: " + isCheckbox2Enabled);
			driver.quit();
		}
}