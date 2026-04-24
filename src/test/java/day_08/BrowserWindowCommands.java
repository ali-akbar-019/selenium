package day_08;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowCommands {
	public static void main(String args[]) {
		// some of the browser commands
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		// maximize
		driver.manage().window().maximize();
		// minimize
		driver.manage().window().minimize();
		// full screen
		driver.manage().window().fullscreen();
		// set dimensions
		driver.manage().window().setSize(new Dimension(1080, 800));
		// get the height and the width
		Dimension dm = driver.manage().window().getSize();
		System.out.println("Current Height: " + dm.getHeight());
		System.out.println("Current Width: " + dm.getWidth());
		///
		/// set window position on the screen
		driver.manage().window().setPosition(new Point(0, 0));
		// get the position
		Point p = driver.manage().window().getPosition();
		// print them
		System.out.println("X: " + p.getX());
		System.out.println("Y:" + p.getY());
		driver.close();
	}
}
