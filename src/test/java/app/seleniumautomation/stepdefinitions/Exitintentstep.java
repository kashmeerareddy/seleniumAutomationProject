package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Exitintentstep {
	public WebDriver driver = null;
	public static Properties prop1,prop2;
	@Given("^I navigate to the Exit intent link in the url$")
	public void navigate_to_the_Exit_intent_link_in_the_url() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I move my mouse out of the viewport$")
	public void i_move_my_mouse_out_of_the_viewport() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
       try {
        WebElement exitintent=driver.findElement(By.linkText(prop2.getProperty("exit_intent")));
   		ActionsClass.clickWebElement(driver, exitintent);
   		System.out.println("exit intent page will dislay");
   		WebElement exittext=driver.findElement(By.xpath(prop2.getProperty("exit")));
   		System.out.println("exit text is displayed ?? " + exittext.isDisplayed());
   		Actions actions = new Actions(driver);
   		actions.moveToElement(exittext);
   		ActionsClass.clickWebElement(driver, exittext);
   		//driver.getWindowHandle().
   	    
   		//WebElement exittext=driver.findElement(By.xpath(prop2.getProperty("exit")));
   		//ActionsClass.hoverOverElement(exittext);
   		ActionsClass.moveByOffset(driver, -100, -100);
   		System.out.println("Modal window will appear"); 
       }catch(Exception e){
    	   File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	   FileUtils.copyFile(screenshot,new File("./Screenshorts/Exitintent.png"));
       System.out.println(e);
       }
		
		
	}
	@Then("^verify the exit intent modal window appear$")
	public void verify_the_exit_intent_modal_window_appear() throws InterruptedException {
		Thread.sleep(5000); 
		boolean isModalWindowDisplayed = driver.findElement(By.xpath(prop2.getProperty("Modal_window"))).isDisplayed();
		 assertTrue("Modal window did not appear", isModalWindowDisplayed);
		 /*}
	@When("^I close the modal window$")
	 public void close_modal_window() {
	      WebElement closebutton=driver.findElement(By.xpath(prop2.getProperty("close"))); 
	      ActionsClass.clickWebElement(driver, closebutton);
		  System.out.println("After click on close button Modal window is closed");
	}
	@And("^I move my mouse out of the viewport again$")
	public void move_my_mouse_out_of_the_viewport_again() throws InterruptedException{
		Thread.sleep(5000);
		ActionsClass.moveByOffset(driver);
		System.out.println("Modal window should not appear");
	}
	@Then("^validate the modal window should not appear$")
    public void validate_modal_window_should_not_appear() {
        boolean isModalDisplayed = driver.findElement(By.xpath(prop2.getProperty("Modal_window"))).isDisplayed();
        assertTrue("Modal window appeared again", isModalDisplayed);*/
        driver.quit();
}
}