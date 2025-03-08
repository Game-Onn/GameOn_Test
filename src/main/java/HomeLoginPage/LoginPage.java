package HomeLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Running...");
		
		System.setProperty("window.chrome.driver", "..\\..\\GameOn_Test\\Chrome_exe\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(1000);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.youtube.com/");
		//driver.get("https://gameeonn.netlify.app/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		System.out.println("Site Opened...");
		
		System.out.println("Title = " + driver.getTitle());
		
		WebElement searchBox = driver.findElement(By.name("search_query"));
		searchBox.sendKeys("arijit singh songs");
		WebElement searchButton = driver.findElement(By.xpath("//div[@id=\"center\"]//button[@title=\"Search\"]"));
		searchButton.click();
		Thread.sleep(4000);
		
		String searchBoxValue = searchBox.getAttribute("value");
		System.out.println("Search Items = " + searchBoxValue);
		
		driver.quit();
		System.out.println("Site Close...");
	}
}

