package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	private By title = By.tagName("h2");
	private By mobile = By.linkText("MOBILE");
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	
	public MobilePage clickOnMobile() {
		driver.findElement(mobile).click();
		return new MobilePage(driver);
	}
}
