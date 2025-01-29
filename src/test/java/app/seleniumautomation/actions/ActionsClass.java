package app.seleniumautomation.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	private static WebDriver driver;

    // Constructor to initialize WebDriver if needed
    public ActionsClass(WebDriver driver)
    {
        this.driver = driver;
    }
	
	public static void clickWebElement(WebDriver driver,WebElement element)
	{
		element.click();
	}
	
	public static void enterTextWebElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static boolean checkElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public static void contextclick(WebDriver driver,WebElement element) {
		 Actions actions = new Actions(driver);
	        actions.contextClick(element).perform();
		
	}
	public static void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();  // Move mouse to element
    }
	public static void enterTextUsingActions(WebElement element, String text) {
		Actions actions = new Actions(driver);
        actions.moveToElement(element)  // Move to the element first (optional)
               .click()                // Click on the element (optional, needed for text fields)
               .sendKeys(text)         // Send the text
               .perform();
	}
	public static void draganddrop(WebDriver driver,WebElement source, WebElement target) {
		Actions actions=new Actions(driver);
	       actions.dragAndDrop(source, target).perform();

	}
	public static void moveByOffset(WebDriver driver) {
		Actions actions=new Actions(driver);
		 actions.moveByOffset(0, -100).build().perform();
	}

		
	}
