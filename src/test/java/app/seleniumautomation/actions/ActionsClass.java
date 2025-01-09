package app.seleniumautomation.actions;

import org.openqa.selenium.WebElement;

public class ActionsClass {
	
	public static void clickWebElement(WebElement element)
	{
		element.click();
	}
	
	public static void enterTextWebElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static boolean checkElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
}
