package day_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		// navigational commands
		driver.navigate().to("https:/a-dot.vercel.app");
		driver.navigate().back(); /// come back
		System.out.println("Current url: " + driver.getCurrentUrl());
		driver.navigate().forward(); // go forward
		System.out.println("Current url: " + driver.getCurrentUrl());
		driver.navigate().refresh();
		System.out.println("All the navigational commands have been used");
		driver.close();
	}
}
