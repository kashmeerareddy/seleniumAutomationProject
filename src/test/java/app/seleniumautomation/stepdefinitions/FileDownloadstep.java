package app.seleniumautomation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.seleniumautomation.actions.ActionsClass;
import app.seleniumautomation.configuration.BrowserandURLConfiguration;
import app.seleniumautomation.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileDownloadstep {

	public WebDriver driver = null;
	private String downloadDirectory = "C:\\Users\\adaps\\Downloads";
	public static Properties prop1,prop2;
	@Given("^I navigate to the File Download link in the url$")
	public void navigate_to_the_File_Download_link_in_the_url() throws IOException {
		prop1 = Utilities.readPropertiesFile("./TestData.properties");
		driver = BrowserandURLConfiguration.BrowserandURLConfig(prop1.getProperty("browsername"), prop1.getProperty("url"));
	}
	@When("^I download a file$")
	public void i_download_a_file() throws InterruptedException, IOException {
		prop2 = Utilities.readPropertiesFile("./locators.properties");
		Thread.sleep(5000);
		WebElement filedownload=driver.findElement(By.linkText(prop2.getProperty("file_download")));
		ActionsClass.clickWebElement(driver, filedownload);
		System.out.println("file downloader page will dislay");
		Thread.sleep(5000);
		WebElement somefile= driver.findElement(By.linkText(prop2.getProperty("some_file")));
		ActionsClass.clickWebElement(driver,somefile);
		System.out.println("click on the some file");
		
	}
	@Then("^validate the downloaded file$")
	public void validate_the_downloaded_file() throws InterruptedException {
		File downloadedFile = new File(downloadDirectory+ "/some-file.txt");
		Thread.sleep(30000);
		
		boolean isDownloaded = false;
		assertTrue("file is not downloaded", isDownloaded);
		if(downloadedFile.exists()) {
			isDownloaded = true;
		}
		System.out.println("File downloaded successfully.");
		driver.quit();
	}
}
