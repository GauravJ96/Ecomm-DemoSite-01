package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
public class TestCase1 {
	
private WebDriver driver;
private String baseUrl = "http://live.techpanda.org/index.php/";
private By mainText = By.tagName("h2");
private StringBuffer verificationErrors = new StringBuffer();
private By mobile = By.linkText("MOBILE");
private By dropDown = By.xpath("//select[@title='Sort By']");
private int scc = 0;
	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.chrome.driver",  "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	
	@Test
	public void testDay1TestCase1() throws IOException {
		//step1
		driver.get(baseUrl);
		//step2 get text
		String demosite = driver.findElement(mainText).getText();
		System.out.println(demosite);
		try {
			assertEquals(demosite, "THIS IS DEMO SITE FOR ");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		//step 3 click on mobile menu
		driver.findElement(mobile).click();
		
		//step 5 In the list of all mobile select dropdown sort by & click name
		
		new Select(driver.findElement(dropDown)).selectByVisibleText("Name");
		
		//step 6 verify all products are sorted
		//take screenshot of page
		scc = (scc + 1);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("C:\\Users\\gaura\\Selenium-Training\\ecomm-guru99\\resources\\screenshot"+ scc+".png");
		FileUtils.copyFile(scrFile, new File(png));
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}









