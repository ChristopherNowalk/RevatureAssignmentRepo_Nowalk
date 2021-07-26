package dev.nowalk.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.nowalk.pages.WikiMain;
import dev.nowalk.runners.WikiRunner;

public class WikiSeachStepImpl {

	public static WikiMain wikiMain = WikiRunner.wikiMain;
	public static WebDriver driver = WikiRunner.driver;
	
	@When("^The User types in \"([^\"]*)\" and presses Enter$")
	public void the_User_types_in_and_presses_Enter(String character) {
		wikiMain.searchBar.sendKeys(character + Keys.ENTER);
	}

	@Then("^The title of the article should be \"([^\"]*)\"$")
	public void the_title_of_the_article_should_be(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}
	
}
