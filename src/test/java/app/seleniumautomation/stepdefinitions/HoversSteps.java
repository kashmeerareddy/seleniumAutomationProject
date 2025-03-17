package app.seleniumautomation.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
public class HoversSteps {
 
	public WebDriver driver;
	public static Properties prop1, prop2;
	
	@Given ("^I navigate to the Hovers link in the url$")
	public void navigate_to_the_Hovers_link_in_the_url() throws IOException {
		prop1= Utilities.readPropertiesFile("./TestData.properties");
		driver=BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
		
	}
	@When ("^I hover over the first user image$")
	public void hover_over_the_first_user_image() throws IOException {
		prop2= Utilities.readPropertiesFile("./locators.properties");
		WebElement HoversLink=driver.findElement(By.xpath(prop2.getProperty("Hovers_Link")));
		ActionsClass.clickWebElement(driver, HoversLink);
		System.out.println("user will navigate to the hover over image page");
		WebElement firstuserimage=driver.findElement(By.xpath(prop2.getProperty("first_user_image")));
		ActionsClass.hoverOverElement(firstuserimage, driver);
	}
	@Then ("^I should see the details for the first user$")
	public void should_see_the_details_for_the_first_users() {
		WebElement firstuserdetails=driver.findElement(By.xpath(prop2.getProperty("first_user_details")));
		boolean userdetails=ActionsClass.checkElementDisplayed(firstuserdetails);
		assertTrue("user details are not displayed", userdetails);
		System.out.println(userdetails);
		
		//driver.quit();
	}
	@When ("^I hover over the second user image$")
	public void hover_over_the_second_user_image() throws IOException {
		prop2= Utilities.readPropertiesFile("./locators.properties");
		//WebElement HoversLink=driver.findElement(By.xpath(prop2.getProperty("Hovers_Link")));
		//ActionsClass.clickWebElement(driver, HoversLink);
		//System.out.println("user will navigate to the hover over image page");
		WebElement seconduserimage=driver.findElement(By.xpath(prop2.getProperty("second_user_image")));
		ActionsClass.hoverOverElement(seconduserimage, driver);
		System.out.println("hover over on the second user details");
	}
	@Then ("^I should see the details for the second user$")
	public void should_see_the_details_for_the_second_users() {
		WebElement seconduserdetails=driver.findElement(By.xpath(prop2.getProperty("second_user_details")));
		boolean userdetails2=ActionsClass.checkElementDisplayed(seconduserdetails);
		assertTrue("user details are not displayed", userdetails2);
		System.out.println(userdetails2);
		//driver.quit();
}
	@When ("^I hover over the third user image$")
	public void hover_over_the_third_user_image() throws IOException {
		prop2= Utilities.readPropertiesFile("./locators.properties");
		//WebElement HoversLink=driver.findElement(By.xpath(prop2.getProperty("Hovers_Link")));
		//ActionsClass.clickWebElement(driver, HoversLink);
		//System.out.println("user will navigate to the hover over image page");
		WebElement thirduserimage=driver.findElement(By.xpath(prop2.getProperty("third_user_image")));
		ActionsClass.hoverOverElement(thirduserimage, driver);
		System.out.println("hover over on the third user details");
	}
	@Then ("^I should see the details for the third user$")
	public void should_see_the_details_for_the_third_users() {
		WebElement thirduserdetails=driver.findElement(By.xpath(prop2.getProperty("third_user_details")));
		boolean userdetails3=ActionsClass.checkElementDisplayed(thirduserdetails);
		assertTrue("user details are not displayed", userdetails3);
		System.out.println(userdetails3);
		driver.quit();
	}	
}