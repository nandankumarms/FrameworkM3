package testScripts;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepository.ComputersPage;
import objectRepository.DesktopsPage;
import objectRepository.HomePage;

public class ComputersTest extends BaseClass {

	@Test
	public void computer_001() throws IOException {
		HomePage homePage=new HomePage(driver);
		ComputersPage computersPage=new ComputersPage(driver);
		
		//Click on Computers link
		homePage.getComputersLink().click();
		
		//Verify ComputersPage is displayed
		String pageTitle=computersPage.getPageTitle().getText();
		
		//Take the screenshot of webpage
		getWebPageScreenshot(driver);
				
		//Take the screenshot of Page title
		getWebElementScreenshot(computersPage.getPageTitle());
		
		Assert.assertEquals(pageTitle, "Computers","Computers pagenot displayed");
	}
	
	@Test
	public void computers_desktop_001() {
		
		HomePage homePage=new HomePage(driver);
		ComputersPage computersPage=new ComputersPage(driver);
		DesktopsPage desktopsPage=new DesktopsPage(driver);
		
		//Click on COMPUTERS link
		homePage.getComputersLink().click();
		
		//Click on Desktops image
		computersPage.getDesktopsImage().click();
		
		//take Desktop page screenshot
		getWebPageScreenshot(driver);
		
		//Take Desktops page title screenshot
		getWebElementScreenshot(desktopsPage.getPageTitle());
	}
	
	
	@Test
	public void computers_002() {
		switchToWindowByTitle(driver, "Sign UP");
	}
}
