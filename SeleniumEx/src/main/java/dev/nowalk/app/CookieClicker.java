package dev.nowalk.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieClicker {

	public static void main(String[] args) {
		String driverPath = "C:/Users/cjyes/OneDrive/Desktop/Chrome Driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://orteil.dashnet.org/cookieclicker/");
		
		WebElement bigCookie = driver.findElement(By.id("bigCookie"));
		
		while(true) {
			bigCookie.click();
		}
		
		//driver.quit();
	}

	
}
