package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {

	private WebDriver driver;
	private By pageTitle = By.tagName("h2");
	private By sortBy = By.xpath("//select[@title='Sort By']");
	
	public MobilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.findElement(pageTitle).getText();
	}
	public void clickOnSortBy() {
		new Select(driver.findElement(sortBy)).selectByVisibleText("Name");;
	}
	
}
