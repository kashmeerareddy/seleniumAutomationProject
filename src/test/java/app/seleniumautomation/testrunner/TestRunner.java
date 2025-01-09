package app.seleniumautomation.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html: cucumber/cucumber-reports/cucumber.html",
		"json: cucumber/cucumber-reports/cucumber.json" }, features = {
				"src/test/resources/features" }, glue = { "app.seleniumautomation.stepdefinitions" })
public class TestRunner extends AbstractTestNGCucumberTests {

}