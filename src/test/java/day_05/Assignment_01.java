package day_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {
	public static void main(String args[]) throws InterruptedException {
		//its the Xpath axis lecture
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		//
		Thread.sleep(2000);
		//locators 
		WebElement username = driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")); 
		WebElement password = driver.findElement(By.xpath("//label[@for='password']/following-sibling::input")); 
		WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']/parent::button"));

		//
		String expectedOut ="Your username is invalid!";
		username.sendKeys("ali akbar");
		password.sendKeys("123");
		loginBtn.click();
		Thread.sleep(2000);
		WebElement outputMsg = driver.findElement(By.xpath("//div[@id='flash-messages']/descendant::div"));
		if(outputMsg.getText().contains(expectedOut)) {
			System.out.print("Passed");
		}else {
			System.out.println("Failed");
		}
		driver.close();
	}
}
