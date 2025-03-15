package app.seleniumautomation.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
public class horizontalSliderSteps {
	public WebDriver driver;	
	public static Properties prop1,prop2;
	@Given("^I navigate to the Horizontal Slider link in the url$")
	public void navigate_to_the_Horizontal_Slider_link_in_the_url() throws IOException{
	
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	      
	}
	@When ("^I move the slider to the right$")
	public void move_the_slider_to_the_right() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		WebElement horizontalslider = driver.findElement(By.xpath(prop2.getProperty("horizontal_link")));
		ActionsClass.clickWebElement(driver, horizontalslider);
		System.out.println("navigated to the horizontal slider page");
		
		WebElement Slider=driver.findElement(By.xpath(prop2.getProperty("slider")));
		ActionsClass.slider(driver, Slider);
		
	}
	@Then("^validate the value change to a number greater than 0$")
	public void validate_the_value_change_to_a_number_greater_than_0() {
		WebElement value=driver.findElement(By.xpath(prop2.getProperty("value")));
		String valueText = value.getText();
		System.out.println("Slider Value: " + valueText);
		 try {
		        double sliderValue = Double.parseDouble(valueText); // Use Double.parseDouble() for decimal numbers
		        Assert.assertTrue("Slider value is not greater than 0", sliderValue > 0);
		        System.out.println("Slider value is greater than 0");
		    } catch (NumberFormatException e) {
		        Assert.fail("Slider value is not a valid number: " + valueText);
		        System.out.println("Slider value is not a valid number");
		    }
		
		    
		 driver.quit();
	}
}
