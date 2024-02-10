package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BasePage {

	public BooksPage(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement pageTitle;
	
	@FindBy(id = "products-pagesize")
	private WebElement displayDropdown;
	
	
	public WebElement getDisplayDropdown() {
		return displayDropdown;
	}

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}

	@FindBy(id = "products-orderby")
	private WebElement sortByDropDown;

	public WebElement getPageTitle() {
		return pageTitle;
	}
	
	
}
