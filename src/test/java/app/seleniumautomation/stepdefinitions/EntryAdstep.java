package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EntryAdstep {
	public WebDriver driver = null;
	public static Properties prop1,prop2;
	@Given("^I navigate to the Entry Ad link in the url$")
	public void navigate_to_Entry_Ad_link_in_the_url() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click on close link modal window should be close$")
	public void i_click_on_close_link_modal_window_should_be_close() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		WebElement entryad=driver.findElement(By.xpath(prop2.getProperty("entry_ad")));
		ActionsClass.clickWebElement(driver, entryad);
		Thread.sleep(5000);
		WebElement close= driver.findElement(By.xpath(prop2.getProperty("close_link")));
		ActionsClass.clickWebElement(driver,close);
		System.out.println("Modal window should be closed");
		
	}
	@Then("^validate click here link again modal window should be reopen$")
	public void validate_click_here_link_again_modal_window_should_be_reopen() throws InterruptedException {
		WebElement clickhere = driver.findElement(By.xpath(prop2.getProperty("click_here")));
		ActionsClass.clickWebElement(driver, clickhere);
		System.out.println("Modal window should be open");
		Thread.sleep(5000);
		WebElement close= driver.findElement(By.xpath(prop2.getProperty("close_link")));
		boolean Thisisamodalwindow = ActionsClass.checkElementDisplayed(close);
		assertTrue("This is a modal window", Thisisamodalwindow);
		ActionsClass.clickWebElement(driver,close);
		driver.quit();
	}
}



