package dev.nowalk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiMain {

	public WebDriver driver;
	
	@FindBy(css = "div[lang='en']")
	public WebElement english;
	
	@FindBy(css = "div[lang='es']")
	public WebElement spanish;
	
	@FindBy(id = "searchInput")
	public WebElement searchBar;
	
	public WikiMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
