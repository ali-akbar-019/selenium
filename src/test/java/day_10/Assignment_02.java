package day_10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02 {
	public static void main(String args[]) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Frames.html");
		//
		// first of all click the btn to be on the multi iframe tab
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		// now find the frame
		WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(frame1); // first iframe
		System.out.println("Inside the first frame: "
				+ driver.findElement(By.xpath("//h5[normalize-space()='Nested iFrames']")).getText());
		// now go deeper
		driver.switchTo().frame(0); // first frame in the outer frame
		WebElement innerFrameInput = driver.findElement(By.xpath("//input[@type='text']"));
		innerFrameInput.sendKeys("Hello i am ali akabr in the second frame");
		/// go to the parent
		driver.switchTo().parentFrame();
		//
		System.out.println("Inside the first frame: "
				+ driver.findElement(By.xpath("//h5[normalize-space()='Nested iFrames']")).getText());
		driver.switchTo().defaultContent();
		//
		System.out.println("Current Title->" + driver.getTitle());

		driver.close();
	}
}
