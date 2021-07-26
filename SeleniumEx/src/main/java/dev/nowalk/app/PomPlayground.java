package dev.nowalk.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.nowalk.pages.WikiMain;

public class PomPlayground {

	public static void main(String[] args) {
		
		String driverPath = "C:/Users/cjyes/OneDrive/Desktop/Chrome Driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		
		WikiMain wikiMain = new WikiMain(driver);
		
		String url = "http://www.wikipedia.org/";
		driver.get(url);
		
		//wikiMain.english.click();
		wikiMain.clickEnglish();
		
		driver.get(url);
		
		wikiMain.clickJapanese();
		
		driver.get(url);
		
		wikiMain.clickSpanish();
		
		driver.get(url);
		
		wikiMain.clickGerman();
		
		driver.get(url);
		
		wikiMain.clickRussian();
		
		driver.get(url);
		
		wikiMain.clickFrench();
		
		//just a quick sleep so we can actually see what Selenium is doing
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}
}
