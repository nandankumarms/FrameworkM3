package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.ExcelUtility;
import objectRepository.HomePage;
import objectRepository.RegisterPage;

public class RegisterTest extends BaseClass {

	@DataProvider(name = "registerData")
	public String[][] data() throws EncryptedDocumentException, IOException{
		return ExcelUtility.getRowData("RegisterData");
	}
	
	
	@Test(dataProvider = "registerData")
	public void register_001(String firstName, String lastName, String email, String password, String confirmPassword) {
		HomePage homePage=new HomePage(driver);
		RegisterPage registerPage=new RegisterPage(driver);
		//Click on log out link
//		homePage.getLogOutLink().click();
		
		//Click on register link
		homePage.getRegisterLink().click();
		
		//Click on Male radio button
		registerPage.getMaleRadioButton().click();
		
		//Enter first name
		registerPage.getFirstNameTF().sendKeys(firstName);
		
		//Enter Last name
		registerPage.getLastNameTF().sendKeys(lastName);
		
		//Enter email
		registerPage.getEmailTF().sendKeys(email);
		
		//Enter password
		registerPage.getPasswordTF().sendKeys(password);
		
		//ConfirmPassword
		registerPage.getConfirmPasswordTF().sendKeys(confirmPassword);
		
		//Click on Register button
	//	registerPage.getRegisterButton().click();
		
		
	}
	
	
}
