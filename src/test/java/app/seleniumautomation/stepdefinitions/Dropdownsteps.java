package app.seleniumautomation.stepdefinitions;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dropdownsteps {
	public WebDriver driver = null;
	public static Properties prop1,prop2;
	@Given("^I navigate to the dropdown functionality in the url$")
	public void navigate_to_dropdown() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click on dropdown and I select a value from the dropdown$")
	public void i_select_a_vale_from_the_dropdown() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		driver.findElement(By.xpath(prop2.getProperty("dropdown_link"))).click();
		WebElement dropdown = driver.findElement(By.xpath(prop2.getProperty("dropdown_locator")));
		Select selectdropdownvalue = new Select(dropdown);
		selectdropdownvalue.selectByValue(prop2.getProperty("dropdown_value"));
		System.out.println(selectdropdownvalue.getFirstSelectedOption().getText());
	}
	@Then("^I validate if the selected value is populated$")
	public void validate_if_the_selected_value_is_populated() {
		WebElement dropdown = driver.findElement(By.xpath(prop2.getProperty("dropdown_locator")));
		dropdown.click();
		Select selectdropdownvalue = new Select(dropdown);
		System.out.println(selectdropdownvalue.getFirstSelectedOption().getText());
		driver.quit();
	}
}

