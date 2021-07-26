package dev.nowalk.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPlayground {
	
	public static void main(String[] args) {
		
		String driverPath = "C:/Users/cjyes/OneDrive/Desktop/Chrome Driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		
		//In this example we are testing three ways to search for something in google
		
		driver.get("http://www.google.com/");
		
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys("Vin Diesel Family memes");
		//this method will just press the enter key after the search bar is populated with the string
		//searchbar.sendKeys(Keys.ENTER);
		
		//so selenium went too fast and could not find the search button element, so here we can wait 500 ms until an exception is thrown 
		//this gives our browser time to catch up and show the button element we want
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		//this approach will choose the first selection that comes up in the recommended search bar
		//searchbar.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
		WebElement searchBtn = driver.findElement(By.name("btnK"));
		searchBtn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Selenium waits:
		 * 
		 * 3 main types:
		 * 
		 *  -Implicit Waits - Will wait up to a given amount of time before throwing an exception.
		 *  -Explicit Waits - Will wait until a certain condition occurs before proceeding with execution
		 *  -Fluent Waits - Will wait a maximum amount of time for a condition to occur and will check if the condition
		 *  appears at regular intervals.
		 */
		
		
		driver.quit();	//Closes all browsers managed by Selenium and shuts down the WebDriver
		//driver.close(); //simply closes the current browser
		
	}
}
