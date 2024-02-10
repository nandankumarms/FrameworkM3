package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethods {
	static Select selectOption;
	static JavascriptExecutor jse;

	public static void selectOptionByIndex(WebElement dropdown, int index) {
		selectOption = new Select(dropdown);
		selectOption.selectByIndex(index);
	}

	public static void selectOptionByValue(WebElement dropdown, String value) {
		selectOption = new Select(dropdown);
		selectOption.selectByValue(value);
	}

	public static void selectOptionByVisibleText(WebElement dropdown, String text) {
		selectOption = new Select(dropdown);
		selectOption.selectByVisibleText(text);
	}

	public static String getWebPageScreenshot(WebDriver driver) {
		
		String imagePath="./Screenshots/"+getTime()+".png";
		
		//Step 1
				TakesScreenshot ts=(TakesScreenshot) driver;
				
				//Step 2
				File temp=ts.getScreenshotAs(OutputType.FILE);
				
				//Step 3
				File perm=new File(imagePath);
				
				
				//Step 4
				try {
					FileHandler.copy(temp, perm);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "."+imagePath;
	}

	public static String getWebElementScreenshot(WebElement element) {
		String imagePath="./Screenshots/" + getTime() + ".png";
		
		// Step 1
		File temp = element.getScreenshotAs(OutputType.FILE);

		// Step 2
		File perm = new File(imagePath);

		// Step 3
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "."+imagePath;
	}

	public static String getTime() {
		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}

	public static void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String childWindow : allWindows) {
			driver.switchTo().window(childWindow);

			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	public static void switchToWindowByURL(WebDriver driver, String url) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String childWindow : allWindows) {
			driver.switchTo().window(childWindow);

			if (driver.getTitle().contains(url)) {
				break;
			}
		}

	}
	
	public static  void initObjects(WebDriver driver) {
		jse=(JavascriptExecutor) driver;
	}
	
	public static void scrollWindowBy(int x, int y) {
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	public static void scrollWindowTo(int x, int y) {
		jse.executeScript("window.scrollTo("+x+","+y+")");
	}
	
	
	public static void scrollIntoView(WebElement element, boolean elementPosition) {
		jse.executeScript("arguments[0].scrollIntoView("+elementPosition+")", element);
	}
	
	public static void handleDisableOrHiddentButton(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}

	public static void handleHiddenOrDisabledTextField(WebElement element,String value) {
		jse.executeScript("arguments[0].value='"+value+"'", element);
	}
	
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}