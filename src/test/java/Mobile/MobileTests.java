package Mobile;

import org.testng.annotations.Test;

import base.BaseTests;

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
