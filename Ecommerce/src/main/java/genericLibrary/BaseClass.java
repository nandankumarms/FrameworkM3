package genericLibrary;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass extends UtilityMethods {

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeSuite
	public void beforeSuite() {
		report=new ExtentReports("./Reports/"+getTime()+".html");
		System.out.println("Before suite");
	}

	@AfterSuite
	public void afterSuite() {
		report.flush();
		System.out.println("After Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		
		String url=FileUtility.getProperty("url");
		String browser=FileUtility.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		initObjects(driver);
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("After Class");
	}

	@BeforeMethod
	public void beforeMethod(Method method) throws IOException {
		String methodName=method.getName();
		test=report.startTest(methodName);
		HomePage homePage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
		
		//Click on Login link
		homePage.getLoginLink().click();
		
		//Enter email address
		loginPage.getEmailTextField().sendKeys(FileUtility.getProperty("email"));
		
		//Enter the password
		loginPage.getPasswordtextField().sendKeys(FileUtility.getProperty("password"));
		
		//Click on login button
		loginPage.getLoginButton().click();

	}

	@AfterMethod
	public void AfterMethod() {
		
		report.endTest(test);
		//Click on Log out link
		HomePage homePage=new HomePage(driver);
		homePage.getLogOutButton().click();
	}
	
}
