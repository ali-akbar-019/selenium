package day_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_03 {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/links");
		Thread.sleep(3000);
		//
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//
		System.out.println("Total Links: "+ links.size());
		System.out.println("Printing all the links------");
		for(WebElement link : links) {
			System.out.println(link.getText() + "->" + link.getAttribute("href"));
		}
		driver.close();
	}
}
