package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fileuploadsteps {

	public WebDriver driver = null;
	
	public static Properties prop1,prop2;
	@Given("^I navigate to the File upload link in the url$")
	public void navigate_to_the_File_upload__link_in_the_url() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I click on choose file$")
	public void i_click_on_choose_file() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		WebElement fileupload=driver.findElement(By.linkText(prop2.getProperty("file_upload_link")));
		ActionsClass.clickWebElement(driver, fileupload);
		System.out.println("select a document from list displayed");
		Thread.sleep(5000);
		WebElement choosefile=driver.findElement(By.xpath(prop2.getProperty("choose_file")));
		String filePath = "C:\\formau.xlsx";  
	    choosefile.sendKeys(filePath); 	
	    System.out.println("File selected for upload");
	    //choosefile.click();
	    System.out.println("selected file should be display next to the choose file");
	    
}
	@And("^I upload a file$")
	public void i_upload_a_file() throws InterruptedException, IOException {
		WebElement upload = driver.findElement(By.xpath(prop2.getProperty("upload_file")));
	    ActionsClass.clickWebElement(driver, upload);
	    System.out.println("navigate to the file uploaded page");
	}
	
	@Then("^validate the file upload is successful$")
	public void validate_the_file_upload_is_successful() throws InterruptedException, IOException{
	    WebElement fileuploaded = driver.findElement(By.xpath(prop2.getProperty("file_uploaded")));
		boolean file = ActionsClass.checkElementDisplayed(fileuploaded);
		assertTrue("file uploaded", file);
		driver.quit();
	
	}
}