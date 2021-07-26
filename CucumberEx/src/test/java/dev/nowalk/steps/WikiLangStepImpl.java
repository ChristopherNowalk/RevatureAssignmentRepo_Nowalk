package dev.nowalk.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.nowalk.pages.WikiMain;
import dev.nowalk.runners.WikiRunner;

public class WikiLangStepImpl {

	//here we refer to the wikirunners wikiMain and driver obj
	public static WikiMain wikiMain = WikiRunner.wikiMain;
	public static WebDriver driver = WikiRunner.driver;
	
	
	@Given("^The Guest is on the Wikipedia Home Page$")
	public void the_Guest_is_on_the_Wikipedia_Home_Page() {
		driver.get("http://www.wikipedia.org/");
	}

	@When("^The Guest clicks English$")
	public void the_Guest_clicks_English() {
		wikiMain.english.click();
	}

	@Then("^The Guest should be on the English Home Page$")
	public void the_Guest_should_be_on_the_English_Home_Page() {
		Assert.assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
	}
	
	@When("^The Guest clicks Spanish$")
	public void the_Guest_clicks_Spanish() {
		wikiMain.spanish.click();
	}

	@Then("^The Guest should be on the Spanish Home Page$")
	public void the_Guest_should_be_on_the_Spanish_Home_Page() {
		Assert.assertEquals("Wikipedia, la enciclopedia libre", driver.getTitle());
	}
}
