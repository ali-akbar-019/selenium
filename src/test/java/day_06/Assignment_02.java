package day_06;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02 {
	public static void main(String args[]) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://ali-akbar.vercel.app/");
		//
		//title
		System.out.println("Title->"+driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().to("https://google.com");
		System.out.println("Title->"+driver.getTitle());
		//
		Thread.sleep(2000);
		driver.navigate().back(); //go back
		driver.navigate().refresh(); //refresh the page
		Thread.sleep(3000);
		driver.navigate().forward(); // go forward
		Thread.sleep(1000);
		System.out.println("URL->"+driver.getCurrentUrl());
		driver.close();
		
		
	}
	
}
