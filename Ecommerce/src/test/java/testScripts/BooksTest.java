package testScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;
import genericLibrary.UtilityMethods;
import objectRepository.BooksPage;
import objectRepository.HomePage;

public class BooksTest extends BaseClass {

	@Test
	public void books_001() {
		HomePage homePage=new HomePage(driver);
		BooksPage booksPage=new BooksPage(driver);
		
		//Click on BOOKS link
		homePage.getBookLink().click();
		test.log(LogStatus.INFO, "Clicke on Books link");
		
		//Verify Books page is displayed
		Assert.assertEquals(booksPage.getPageTitle().getText(), "Books","Books page is not displayed");
		test.log(LogStatus.PASS, "Books_001 is passed");
	}
	
	
	@Test
	public void books_002() {
		HomePage homepage=new HomePage(driver);
		BooksPage booksPage=new BooksPage(driver);
		
		//Click on BOOKS link
		homepage.getBookLink().click();
		test.log(LogStatus.INFO, "Clicled on books link");
		
		Select select=new Select(booksPage.getSortByDropDown());
		
		select.selectByIndex(2);
		test.log(LogStatus.INFO, "Option 3 is selected from dropdown");
		select.selectByIndex(3);
		test.log(LogStatus.INFO, "Option 4 is selected from dropdown");
		test.log(LogStatus.PASS, "books_002 is completed");
	}
	
	
	@Test
	public void book_003() throws IOException {
		
		HomePage homePage=new HomePage(driver);
		
		test.log(LogStatus.INFO, test.addScreenCapture(getWebPageScreenshot(driver)));
		
        test.log(LogStatus.INFO, test.addScreenCapture(getWebElementScreenshot(homePage.getLogOutButton())));		
		
		
	}
	
	
	@Test
	public void book_004() {
		
		HomePage homePage=new HomePage(driver);
		BooksPage booksPage=new BooksPage(driver);
		
		//Click on Books Link
		homePage.getBookLink().click();
		
		//Take books page screenshot
		getWebPageScreenshot(driver);
		
		//Take Page title screenshot
		getWebElementScreenshot(booksPage.getPageTitle());
		
		////Take sortby dropdown screenshot
		getWebElementScreenshot(booksPage.getSortByDropDown());
		test.log(LogStatus.FAIL, "Book paghe is not displayed");
		
		switchToWindowByTitle(driver, "Sign Up");			
	}
	
	

	
	
	
}
