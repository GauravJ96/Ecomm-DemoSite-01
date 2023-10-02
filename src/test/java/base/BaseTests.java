package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.HomePage;

public class BaseTests {

	private WebDriver driver;
	protected HomePage homePage;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.firefox.driver", "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().window().maximize();
		
		homePage = new HomePage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
