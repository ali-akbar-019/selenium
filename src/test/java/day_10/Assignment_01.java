package day_10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {
	public static void main(String args[]) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Frames.html");
		//
		// first of all click the btn to be on the single iframe tab
		driver.findElement(By.xpath("//a[normalize-space()='Single Iframe']")).click();
		// now lets get the iframe
		driver.switchTo().frame("SingleFrame");
		System.out.println("Inside the frame: " + driver.getCurrentUrl());
		// find the input
		WebElement inpField = driver.findElement(By.xpath("//input[@type='text']"));
		//
		Thread.sleep(200);
		//
		inpField.sendKeys("Hello i am ali akbar");
		// now get out
		driver.switchTo().defaultContent(); // go to the starting window
		System.out.println("URL-> " + driver.getCurrentUrl());
		driver.close();
	}
}
