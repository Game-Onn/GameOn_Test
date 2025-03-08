package com.main.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Running...");
		
		System.setProperty("window.chrome.driver", "C:\\Users\\nichh\\Downloads\\Projects\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(1000);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://gameeonn.netlify.app/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		System.out.println("Site Opened...");
		
		System.out.println("Title = " + driver.getTitle());
		
		driver.quit();
		System.out.println("Site Close...");
	}
}
