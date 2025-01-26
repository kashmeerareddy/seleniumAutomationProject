package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contextmenusteps {

	public WebDriver driver;	
	public static Properties prop1,prop2;
	@Given("^I navigate to the context menu link in the url$")
	public void navigate_to_context_menu() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click on context menu box$")
	public void i_click_on_context_menu_box() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		
		WebElement contextmenulink=driver.findElement(By.linkText(prop2.getProperty("Context_Menu")));
		ActionsClass.clickWebElement(driver,contextmenulink);
		
		WebElement contextmenubox=driver.findElement(By.xpath(prop2.getProperty("Context_menu_box")));
		ActionsClass.contextclick(driver,contextmenubox);
		
		System.out.println("Alert box will display");
	}
	@Then("^validate the alert$")
	public void validate_the_alert() throws InterruptedException {
		Thread.sleep(5000);
        Alert cm=driver.switchTo().alert();
        assertEquals(cm.getText(),"You selected a context menu");
        System.out.println(cm.getText());
        cm.accept();
        driver.quit();
	}
}

