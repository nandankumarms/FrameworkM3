package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
     super(driver);
	}
	
	
	@FindBy(partialLinkText = "Log in")
	private WebElement loginLink;

	@FindBy(partialLinkText = "Log out")
	private WebElement logOutLink;

	@FindBy(partialLinkText = "BOOKS")
	private WebElement bookLink;
	
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement computersLink;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	
	@FindBy(xpath = "//img[@alt='Picture of 14.1-inch Laptop']")
	private WebElement lapTopImage14dot1Inch;
	
	
	@FindBy(className = "search-box-button")
	private WebElement searchButton;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchTextField;
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}



	public WebElement getSearchButton() {
		return searchButton;
	}
	
	

	public WebElement getLapTopImage14dot1Inch() {
		return lapTopImage14dot1Inch;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getLogOutButton() {
		return logOutLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
	
	
}
