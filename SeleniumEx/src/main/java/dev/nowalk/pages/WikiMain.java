package dev.nowalk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiMain {

	public WebDriver driver;
	//these are all valid ways to select something on a webpage
	@FindBy(id = "js-link-box-en")
	public WebElement english;
	
	@FindBy(id = "js-link-box-ja")
	public WebElement japanese;
	
	//what we are using here is the css attribute selector, we go into the div tag and then find the attribute we want in the brackets
	@FindBy(css = "div[lang='es']")
	public WebElement spanish;
	
	@FindBy(xpath = "//*[@id=\"js-link-box-de\"]")
	public WebElement german;
	
	@FindBy(xpath = "//*[@id=\"www-wikipedia-org\"]/div[2]/div[5]")
	public WebElement russian;
	
	@FindBy(xpath = "/html/body/div[2]/div[6]/a")
	public WebElement french;
	
	public WikiMain(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickEnglish() {
		this.english.click();
	}
	
	public void clickJapanese() {
		this.japanese.click();
	}
	
	public void clickSpanish() {
		this.spanish.click();
	}
	
	public void clickGerman() {
		this.german.click();
	}
	
	public void clickRussian() {
		this.russian.click();
	}
	
	public void clickFrench() {
		this.french.click();
	}
}
