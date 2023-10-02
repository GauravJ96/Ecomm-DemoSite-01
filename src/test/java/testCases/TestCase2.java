package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
public class TestCase2 {
	
private WebDriver driver;
private String baseUrl = "http://live.techpanda.org/index.php/";
//private StringBuffer verificationErrors = new StringBuffer();
private By mobile = By.linkText("MOBILE");
private By sonyPriceFromList = By.id("product-price-1");
private By sonyExperia = By.xpath("//a[text()='Sony Xperia']");
private By sonyPriceFromDetail = By.id("product-price-1");

	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.chrome.driver",  "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	
	@Test
	public void testDay2TestCase2() {
		//step1
		driver.get(baseUrl);
		//step2
		driver.findElement(mobile).click();
		//step3
		String listPrice = driver.findElement(sonyPriceFromList).getText();
		System.out.println(listPrice);
		//step4
		driver.findElement(sonyExperia).click();
		//step5
		String detailPrice = driver.findElement(sonyPriceFromDetail).getText();
		try {
			assertEquals(listPrice, detailPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}









