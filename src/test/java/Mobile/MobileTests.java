package Mobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.MobilePage;

public class MobileTests extends BaseTests{

	
	@Test
	public void verifyTitle() {
		System.out.println(homePage.getTitle());
	}
	@Test
	public void verifyMobileTests() {
		var mobilePage = homePage.clickOnMobile();
		mobilePage.getTitle();
		mobilePage.clickOnSortBy();
	}
	
	
}
