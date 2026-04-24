package day_09;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_02 {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		// locators
		WebElement simpleAlert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']"));
		WebElement confirmAlert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']"));
		WebElement promptAlert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']"));
		// ----------
		//
		simpleAlert.click();
		myWait.until(ExpectedConditions.alertIsPresent());
		Alert firstAlert = driver.switchTo().alert();
		System.out.println("Simple Alert Text: " + firstAlert.getText());
		firstAlert.accept();
		//

		confirmAlert.click();
		myWait.until(ExpectedConditions.alertIsPresent());
		Alert secondAlert = driver.switchTo().alert();
		System.out.println("Confirm Alert Text: " + secondAlert.getText());
		secondAlert.dismiss();
		//
		//
		promptAlert.click();
		myWait.until(ExpectedConditions.alertIsPresent());
		Alert thirdAlert = driver.switchTo().alert();
		System.out.println("Confirm Alert Text: " + thirdAlert.getText());
		thirdAlert.sendKeys("Hello my name is ali akbar");
		thirdAlert.accept();
		// now validate
		WebElement res = driver.findElement(By.xpath("//p[@id='result']"));
		if (res.getText().equals("You entered: Hello my name is ali akbar")) {
			System.out.println("Alert tests Passed!");
		} else {
			System.out.println("Test Failed!");
		}
		driver.close();
	}

}
