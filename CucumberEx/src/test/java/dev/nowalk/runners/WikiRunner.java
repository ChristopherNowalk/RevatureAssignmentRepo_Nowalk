package dev.nowalk.runners;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.nowalk.pages.WikiMain;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.nowalk.steps")
public class WikiRunner {

	public static WebDriver driver;
	public static WikiMain wikiMain;
	
	//BEFORE all of the tests
	//these annotations are from JUnit
	@BeforeClass
	public static void setUp() {
		//all of this is mainly Selenium
		String path = "C:/Users/cjyes/OneDrive/Desktop/Chrome Driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		wikiMain = new WikiMain(driver);
		
		//if we wanted to use the waits, we would do it in the setup because thats where we define the driver
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}
	
	//Annotation is from JUnit
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
