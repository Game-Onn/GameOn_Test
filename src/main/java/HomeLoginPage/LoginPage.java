package HomeLoginPage;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("Running...");
		
		//Below line is also used for declaring chromedriver.exe hardcoded path
		//System.setProperty("window.chrome.driver", "..\\..\\GameOn_Test\\Chrome_exe\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().clearResolutionCache().setup();
		//Wait for 1 sec
		Thread.sleep(1000);
		
		//Creating WebDriver interface
		WebDriver driver = new ChromeDriver();
		
		Actions action = new Actions(driver);
		
		//Opening below site
		driver.get("https://www.youtube.com/");
		//driver.get("https://gameeonn.netlify.app/");
		//Maximize window
		driver.manage().window().maximize();
		//Wait for 4 sec
		Thread.sleep(4000);
		System.out.println("Site Opened...");
		
		//Getting title of load URL
		System.out.println("Title = " + driver.getTitle());
		
		//Storing path in a variable
		WebElement searchBox = driver.findElement(By.name("search_query"));
		//Entering details in searchBox
		searchBox.sendKeys("arijit singh songs");
		
		//Storing path in a Variable
		WebElement searchButton = driver.findElement(By.xpath("//div[@id=\"center\"]//button[@title=\"Search\"]"));
		//Click on searchButton
		searchButton.click();
		//Wait for 4 sec
		Thread.sleep(4000);
		
		//Taking Screenshot
		ScreenshotUtil.takeScreenshot(driver, "FirstPage");
		
		//Getting Value from searchBox Variable
		String searchBoxValue = searchBox.getAttribute("value");
		System.out.println("Search Items = " + searchBoxValue);
	
		
		try {
			action.scrollByAmount(0, 1000).perform();
			//Wait for 4 sec
			Thread.sleep(4000);
		}
		catch(NoSuchElementException e) {
			System.out.println("Not able to Search element");
		}
		
		//Close Current Running Driver
		driver.quit();
		System.out.println("Site Close...");
	}
}

class ScreenshotUtil {
	public static void takeScreenshot(WebDriver driver, String screenShot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenShotPath = "..\\GameOn_Test\\Screenshot\\";
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(screenShotPath + screenShot + ".png");
		FileUtils.copyFile(srcFile, desFile);
	}
}