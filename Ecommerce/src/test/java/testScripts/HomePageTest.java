package testScripts;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepository.HomePage;

public class HomePageTest extends BaseClass {

	@Test
	public void homepage_001() throws InterruptedException {
		//Scroll drown the window by 200 Pixel
		Thread.sleep(2000);
		scrollWindowBy(0, 1000);
		Thread.sleep(2000);
		scrollWindowBy(0, -500);
		Thread.sleep(2000);
		scrollWindowTo( 0, 700);
		Thread.sleep(2000);
		scrollWindowTo(0, 300);
		
		Thread.sleep(5000);
	}
	
	@Test
	public void homePage_002() throws InterruptedException {
		HomePage home=new HomePage(driver);
		//Scroll until Laptop image present in the top of the webpage
		scrollIntoView( home.getLapTopImage14dot1Inch(), true);
		Thread.sleep(3000);
		scrollIntoView(home.getLapTopImage14dot1Inch(), false);
		Thread.sleep(5000);
	}
	
	@Test
	public void homePage_003() {
		HomePage homepage=new HomePage(driver);
		
		//Click on disabled Button
		handleDisableOrHiddentButton(homepage.getSearchButton());
		
		//Aceept alert
		acceptAlert(driver);
		
		//Enter text into disabled text field
		handleHiddenOrDisabledTextField(homepage.getSearchTextField(), "Books");
		
	}
}
