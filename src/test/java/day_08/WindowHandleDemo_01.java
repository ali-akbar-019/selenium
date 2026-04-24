package day_08;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo_01 {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://a-dot.vercel.app");
		driver.manage().window().maximize();
		//
		// find a link and click
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// click on any link
		int count = 0;
		for (WebElement link : links) {
			link.click();
			count++;
			if (count >= 2) {
				break;
			}
		}
		//
		// now we should have three tabs open
		Set<String> winHdls = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		for (String id : winHdls) {
			driver.switchTo().window(id);

			System.out.println("Url of the page: " + driver.getCurrentUrl());

		}
		//
		// now go to the parent
		driver.switchTo().window(parent);
		//
		System.out.println("The Parent Url: " + driver.getCurrentUrl());
		driver.close();

	}
}
