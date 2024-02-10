package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersPage extends BasePage {

	public ComputersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//img[@alt='Picture for category Desktops']")
	private WebElement desktopsImage;

	public WebElement getDesktopsImage()  {
		return desktopsImage;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}
	
	
	
	
	
	
	
	
}
