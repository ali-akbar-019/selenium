package day_06;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {
	public static void main(String args[]) {
		
		ChromeDriver driver = new ChromeDriver();
		try {
			//
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//
			String title = driver.getTitle();
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Title: "+ title);
			System.out.println("Current Url: "+ currentUrl);
			//
			WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
			//fill the information
			username.sendKeys("tomsmith");
			password.sendKeys("SuperSecretPassword!");
			//sbmit button
			WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
			if(submitBtn.isDisplayed() && submitBtn.isEnabled()) {
				submitBtn.click();
			}
			
			String expctedOutput = "You logged into a secure area!";
			WebElement successText = driver.findElement(By.xpath("//div[@id='flash']"));
			if(successText.getText().contains(expctedOutput)) {
				System.out.println("Logged In!");
			}else {
				System.out.println("Error Logging In!");
			}
			//get the logout button
			WebElement logoutBtn = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
			//
			System.out.println("Current on->"+driver.getCurrentUrl());
			//click the btn
			logoutBtn.click();
			if(currentUrl.equals(driver.getCurrentUrl())) {
				System.out.println("Current on->"+driver.getCurrentUrl());
				System.out.println("Test Passed!");
			}else {
				System.out.println("Test Failed!");
			}
		
			driver.close();
		} catch (Exception e) {
			System.out.println("Error->"+ e.getLocalizedMessage());
			driver.close();
		}
	}
}
